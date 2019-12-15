package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


/**
 * <p>Title:UserRepository.java</p >
 * <p>Description:</p >
 *
 * @author Sephinor
 * @time 2019/12/15 12:11
 */

public interface UserRepository extends JpaRepository<User,Long> {

    User findById(long id);


    void deleteById(long id);
}
