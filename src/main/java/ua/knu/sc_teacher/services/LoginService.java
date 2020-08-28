package ua.knu.sc_teacher.services;

import ua.knu.sc_teacher.dto.TokenDto;
import ua.knu.sc_teacher.forms.LoginForm;

public interface LoginService {
    TokenDto login(LoginForm loginForm);
}
