package com.xxxmkxxx.models;

import javax.persistence.*;

@Entity
@Table(name = "team_members")
public class TeamMemberModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_team_members")
    private int teamMemberId;

    @Column(name = "team_member_role")
    private String role;

    @Column(name = "nickname")
    private String nick;

    @ManyToOne
    @JoinColumn(name = "id_team")
    private TeamModel team;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserModel user;

    public int getTeamMemberId() {
        return teamMemberId;
    }

    public void setTeamMemberId(int teamMemberId) {
        this.teamMemberId = teamMemberId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public TeamModel getTeam() {
        return team;
    }

    public void setTeam(TeamModel team) {
        this.team = team;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public TeamMemberModel() {}

    public TeamMemberModel(int teamMemberId, String role, String nick, TeamModel team, UserModel user) {
        this.teamMemberId = teamMemberId;
        this.role = role;
        this.nick = nick;
        this.team = team;
        this.user = user;
    }
}
