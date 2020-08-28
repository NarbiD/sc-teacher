package ua.knu.sc_teacher.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.knu.sc_teacher.forms.UserForm;
import ua.knu.sc_teacher.model.Role;
import ua.knu.sc_teacher.model.State;
import ua.knu.sc_teacher.model.Teacher;
import ua.knu.sc_teacher.repository.TeacherRepository;

@Service
public class SignUpServiceImpl implements SignUpService {
    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public void signUp(UserForm form) {
        String hashPassword = encoder.encode(form.getPassword());
        Teacher teacher = Teacher.builder()
                .login(form.getLogin())
                .hashPassword(hashPassword)
                .role(Role.USER)
                .state(State.ACTIVE)
                .build();
        teacherRepository.save(teacher);
    }
}
