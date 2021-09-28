package com.example.springboot3.service;


import com.example.springboot3.dao.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import com.example.springboot3.entity.User;

@Service("userService")
public class UserService {
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    public void setUserDao(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Autowired
    public void setbCryptPasswordEncoder(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    public void addUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public void updateUser(User user) {
        if (user.getPassword().equals(getUserById(user.getId()).getPassword())) {
            user.setPassword(getUserById(user.getId()).getPassword());
        } else {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        }
        userRepository.saveAndFlush(user);
    }

    public void removeUserById(long id) {
        userRepository.deleteById(id);
    }

    public User getUserById(long id) { return userRepository.findById(id); }

    public List<User> getAllUsers() { return userRepository.findAllBy(); }

    public User getUserByName(String username) {
        return userRepository.findByUserName(username);
    }
}
