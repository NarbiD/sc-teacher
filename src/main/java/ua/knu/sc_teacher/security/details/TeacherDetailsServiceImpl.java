package ua.knu.sc_teacher.security.details;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.knu.sc_teacher.repository.TeacherRepository;

@Service
public class TeacherDetailsServiceImpl implements UserDetailsService {
    final TeacherRepository teacherRepository;

    public TeacherDetailsServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new TeacherDetailsImpl(teacherRepository.findOneByLogin(username).orElseThrow(()
                -> new UsernameNotFoundException("Not found user with name " + username)));
    }
}
