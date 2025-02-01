package com.spring_security.demo.service;

import com.spring_security.demo.entities.JavaUser;
import com.spring_security.demo.repository.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserJPA userJPA;


    // getAll
    public List<JavaUser> getAllUser() {
        return userJPA.findAll();
    }

    // Create User
    public JavaUser createUser(JavaUser objUser) {
        return userJPA.save(objUser);
    }


    // login UserName
    public Boolean userEnterAuth(JavaUser objName) {
        List<JavaUser> obj = userJPA.findAll();

        for (JavaUser list : obj) {
            if (list.getNameUser().equals(objName.getNameUser())
                    &&
                    list.getPasswordUser().equals(objName.getPasswordUser())) {
                return true;
            }
        }
        return false;
    }
}
