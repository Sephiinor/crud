package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>Title:UserServiceImpl.java</p >
 * <p>Description:</p >
 *
 * @author Sephinor
 * @time 2019/12/15 12:15
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> getUserList() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public void save(User user) {
        try {
            userRepository.save(user);
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            userRepository.flush();
        }
    }

    @Override
    public void edit(User user) {
        this.save(user);
    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }
}
