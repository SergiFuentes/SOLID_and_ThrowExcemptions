package com._oop.exercices.oop_exercices.SOLID.O;

public class User {
    private Long id;
    private String name;


   /* public String saveUserById (){
        return "El usuario se guardó correctamente";
    }*/

    /*public String inviteNewUserInWhatsUp(){
        return "Usuario invitado por whatsup";
    }

    public String inviteNewUserInFaceBook(){
        return "Usuario invitado por whatsup";
    }*/

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

 /*   public String inviteUserByApp (InviteUser invitation){
        return invitation.inviteUser();
    }*/
}
