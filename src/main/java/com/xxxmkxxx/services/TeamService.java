package com.xxxmkxxx.services;

import com.xxxmkxxx.dao.TeamDAO;
import com.xxxmkxxx.dao.UserDAO;
import com.xxxmkxxx.models.PartyModel;
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

    @Transactional
    public List<List<TeamModel>> groupTeams(int count, List<TeamModel> teams) {
        if(teams.size() == 0)
            return new ArrayList();

        List<List<TeamModel>> teamsGroups = new ArrayList();
        List<TeamModel> group = new ArrayList();
        int indexTeamInRow = 0;

        for (int i = 0; i < teams.size(); i++) {
            if(indexTeamInRow % count != 0 || indexTeamInRow == 0) {
                group.add(teams.get(i));
            } else {
                indexTeamInRow = 0;
                teamsGroups.add(group);
                group = new ArrayList();
                group.add(teams.get(i));
            }

            if(i == teams.size() - 1)
                teamsGroups.add(group);

            indexTeamInRow++;
        }

        return teamsGroups;
    }

    @Transactional
    public TeamModel initMembers(TeamModel teamModel) {
        return teamDAO.initializeMembers(teamModel);
    }

    public TeamService(UserDAO userDAO, TeamDAO teamDAO) {
        this.userDAO = userDAO;
        this.teamDAO = teamDAO;
    }
}
