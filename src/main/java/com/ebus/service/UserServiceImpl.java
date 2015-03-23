package com.ebus.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ebus.entity.TableModel;
import com.ebus.entity.User;

@Service("userService")
public class UserServiceImpl implements UserService {

    List<User> users = new ArrayList<User>();

    public UserServiceImpl() {
        for (int i = 1; i <= 100; i++) {
            User user = new User();
            user.setUserId(i);
            user.setFirstName("First Name " + i);
            user.setLastName("Last Name " + i);
            users.add(user);
        }
    }

    

    public int getUsersAmount() {
        return users.size();
    }
}
