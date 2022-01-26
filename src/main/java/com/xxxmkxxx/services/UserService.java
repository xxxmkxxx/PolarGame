package com.xxxmkxxx.services;

import com.xxxmkxxx.common.wrappers.UserModelWrapper;
import com.xxxmkxxx.common.wrappers.WrapperManager;
import com.xxxmkxxx.dao.UserDAO;
import com.xxxmkxxx.models.TeamMessageModel;
import com.xxxmkxxx.models.UserModel;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    public boolean validateLogin(String login) {
        boolean isSmallLength = login.length() > 5;

        return isSmallLength;
    }

    public boolean validateMail(String mail) {
        boolean isSmallLength = mail.length() > 9;

        return isSmallLength;
    }

    @Transactional
    public String validateRegistrationData(String login, String reg_form_mail, String reg_form_password, String reg_form_password2) {
        String message = "success";

        if(!validateLogin(login))
            message = environment.getRequiredProperty("error.registerPage.incorrectLogin");
        else if(!validateMail(reg_form_mail))
            message = environment.getRequiredProperty("error.registerPage.incorrectMail");
        else if(!reg_form_password.equals(reg_form_password2))
            message = environment.getRequiredProperty("error.registerPage.passwordMismatch");
        else if(getUserByLogin(login).getLogin() != null)
            message = environment.getRequiredProperty("error.registerPage.loginAlreadyExists");
        else if(getUserByMail(reg_form_mail).getMail() != null)
            message = environment.getRequiredProperty("error.registerPage.mailAlreadyExists");

        if(message.equals("success"))
            userDAO.saveUser(new UserModel(login, reg_form_password, reg_form_mail));

        return message;
    }

    @Transactional
    public String authentication(String loginOrMail, String password) {
        String message = "success";

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

    @Transactional
    public List<UserModel> getFriends(UserModel user) {
        return userDAO.initializeFriends(user).getFriends();
    }

    @Transactional
    public List<UserModelWrapper> getFriendsWrappers(UserModel user) {
        List<UserModel> friends = getFriends(user);
        WrapperManager<UserModelWrapper, UserModel> wrapperManager = new WrapperManager(new UserModelWrapper());

        return wrapperManager.convertList(friends);
    }

    @Transactional
    public void removeFriend(UserModel user, UserModel friend) {
        userDAO.removeFriend(user, friend);
    }

    @Transactional
    public void updateDescription(UserModel user, String description) {
        user.setDescription(description);

        userDAO.updateUser(user);
    }

    @Transactional
    public List<TeamMessageModel> getTeamMessages(UserModel user) {
        return userDAO.initializeTeamMessages(user).getTeamMessages();
    }

    @Transactional
    public String updateData(
            UserModel user,
            String newLogin,
            String lostPassword,
            String newPassword,
            String repeatPassword
    ) {
        String message = "success";

        if(!validateLogin(newLogin))
            message = environment.getRequiredProperty("error.profilePage.incorrectLogin");
        else if(!newPassword.equals(repeatPassword))
            message = environment.getRequiredProperty("error.profilePage.passwordMismatch");
        else if(getUserByLogin(newLogin).getLogin() != null)
            message = environment.getRequiredProperty("error.profilePage.loginAlreadyExists");
        else if(!user.getPassword().equals(lostPassword)){
            message = environment.getRequiredProperty("error.profilePage.incorrectLostPassword");
        }

        if(message.equals("success")) {
            user.setLogin(newLogin);
            user.setPassword(newPassword);

            userDAO.updateUser(user);
        }

        return message;
    }


    public UserService(Environment environment, UserDAO userDAO) {
        this.environment = environment;
        this.userDAO = userDAO;
    }
}
