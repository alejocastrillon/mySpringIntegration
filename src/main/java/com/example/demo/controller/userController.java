/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.userService;
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
public class userController {
    
    @Autowired
    protected userService service;
    
    protected ObjectMapper mapper;
    
    @RequestMapping( value = "/saveOrUpdate", method = RequestMethod.POST)
    public RestResponse saveOrUpdate(@RequestBody String userJSON) throws IOException{
        this.mapper = new ObjectMapper();
        User user = this.mapper.readValue(userJSON, User.class);
        if (this.isValidUser(user)) {
            this.service.saveOrUpdate(user);
            return new RestResponse(HttpStatus.OK.value(), "Usuario registrado exitosamente");
        }
        return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Por favor diligencie los campos obligatorios");
    }
    
    private boolean isValidUser(User user){
        if (user.getFirstName() == null || user.getFirstName().isEmpty()) {
            return false;
        } else if (user.getFirstSurname() == null || user.getFirstSurname().isEmpty()) {
            return false;
        } else if (user.getEmail() == null || user.getEmail().isEmpty()){
            return false;
        } else if (user.getPassword() == null || user.getPassword().isEmpty()) {
            return false;
        }
        return true;
    }
    
    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    public List<User> getUsers(){
        return this.service.findAll();
    }
    
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public RestResponse deleteUser(@PathVariable("id") User user){
        if (user != null) {
            this.service.delete(user);
            return new RestResponse(HttpStatus.OK.value(), "El usuario ha sido eliminado");
        }
        return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Ha sucedido un error");
    }
    
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public Optional<User> getUser(@PathVariable("id") Integer iduser){
        return this.service.findById(iduser);
    }
    
    @RequestMapping(value = "/deleteUserviaPost", method = RequestMethod.POST)
    public RestResponse deleteUserviaPost(@RequestBody String userJson) throws IOException{
        this.mapper = new ObjectMapper();
        User user = this.mapper.readValue(userJson, User.class);
        if (user != null) {
            this.service.delete(user);
            return new RestResponse(HttpStatus.OK.value(), "El usuario ha sido eliminado");
        }
        return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Ha sucedido un error");
    }
}
