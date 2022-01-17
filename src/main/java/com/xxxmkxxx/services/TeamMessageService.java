package com.xxxmkxxx.services;

import com.xxxmkxxx.dao.TeamDAO;
import com.xxxmkxxx.dao.TeamMessageDAO;
import com.xxxmkxxx.models.TeamMessageModel;
import com.xxxmkxxx.models.TeamModel;
import com.xxxmkxxx.models.UserModel;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TeamMessageService {
    private TeamDAO teamDAO;
    private TeamMessageDAO teamMessageDAO;

    @Transactional
    public List<TeamMessageModel> getMessages(TeamModel team) {
        return teamDAO.initializeMessages(team).getMessages();
    }

    @Transactional
    public TeamMessageModel createTeamMessage(String text, UserModel user, TeamModel team) {
        TeamMessageModel message = new TeamMessageModel(text, user, team);

        teamMessageDAO.saveMessage(message);
        teamDAO.updateTeam(team);

        return message;
    }

    public TeamMessageService(TeamDAO teamDAO, TeamMessageDAO teamMessageDAO) {
        this.teamDAO = teamDAO;
        this.teamMessageDAO = teamMessageDAO;
    }
}
