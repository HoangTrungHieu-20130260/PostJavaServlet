package service;

import dao.UserDAOImp;
import model.User;

public class UserServiceImp implements IUserService{
    @Override
    public User signIn(String username, String password) {
        return new UserDAOImp().signIn(username, password);
    }
}
