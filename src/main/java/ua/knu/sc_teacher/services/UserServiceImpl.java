package ua.knu.sc_teacher.services;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.knu.sc_teacher.dto.TokenDto;
import ua.knu.sc_teacher.forms.LoginForm;
import ua.knu.sc_teacher.forms.UserForm;
import ua.knu.sc_teacher.model.Role;
import ua.knu.sc_teacher.model.State;
import ua.knu.sc_teacher.model.Teacher;
import ua.knu.sc_teacher.model.Token;
import ua.knu.sc_teacher.repository.TokensRepository;
import ua.knu.sc_teacher.repository.TeacherRepository;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final TokensRepository tokensRepository;

    private final PasswordEncoder passwordEncoder;

    private final TeacherRepository teacherRepository;

    public UserServiceImpl(TokensRepository tokensRepository, PasswordEncoder passwordEncoder, TeacherRepository teacherRepository) {
        this.tokensRepository = tokensRepository;
        this.passwordEncoder = passwordEncoder;
        this.teacherRepository = teacherRepository;
    }

    @Override
    public TokenDto signIn(LoginForm loginForm) {
        Optional<Teacher> userCandidate = teacherRepository.findOneByLogin(loginForm.getLogin());
        if (userCandidate.isPresent()) {
            Teacher user = userCandidate.get();
            if (passwordEncoder.matches(loginForm.getPassword(), user.getHashPassword())) {
                Token token = Token.builder()
                        .teacher(user)
                        .value(RandomStringUtils.random(10, true, true))
                        .build();
                tokensRepository.save(token);
                return TokenDto.of(token);
            } else {
                throw new IllegalArgumentException("User not found");
            }
        }
        return null;
    }

    @Override
    public void signUp(UserForm form) {
        String hashPassword = passwordEncoder.encode(form.getPassword());
        Teacher teacher = Teacher.builder()
                .login(form.getLogin())
                .hashPassword(hashPassword)
                .role(Role.USER)
                .state(State.ACTIVE)
                .build();
        teacherRepository.save(teacher);
    }

    @Override
    public boolean signOut(String token) {
        return tokensRepository.deleteByValue(token);
    }
}
