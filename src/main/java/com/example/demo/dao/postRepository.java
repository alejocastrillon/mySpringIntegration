/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.dao;

import com.example.demo.model.Posts;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

/**
 *
 * @author alejandro
 */
public interface postRepository extends JpaRepositoryImplementation<Posts, Integer>{
    
    @Override
    Posts save(Posts post);
    
    @Override
    Optional<Posts> findById(Integer idpost);
    
    @Override
    List<Posts> findAll();
    
    @Override
    void delete(Posts post);
}
