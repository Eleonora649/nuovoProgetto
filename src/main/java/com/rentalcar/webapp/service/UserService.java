package com.rentalcar.webapp.service;

import java.util.List;

import com.rentalcar.webapp.entities.UserEntity;

public interface UserService {

    void saveUser(UserEntity user);
    
    void updateUser(UserEntity user);
    
    void deleteUser(int id);
    
    UserEntity findUserById(int id);
    
    List<UserEntity> findAllUsers(); 

//    UserEntity findByEmail(String email);

    
}
