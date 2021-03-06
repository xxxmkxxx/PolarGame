package com.xxxmkxxx.common.wrappers;

import com.xxxmkxxx.models.PartyMemberModel;
import com.xxxmkxxx.models.PartyModel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PartyModelWrapper extends Wrapper<PartyModelWrapper, PartyModel> {
    private int partyId;
    private int usersAmount;
    private String closed;
    private String password;
    private String description;
    private String urlPartyIcon;
    private List<PartyMemberModelWrapper> members;
    private UserModelWrapper owner;

    public UserModelWrapper getPartyOwner() {
        List<PartyMemberModelWrapper> partyMembers = members.stream().filter(member -> member.getRole().equals("создатель")).collect(Collectors.toList());

        return partyMembers.get(0).getUser();
    }

    public int getPartyId() {
        return partyId;
    }

    public void setPartyId(int partyId) {
        this.partyId = partyId;
    }

    public int getUsersAmount() {
        return usersAmount;
    }

    public void setUsersAmount(int usersAmount) {
        this.usersAmount = usersAmount;
    }

    public String getClosed() {
        return closed;
    }

    public void setClosed(String closed) {
        this.closed = closed;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlPartyIcon() {
        return urlPartyIcon;
    }

    public void setUrlPartyIcon(String urlPartyIcon) {
        this.urlPartyIcon = urlPartyIcon;
    }

    public List<PartyMemberModelWrapper> getMembers() {
        return members;
    }

    public void setMembers(List<PartyMemberModelWrapper> members) {
        this.members = members;
    }

    public UserModelWrapper getOwner() {
        return owner;
    }

    public void setOwner(UserModelWrapper owner) {
        this.owner = owner;
    }

    @Override
    public List<PartyModelWrapper> convertList(List<PartyModel> models) {
        List<PartyModelWrapper> result = new ArrayList();

        for (int i = 0; i < models.size(); i++) {
            result.add(new PartyModelWrapper(models.get(i)));
        }

        return result;
    }

    public PartyModelWrapper() {
    }

    public PartyModelWrapper(PartyModel party) {
        WrapperManager<PartyMemberModelWrapper, PartyMemberModel> wrapperManager = new WrapperManager(new PartyMemberModelWrapper());

        this.partyId = party.getPartyId();
        this.usersAmount = party.getUsersAmount();
        this.closed = party.getClosed();
        this.password = party.getPassword();
        this.description = party.getDescription();
        this.urlPartyIcon = party.getUrlPartyIcon();
        this.members = wrapperManager.convertList(party.getMembers());
    }

    public PartyModelWrapper(int partyId, int usersAmount, String closed, String password, String description, String urlPartyIcon, List<PartyMemberModelWrapper> members, UserModelWrapper owner) {
        this.partyId = partyId;
        this.usersAmount = usersAmount;
        this.closed = closed;
        this.password = password;
        this.description = description;
        this.urlPartyIcon = urlPartyIcon;
        this.members = members;
        this.owner = owner;
    }
}
