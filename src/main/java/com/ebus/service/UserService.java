package com.ebus.service;

import java.util.List;

import com.ebus.entity.TableModel;
import com.ebus.entity.User;

public interface UserService {
    List<User> getUsers(TableModel<User> tableModel);
    int getUsersAmount();
}
