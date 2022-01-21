package com.xxxmkxxx.services;

import com.xxxmkxxx.common.wrappers.GameCommentModelWrapper;
import com.xxxmkxxx.common.wrappers.WrapperManager;
import com.xxxmkxxx.config.GameCommentConfig;
import com.xxxmkxxx.dao.GameCommentDAO;
import com.xxxmkxxx.dao.GameDAO;
import com.xxxmkxxx.models.GameCommentModel;
import com.xxxmkxxx.models.GameModel;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class GameCommentsService {
    private GameDAO gameDAO;

    @Transactional
    public List<GameCommentModel> getComments(GameModel game) {
        return gameDAO.initializeComments(game).getComments();
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
    public List<GameCommentModelWrapper> getPartCommentsWrapper(int firstIndex, List<GameCommentModel> comments) {
        List<GameCommentModel> partComments = getPartComments(firstIndex, comments);
        WrapperManager<GameCommentModelWrapper, GameCommentModel> wrapperManager = new WrapperManager(new GameCommentModelWrapper());

        return wrapperManager.convertList(partComments);
    }

    @Transactional
    public List<GameCommentModel> getMoreComments(int lastCommentId, GameModel game) {
        return getPartComments(lastCommentId, getComments(game));
    }

    @Transactional
    public List<GameCommentModelWrapper> getMoreCommentsWrapper(int lastCommentId, GameModel game) {
        List<GameCommentModel> partComments = getMoreComments(lastCommentId, game);
        WrapperManager<GameCommentModelWrapper, GameCommentModel> wrapperManager = new WrapperManager(new GameCommentModelWrapper());

        return wrapperManager.convertList(partComments);
    }

    public GameCommentsService(GameDAO gameDAO) {
        this.gameDAO = gameDAO;
    }
}
