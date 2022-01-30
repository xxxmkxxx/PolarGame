package com.xxxmkxxx.dao;

import com.xxxmkxxx.models.TeamModel;

public interface TeamDAO {
    TeamModel initializeMessages(TeamModel team);
    TeamModel initializeMembers(TeamModel team);
}
