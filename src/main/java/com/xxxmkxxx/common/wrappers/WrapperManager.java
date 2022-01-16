package com.xxxmkxxx.common.wrappers;

import com.xxxmkxxx.models.GameCommentModel;
import com.xxxmkxxx.models.GameModel;
import com.xxxmkxxx.models.GenresModel;
import com.xxxmkxxx.models.UserModel;
import org.springframework.stereotype.Component;

import java.util.List;

public class WrapperManager<W, M> {
    private Wrapper<W, M> wrapper;

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

    public List<W> convertList(List<M> models) {
        return wrapper.convertList(models);
    }

    public WrapperManager(Wrapper<W, M> wrapper) {
        this.wrapper = wrapper;
    }
}
