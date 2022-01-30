package com.xxxmkxxx.services;

import com.xxxmkxxx.dao.TeamDAOImpl;
import com.xxxmkxxx.models.TeamModel;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class TeamService {
    private TeamDAOImpl dao;

    public TeamService(TeamDAOImpl dao) {
        this.dao = dao;
    }

    @Transactional
    public TeamModel getTeam(int teamId) {
        return dao.read(teamId);
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
        return dao.initializeMembers(teamModel);
    }
}
