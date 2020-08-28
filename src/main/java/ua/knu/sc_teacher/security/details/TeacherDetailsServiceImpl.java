package ua.knu.sc_teacher.security.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.knu.sc_teacher.model.Teacher;
import ua.knu.sc_teacher.model.User;
import ua.knu.sc_teacher.repository.TeacherRepository;

import java.util.Optional;

@Service
public class TeacherDetailsServiceImpl implements UserDetailsService {
    @Autowired
    TeacherRepository teacherRepository;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Teacher> userCandidate = teacherRepository.findOneByLogin(username);
        return new TeacherDetailsImpl(teacherRepository.findOneByLogin(username).orElseThrow(()
                -> new UsernameNotFoundException("User not found")));
    }
}
