/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.model.Posts;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author alejandro
 */
public interface postService {

    public Posts save(Posts post);

    public Optional<Posts> findById(Integer idpost);

    public List<Posts> findAll();

    public void delete(Posts post);
    
}
