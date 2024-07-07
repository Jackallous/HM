package com.hospital.service;

import com.hospital.pojo.User;

import java.util.List;

public interface UserService {

    List<User> getUserList();

    User login(String user_username, String user_password);

}
