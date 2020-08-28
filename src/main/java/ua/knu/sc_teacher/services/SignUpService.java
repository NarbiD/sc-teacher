package ua.knu.sc_teacher.services;

import org.springframework.stereotype.Service;
import ua.knu.sc_teacher.forms.UserForm;


public interface SignUpService {
    void signUp(UserForm form);
}
