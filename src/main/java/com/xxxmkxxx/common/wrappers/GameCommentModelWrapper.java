package com.xxxmkxxx.common.wrappers;

import com.xxxmkxxx.models.GameCommentModel;
import com.xxxmkxxx.models.GameModel;
import com.xxxmkxxx.models.PartyMemberModel;
import com.xxxmkxxx.models.UserModel;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GameCommentModelWrapper extends Wrapper<GameCommentModelWrapper, GameCommentModel> {
    private int commentId;
    private String text;
    private Date date;
    private UserModelWrapper user;

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public UserModelWrapper getUser() {
        return user;
    }

    public void setUser(UserModelWrapper user) {
        this.user = user;
    }

    @Override
    public List<GameCommentModelWrapper> convertList(List<GameCommentModel> models) {
        List<GameCommentModelWrapper> result = new ArrayList();

        for (int i = 0; i < models.size(); i++) {
            result.add(new GameCommentModelWrapper(models.get(i)));
        }

        return result;
    }

    public GameCommentModelWrapper() {
    }

    public GameCommentModelWrapper(GameCommentModel gameComment) {
        this.commentId = gameComment.getCommentId();
        this.text = gameComment.getText();
        this.date = gameComment.getDate();
        this.user = new UserModelWrapper(gameComment.getUser());
    }

    public GameCommentModelWrapper(int commentId, String text, Date date, UserModelWrapper user) {
        this.commentId = commentId;
        this.text = text;
        this.date = date;
        this.user = user;
    }
}
