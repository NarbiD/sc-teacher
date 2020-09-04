package ua.knu.sc_teacher.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.knu.sc_teacher.dto.ResponseWrapper;
import ua.knu.sc_teacher.dto.TokenDto;
import ua.knu.sc_teacher.forms.LoginForm;
import ua.knu.sc_teacher.forms.UserForm;
import ua.knu.sc_teacher.services.UserService;

@RestController
public class UsersController {

    final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/signUp")
    public ResponseEntity<TokenDto> signUp (@RequestBody UserForm form) {
        userService.signUp(form);
        return login(new LoginForm(form.getLogin(), form.getPassword()));
    }

    @PostMapping("/api/signIn")
    public ResponseEntity<TokenDto> login (@RequestBody LoginForm loginForm) {
        return ResponseEntity.ok(userService.signIn(loginForm));
    }

    @DeleteMapping("/api/signOut")
    public ResponseEntity<ResponseWrapper> signOut(@CookieValue("AuthToken") String token) {
        if(userService.signOut(token)) {
            return ResponseEntity.ok(new ResponseWrapper("Signed out"));
        } else {
            throw new IllegalArgumentException("Unexpected token");
        }
    }
}
