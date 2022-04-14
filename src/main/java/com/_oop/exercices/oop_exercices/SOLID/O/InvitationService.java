package com._oop.exercices.oop_exercices.SOLID.O;

public class InvitationService {

    private InviteUser inviteUser;

    public InvitationService(InviteUser inviteUser) {
        this.inviteUser = inviteUser;

    }

    public String sendInvitation(){
        return inviteUser.invitation();
    }
}
