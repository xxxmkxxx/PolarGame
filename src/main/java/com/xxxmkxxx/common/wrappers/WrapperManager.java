package com.xxxmkxxx.common.wrappers;

import com.xxxmkxxx.models.UserModel;

public class WrapperManager {
    public static UserModelWrapper convertUserModel(UserModel user) {
        return new UserModelWrapper(
                user.getUserId(),
                user.getLogin(),
                user.getPassword(),
                user.getMail(),
                user.getDescription(),
                user.getUrlUserIcon()
        );
    }


}
