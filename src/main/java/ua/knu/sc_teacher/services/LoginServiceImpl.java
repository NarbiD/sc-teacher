package ua.knu.sc_teacher.services;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.knu.sc_teacher.dto.TokenDto;
import ua.knu.sc_teacher.forms.LoginForm;
import ua.knu.sc_teacher.model.Teacher;
import ua.knu.sc_teacher.model.Token;
import ua.knu.sc_teacher.model.User;
import ua.knu.sc_teacher.repository.TokensRepository;
import ua.knu.sc_teacher.repository.TeacherRepository;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    private final TokensRepository tokensRepository;

    private final PasswordEncoder passwordEncoder;

    private final TeacherRepository teacherRepository;

    public LoginServiceImpl(TokensRepository tokensRepository, PasswordEncoder passwordEncoder, TeacherRepository teacherRepository) {
        this.tokensRepository = tokensRepository;
        this.passwordEncoder = passwordEncoder;
        this.teacherRepository = teacherRepository;
    }

    @Override
    public TokenDto login(LoginForm loginForm) {
        Optional<Teacher> userCandidate = teacherRepository.findOneByLogin(loginForm.getLogin());
        if (userCandidate.isPresent()) {
            Teacher user = userCandidate.get();
            if (passwordEncoder.matches(loginForm.getPassword(), user.getHashPassword())) {
                Token token = Token.builder()
                                    .teacher(user)
                                    .value(RandomStringUtils.random(10, true, true))
                                    .build();
                tokensRepository.save(token);
                return TokenDto.from(token);
            } else {
                throw new IllegalArgumentException("User not found");
            }
        }
        return null;
    }
}
