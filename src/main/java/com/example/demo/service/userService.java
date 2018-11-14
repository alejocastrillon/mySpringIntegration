/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.model.User;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author alejandro
 */
public interface userService {

    public User saveOrUpdate(User user);

    public List<User> findAll();

    public void delete(User user);

    public Optional<User> findById(Integer iduser);
    
}
