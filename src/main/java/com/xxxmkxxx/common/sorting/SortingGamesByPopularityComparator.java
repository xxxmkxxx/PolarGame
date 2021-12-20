package com.xxxmkxxx.common.sorting;

import com.xxxmkxxx.models.GameModel;

import java.util.Comparator;

public class SortingGamesByPopularityComparator implements Comparator<GameModel> {
    @Override
    public int compare(GameModel gameModel, GameModel t1) {
        return t1.getPopularity() - gameModel.getPopularity();
    }
}
