package com.hospital.service;

import com.hospital.pojo.Admins;

public interface AdminService {

    Admins login(String name, String password);

}
