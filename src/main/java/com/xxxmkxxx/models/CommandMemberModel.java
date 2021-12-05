package com.xxxmkxxx.models;

import com.xxxmkxxx.common.CommandMemberRoles;

public class CommandMemberModel {
    private int commandId;
    private int userId;
    private String nick;
    private CommandMemberRoles role;
    private String description;

    public int getCommandId() {
        return commandId;
    }

    public void setCommandId(int commandId) {
        this.commandId = commandId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public CommandMemberRoles getRole() {
        return role;
    }

    public void setRole(CommandMemberRoles role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CommandMemberModel(int commandId, int userId, String nick, CommandMemberRoles role, String description) {
        this.commandId = commandId;
        this.userId = userId;
        this.nick = nick;
        this.role = role;
        this.description = description;
    }
}
