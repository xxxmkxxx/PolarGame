package com.xxxmkxxx.dao;

import com.xxxmkxxx.models.UserModel;

public interface UserDAO {
    UserModel getUserByLogin(String login);
    UserModel getUserByMail(String mail);
    UserModel initializeFriends(UserModel user);
    UserModel initializeTeamMessages(UserModel user);
    UserModel initializeTeamMembers(UserModel user);
}
