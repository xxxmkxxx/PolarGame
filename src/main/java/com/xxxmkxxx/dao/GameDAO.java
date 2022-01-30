package com.xxxmkxxx.dao;

import com.xxxmkxxx.models.GameModel;

public interface GameDAO {
    GameModel initializeComments(GameModel game);
    GameModel initializeParties(GameModel game);
    GameModel initializeTeams(GameModel game);
}
