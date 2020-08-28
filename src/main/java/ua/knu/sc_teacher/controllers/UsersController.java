package ua.knu.sc_teacher.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ua.knu.sc_teacher.dto.TokenDto;
import ua.knu.sc_teacher.forms.LoginForm;
import ua.knu.sc_teacher.forms.UserForm;
import ua.knu.sc_teacher.services.LoginService;
import ua.knu.sc_teacher.services.SignUpService;

@RestController
public class UsersController {
    @Autowired
    private LoginService loginService;
    @Autowired
    SignUpService signUpService;

    @PostMapping("/api/signUp")
    public ResponseEntity<TokenDto> signUp (@RequestBody UserForm form) {
        signUpService.signUp(form);
        return login(new LoginForm(form.getLogin(), form.getPassword()));
    }

    @PostMapping("/api/signIn")
    public ResponseEntity<TokenDto> login (@RequestBody LoginForm loginForm) {
        return ResponseEntity.ok(loginService.login(loginForm));
    }
}
