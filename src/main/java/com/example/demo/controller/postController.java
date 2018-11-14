/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.model.Posts;
import com.example.demo.service.postService;
import com.example.demo.util.RestResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alejandro
 */
@RestController
public class postController {
    
    @Autowired
    protected postService service;
    
    protected ObjectMapper mapper;
    
    @RequestMapping(value = "/posts/saveOrUpdate", method = RequestMethod.POST)
    public RestResponse saveOrUpdate(@RequestBody String postJson) throws IOException{
        this.mapper = new ObjectMapper();
        Posts post = this.mapper.readValue(postJson, Posts.class);
        if (isValidPost(post)) {
            this.service.save(post);
            return new RestResponse(HttpStatus.OK.value(), "El post ha sido guardado exitosamente");
        }
        return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(), "El post es invalido");
    }
    
    private boolean isValidPost(Posts post){
        if (post.getTitle() == null || post.getTitle().isEmpty()) {
            return false;
        } else if (post.getBody() == null || post.getBody().isEmpty()) {
            return false;
        } 
        return true;
    }
    
    @RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
    public Optional<Posts> getPost(@PathVariable("id") Integer idpost){
        return this.service.findById(idpost);
    }
    
    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public List<Posts> getPosts(){
        return this.service.findAll();
    }
    
    @RequestMapping(value = "/post/delete/{id}", method = RequestMethod.GET)
    public RestResponse deletePost(@PathVariable("id") Posts post){
        if (post != null) {
            this.service.delete(post);
            return new RestResponse(HttpStatus.OK.value(), "El post ha sido eliminado");
        }
        return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(), "El post no ha sido eliminado");
    }
}
