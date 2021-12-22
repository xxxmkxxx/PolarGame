package com.xxxmkxxx.services;

import com.xxxmkxxx.config.GameCommentConfig;
import com.xxxmkxxx.dao.GameCommentDAO;
import com.xxxmkxxx.models.GameCommentModel;
import com.xxxmkxxx.models.UserModel;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class GameCommentsService {
    private GameCommentDAO gameCommentDAO;

    @Transactional
    public List<GameCommentModel> getComments(int gameId) {
        return new ArrayList(gameCommentDAO.getAllComments(gameId));
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
    public List<GameCommentModel> getMoreComments(int lastCommentId, int gameId) {
        return getPartComments(lastCommentId, getComments(gameId));
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
        gameCommentDAO.saveComment(new GameCommentModel(gameId, text, user));
    }

    public GameCommentsService(GameCommentDAO gameCommentDAO) {
        this.gameCommentDAO = gameCommentDAO;
    }
}
