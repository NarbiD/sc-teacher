package ua.knu.sc_teacher.security.filters;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import ua.knu.sc_teacher.security.token.TokenAuthentication;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class TokenAuthFilter  implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        Cookie[] cookies = ((HttpServletRequest) request).getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String token = cookie.getName();
                if (token.equals("AuthToken")) {
                    TokenAuthentication tokenAuthentication = new TokenAuthentication(cookie.getValue());
                    SecurityContextHolder.getContext().setAuthentication(tokenAuthentication);
                }
            }
        }
        chain.doFilter(httpServletRequest, response);
    }
}
