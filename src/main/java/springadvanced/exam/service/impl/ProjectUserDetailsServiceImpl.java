package springadvanced.exam.service.impl;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import springadvanced.exam.model.entities.User;
import springadvanced.exam.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class ProjectUserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository repository;


    public ProjectUserDetailsServiceImpl(UserRepository repository) {

        this.repository = repository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = repository.findByUsername(username).orElseThrow();
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));


        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                authorities
        );

    }
}
