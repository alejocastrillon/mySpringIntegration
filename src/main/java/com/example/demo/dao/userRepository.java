/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.dao;

import com.example.demo.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

/**
 *
 * @author alejandro
 */
public interface userRepository extends JpaRepositoryImplementation<User, Integer>{
    @Override
    User save(User user);
    
    @Override
    List<User> findAll();
    
    @Override
    void delete(User user);
    
    @Override
    Optional<User> findById(Integer iduser);
}
