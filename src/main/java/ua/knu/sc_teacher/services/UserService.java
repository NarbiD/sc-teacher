package ua.knu.sc_teacher.services;

import ua.knu.sc_teacher.dto.TokenDto;
import ua.knu.sc_teacher.forms.LoginForm;
import ua.knu.sc_teacher.forms.UserForm;

public interface UserService {
    TokenDto signIn(LoginForm loginForm);
    void signUp(UserForm form);
    boolean signOut(String token);

}
