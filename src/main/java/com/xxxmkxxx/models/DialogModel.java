package com.xxxmkxxx.models;

import com.xxxmkxxx.common.DyalogTypes;

import java.util.List;

public class DialogModel {
    private int dialogId;
    private String title;
    private DyalogTypes type;
    private List<UserModel> members;

    public int getDialogId() {
        return dialogId;
    }

    public void setDialogId(int dialogId) {
        this.dialogId = dialogId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public DyalogTypes getType() {
        return type;
    }

    public void setType(DyalogTypes type) {
        this.type = type;
    }

    public List<UserModel> getMembers() {
        return members;
    }

    public void setMembers(List<UserModel> members) {
        this.members = members;
    }

    public DialogModel(int dialogId, String title, DyalogTypes type, List<UserModel> members) {
        this.dialogId = dialogId;
        this.title = title;
        this.type = type;
        this.members = members;
    }
}
