package com.xxxmkxxx.common.wrappers;

import com.xxxmkxxx.models.GameCommentModel;
import com.xxxmkxxx.models.GameModel;
import com.xxxmkxxx.models.GenresModel;
import com.xxxmkxxx.models.UserModel;

import java.util.ArrayList;
import java.util.List;

public class WrapperManager<T> {
    public static UserModelWrapper convertUserModel(UserModel user) {
        return new UserModelWrapper(
                user.getUserId(),
                user.getLogin(),
                user.getMail(),
                user.getDescription(),
                user.getUrlUserIcon()
        );
    }

    public static GameCommentModelWrapper convertGameCommentModel(GameCommentModel gameComment) {
        return new GameCommentModelWrapper(
                gameComment.getCommentId(),
                gameComment.getText(),
                gameComment.getDate(),
                convertUserModel(gameComment.getUser())
        );
    }

    public static GenresModelWrapper convertGenresModel(GenresModel genre) {
        return new GenresModelWrapper(
                genre.getGenreId(),
                genre.getGenreName()
        );
    }

    public static GameModelWrapper convertGameModel(GameModel game) {
        return new GameModelWrapper(
                game.getGameId(),
                game.getName(),
                game.getDescription(),
                game.getUrlGameIcon(),
                game.getPopularity()
        );
    }


}
