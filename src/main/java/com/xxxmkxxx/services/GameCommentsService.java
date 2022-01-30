package com.xxxmkxxx.services;

import com.xxxmkxxx.common.wrappers.GameCommentModelWrapper;
import com.xxxmkxxx.common.wrappers.WrapperManager;
import com.xxxmkxxx.config.GameCommentConfig;
import com.xxxmkxxx.dao.GameCommentDAOImpl;
import com.xxxmkxxx.models.GameCommentModel;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class GameCommentsService {
    private GameCommentDAOImpl dao;

    public GameCommentsService(GameCommentDAOImpl dao) {
        this.dao = dao;
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
    public String addComment(GameCommentModel comment) {
        dao.create(comment);

        return "success";
    }
}
