package com.nem.docms.servies;

import com.nem.docms.entities.User;
import com.nem.docms.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
//spring.data.mongodb.port=27017
//spring.data.mongodb.host=localhost
//server.port = 8090

@Service
public class UserService {

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getUser(String id) {
        try {
            return userRepository.findById(id).get();
        } catch (Exception e) {
            e.printStackTrace();
            return new User();
        }
    }

    public User addUser(User user) {
        user.setPassword(encoder().encode(user.getPassword()));
        return userRepository.insert(user);
    }

    public User update(User user) {
        try {
            user.setPassword(user.getPassword());
            user.setValid(true);
            return userRepository.save(user);
        } catch (Exception e) {
            e.printStackTrace();
            return user;
        }
    }

    public void delete(String id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
