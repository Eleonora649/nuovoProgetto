package com.rentalcar.webapp.service;

import java.util.List;

import com.rentalcar.webapp.entities.UserEntity;

public interface UserService {

    void saveUser(UserEntity user);
    
    void updateUser(UserEntity user);
    
    void deleteUser(int id);
    
    UserEntity findUserById(int id);
    
    List<UserEntity> findAllUsers();

//	boolean checkLogin(String email,String password);

    UserEntity findUserByEmail(String email);

	boolean authenticate(String email, String password);
}
