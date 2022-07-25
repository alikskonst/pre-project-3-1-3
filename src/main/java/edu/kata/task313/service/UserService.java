package edu.kata.task313.service;

import edu.kata.task313.entity.User;

public interface UserService extends CommonService<User> {

    User findOne(String login);
}
