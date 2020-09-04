package ua.knu.sc_teacher.security.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import ua.knu.sc_teacher.model.Token;
import ua.knu.sc_teacher.repository.TokensRepository;
import ua.knu.sc_teacher.security.token.TokenAuthentication;

import java.util.Optional;

@Component
public class TokenAuthenticationProvider implements AuthenticationProvider {

    private final TokensRepository tokensRepository;

    private final UserDetailsService userDetailsService;

    public TokenAuthenticationProvider(TokensRepository tokensRepository, @Qualifier("teacherDetailsServiceImpl") UserDetailsService userDetailsService) {
        this.tokensRepository = tokensRepository;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        TokenAuthentication tokenAuth = (TokenAuthentication) authentication;
        Optional<Token> tokenCandidate = tokensRepository.findOneByValue(tokenAuth.getName());

        if (tokenCandidate.isPresent()) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(tokenCandidate.get().getTeacher().getLogin());
            tokenAuth.setUserDetails(userDetails);
            tokenAuth.setAuthenticated(true);
            return tokenAuth;
        }
        return tokenAuth;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return TokenAuthentication.class.equals((authentication));
    }
}
