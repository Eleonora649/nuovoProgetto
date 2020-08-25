package com.rentalcar.webapp.service;

import java.util.List;

import com.rentalcar.webapp.entities.User;

public interface UserService {

    void saveUser(User user);
    
    void updateUser(User user);
    
    void deleteUser(int id);
    
    User findUserById(int id);
    
    List<User> findAllUsers(); 
     
}
