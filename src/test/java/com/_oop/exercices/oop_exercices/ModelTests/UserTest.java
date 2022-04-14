package com._oop.exercices.oop_exercices.ModelTests;

import com._oop.exercices.oop_exercices.SOLID.O.InvitationService;
import com._oop.exercices.oop_exercices.SOLID.O.InviteUserByFaceBook;
import com._oop.exercices.oop_exercices.SOLID.O.InviteUserByWhatsUp;
import com._oop.exercices.oop_exercices.SOLID.O.Repositories.UserRepository;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class UserTest {
   /* @Test
    void UserCanBeSaved(){
        User user = new User(1L, "user1");

        user.saveUserById();

        assertThat(user.saveUserById(), equalTo ("El usuario se guardó correctamente"));
    }*/

    @Test
    void UserCanBeSavedByARepositorieClass(){

        UserRepository userRepository = new UserRepository();

        assertThat(userRepository.saveUser(), equalTo ("Usuario guardado"));
    }

    @Test
    void userCanInviteNewUserByWhatsup(){
        InviteUserByWhatsUp invitation = new InviteUserByWhatsUp();

        InvitationService invitationService = new InvitationService(invitation);

       var sut= invitationService.sendInvitation();

        assertThat(sut, equalTo("Usuario invitado por whatsup"));
    }
    @Test
    void userCanInviteNewUserByFaceBook(){
        InviteUserByFaceBook invitation = new InviteUserByFaceBook();

        InvitationService invitationService = new InvitationService(invitation);

        var sut= invitationService.sendInvitation();

        assertThat(sut, equalTo("Usuario invitado por FaceBook"));
    }
}
