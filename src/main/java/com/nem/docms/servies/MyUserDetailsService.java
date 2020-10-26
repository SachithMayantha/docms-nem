package com.nem.docms.servies;

import com.nem.docms.entities.User;
import com.nem.docms.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("loadUserByUsername--MyUserDetailsService");
        Optional<User> user = userRepository.findByUsername(username);

        if (user == null)
            throw new UsernameNotFoundException("User 404");
        return user.map(UserPrincipal::new).get();
    }
}

