package ua.knu.sc_teacher.security.details;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ua.knu.sc_teacher.model.State;
import ua.knu.sc_teacher.model.Teacher;

import java.util.Collection;
import java.util.Collections;

@AllArgsConstructor
@Data
public class TeacherDetailsImpl implements UserDetails {

    private Teacher teacher;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String userRole = teacher.getRole().name();
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userRole);
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return teacher.getHashPassword();
    }

    @Override
    public String getUsername() {
        return teacher.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !teacher.getState().equals(State.BANNED);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return teacher.getState().equals(State.ACTIVE);
    }
}
