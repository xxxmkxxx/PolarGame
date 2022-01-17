package com.xxxmkxxx.services;

import com.xxxmkxxx.dao.TeamDAO;
import com.xxxmkxxx.dao.UserDAO;
import com.xxxmkxxx.models.TeamMemberModel;
import com.xxxmkxxx.models.TeamModel;
import com.xxxmkxxx.models.UserModel;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TeamService {
    private UserDAO userDAO;
    private TeamDAO teamDAO;

    @Transactional
    public List<TeamModel> getUserTeams(UserModel user) {
        List<TeamModel> teams = new ArrayList();

        for (TeamMemberModel member : userDAO.initializeTeamMembers(user).getTeamMembers()) {
            teams.add(member.getTeam());
        }

        return teams.stream().distinct().collect(Collectors.toList());
    }

    @Transactional
    public TeamModel getTeam(int teamId) {
        return teamDAO.getTeam(teamId);
    }

    public TeamService(UserDAO userDAO, TeamDAO teamDAO) {
        this.userDAO = userDAO;
        this.teamDAO = teamDAO;
    }
}
