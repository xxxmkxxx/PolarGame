package com.xxxmkxxx.services;

import com.xxxmkxxx.dao.UserDAO;
import com.xxxmkxxx.models.UserModel;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@PropertySource(value = "classpath:messages.properties", encoding = "UTF-8")
public class UserService {
    private Environment environment;
    private UserDAO userDAO;

    @Transactional
    public UserModel getUserById(int userId) {
        return userDAO.getUserById(userId);
    }

    @Transactional
    public UserModel getUserByLogin(String userLogin) {
        return userDAO.getUserByLogin(userLogin);
    }

    @Transactional
    public UserModel getUserByMail(String userMail) {
        return userDAO.getUserByMail(userMail);
    }

    @Transactional
    public boolean validateLogin(String login) {
        boolean isSmallLength = login.length() > 5;

        return isSmallLength;
    }

    @Transactional
    public boolean validateMail(String mail) {
        boolean isSmallLength = mail.length() > 9;

        return isSmallLength;
    }

    @Transactional
    public String validateRegistrationData(String login, String reg_form_mail, String reg_form_password, String reg_form_password2) {
        String message = "";

        if(!validateLogin(login))
            message =  environment.getRequiredProperty("error.registerPage.incorrectLogin");
        else if(!validateMail(reg_form_mail))
            message =  environment.getRequiredProperty("error.registerPage.incorrectMail");
        else if(!reg_form_password.equals(reg_form_password2))
            message =  environment.getRequiredProperty("error.registerPage.passwordMismatch");
        else if(getUserByLogin(login).getLogin() != null)
            message =  environment.getRequiredProperty("error.registerPage.loginAlreadyExists");
        else if(getUserByMail(reg_form_mail).getMail() != null)
            message =  environment.getRequiredProperty("error.registerPage.mailAlreadyExists");

        return message;
    }

    @Transactional
    public String authentication(String loginOrMail, String password) {
        String message = "";

        if(loginOrMail.contains("@")) {
            UserModel user = getUserByMail(loginOrMail);

            if(user.getMail() == null)
                message = environment.getRequiredProperty("error.singInPage.userWithThisMailNotFound");
            else {
                if(!user.getPassword().equals(password))
                    message = environment.getRequiredProperty("error.singInPage.userPasswordIncorrect");
            }
        } else {
            UserModel user = getUserByLogin(loginOrMail);

            if(user.getLogin() == null)
                message = environment.getRequiredProperty("error.singInPage.userWithThisLoginNotFound");
            else {
                if(!user.getPassword().equals(password))
                    message = environment.getRequiredProperty("error.singInPage.userPasswordIncorrect");
            }
        }

        return message;
    }

    public UserService(Environment environment, UserDAO userDAO) {
        this.environment = environment;
        this.userDAO = userDAO;
    }
}
