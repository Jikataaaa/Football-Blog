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
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProjectUserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository repository;


    public ProjectUserDetailsServiceImpl(UserRepository repository) {

        this.repository = repository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = repository
                .findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with " + username + " not found."));



        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));


        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                authorities
        );

    }
     private static UserDetails mapToUserDetails(User user){

         List<GrantedAuthority> authorities = user
                 .getRoles()
                 .stream()
                 .map(r -> new SimpleGrantedAuthority("ROLE_" + r.getRole().name()))
                 .collect(Collectors.toList());

         return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
     }
}
