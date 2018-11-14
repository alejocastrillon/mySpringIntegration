/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.dao.postRepository;
import com.example.demo.model.Posts;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alejandro
 */
@Service
public class postServiceImpl implements postService{

    @Autowired
    protected postRepository repository;
    
    @Override
    public Posts save(Posts post) {
        return this.repository.save(post);
    }

    @Override
    public Optional<Posts> findById(Integer idpost) {
        return this.repository.findById(idpost);
    }

    @Override
    public List<Posts> findAll() {
        return this.repository.findAll();
    }

    @Override
    public void delete(Posts post) {
        this.repository.delete(post);
    }
    
}
