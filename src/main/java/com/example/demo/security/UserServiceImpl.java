package com.example.demo.security;

import org.springframework.stereotype.Service;

import javax.annotation.security.RolesAllowed;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public String addUser() {
        System.out.println("addUser");
        return "addUser_success";
    }

    @Override
    @RolesAllowed({"ROLE_USER", "ROLE_ADMIN"})
    public String updateUser() {
        System.out.println("updateUser");
        return "updateUser";
    }

    @Override
    @RolesAllowed("ROLE_ADMIN")
    public String deleteUser() {
        System.out.println("deleteUser");
        return "deleteUser";
    }
}
