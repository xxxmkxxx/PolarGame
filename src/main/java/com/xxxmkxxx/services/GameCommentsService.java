package com.xxxmkxxx.services;

import com.xxxmkxxx.common.wrappers.GameCommentModelWrapper;
import com.xxxmkxxx.common.wrappers.WrapperManager;
import com.xxxmkxxx.config.GameCommentConfig;
import com.xxxmkxxx.dao.GameCommentDAO;
import com.xxxmkxxx.dao.GameDAO;
import com.xxxmkxxx.models.GameCommentModel;
import com.xxxmkxxx.models.GameModel;
import com.xxxmkxxx.models.UserModel;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class GameCommentsService {
    private GameCommentDAO gameCommentDAO;
    private GameDAO gameDAO;

    @Transactional
    public List<GameCommentModel> getComments(GameModel game) {
        return gameDAO.initializeComments(game).getComments();
    }

    @Transactional
    public List<GameCommentModelWrapper> getCommentsWrapper(GameModel game) {
        List<GameCommentModel> comments = gameDAO.initializeComments(game).getComments();
        List<GameCommentModelWrapper> result = new ArrayList();

        for (int i = 0; i < comments.size(); i++) {
            result.add(WrapperManager.convertGameCommentModel(comments.get(i)));
        }

        return result;
    }

    @Transactional
    public List<GameCommentModel> getPartComments(int firstIndex, List<GameCommentModel> comments) {
        List<GameCommentModel> result = new ArrayList();

        try {
            result = comments.subList(firstIndex, firstIndex + GameCommentConfig.COUNT_VIEW_COMMENTS);
        } catch (IndexOutOfBoundsException e) {
            result = comments.subList(firstIndex, comments.size());
        }

        return result;
    }

    @Transactional
    public List<GameCommentModel> getMoreComments(int lastCommentId, GameModel game) {
        return getPartComments(lastCommentId, getComments(game));
    }

    @Transactional
    public List<GameCommentModelWrapper> getMoreCommentsWrapper(int lastCommentId, GameModel game) {
        List<GameCommentModel> partComments = getPartComments(lastCommentId, getComments(game));
        List<GameCommentModelWrapper> result = new ArrayList();

        for (int i = 0; i < partComments.size(); i++) {
            result.add(WrapperManager.convertGameCommentModel(partComments.get(i)));
        }

        return result;
    }

    public String validateComment(String commentText) {
        String message = "success";

        boolean isCommentTextNotNull = !commentText.equals("");

        if(!isCommentTextNotNull)
            message = "null";

        return message;
    }

    @Transactional
    public void saveComment(int gameId, String text, UserModel user) {
        //gameCommentDAO.saveComment(new GameCommentModel(gameId, text, user));
    }

    public GameCommentsService(GameCommentDAO gameCommentDAO, GameDAO gameDAO) {
        this.gameCommentDAO = gameCommentDAO;
        this.gameDAO = gameDAO;
    }
}
