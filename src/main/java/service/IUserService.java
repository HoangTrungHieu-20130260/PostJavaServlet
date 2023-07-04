package service;

import model.User;

public interface IUserService {
    User signIn(String username, String password);
}
