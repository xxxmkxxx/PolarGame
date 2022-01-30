package com.xxxmkxxx.services;

import com.xxxmkxxx.dao.TeamMessageDAOImpl;
import com.xxxmkxxx.models.TeamMessageModel;
import com.xxxmkxxx.models.TeamModel;
import com.xxxmkxxx.models.UserModel;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TeamMessageService {
    private TeamMessageDAOImpl dao;

    @Transactional
    public TeamMessageModel createTeamMessage(String text, UserModel user, TeamModel team) {
        TeamMessageModel message = new TeamMessageModel(text, user, team);

        dao.create(message);

        return message;
    }

    public TeamMessageService(TeamMessageDAOImpl dao) {
        this.dao = dao;
    }
}
