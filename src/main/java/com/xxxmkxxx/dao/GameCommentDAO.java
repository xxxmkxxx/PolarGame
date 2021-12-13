package com.xxxmkxxx.dao;

import com.xxxmkxxx.models.GameCommentModel;
import com.xxxmkxxx.storage.DataManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class GameCommentDAO {
    private DataManager <GameCommentModel> data;

    @Transactional
    public List<GameCommentModel> getAllComments(int gameId) {
        String query = "from GameCommentModel gcm left join gcm.user where gcm.gameId = " + gameId;

        return data.read(GameCommentModel.class, query);
    }

   public GameCommentDAO(DataManager<GameCommentModel> data) {
       this.data = data;
   }
}
