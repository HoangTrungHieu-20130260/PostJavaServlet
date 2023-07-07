package service;

import model.User;

public interface IUserService {
    User signIn(String username, String password);
    User checkUserExist(String username);
    void register(String username, String password);
}
