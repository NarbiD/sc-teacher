package ua.knu.sc_teacher.services;

import org.springframework.stereotype.Service;
import ua.knu.sc_teacher.model.Teacher;
import ua.knu.sc_teacher.repository.TokensRepository;

@Service
public class TokenServiceImpl implements TokensService {
    final TokensRepository tokensRepository;

    public TokenServiceImpl(TokensRepository tokensRepository) {
        this.tokensRepository = tokensRepository;
    }

    @Override
    public Teacher findOneByValue(String token) {
        return tokensRepository.findOneByValue(token).get().getTeacher();
    }
}
