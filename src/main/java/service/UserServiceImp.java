package service;

import dao.UserDAOImp;
import model.User;

public class UserServiceImp implements IUserService{
    @Override
    public User signIn(String username, String password) {
        return new UserDAOImp().signIn(username, password);
    }

    @Override
    public User checkUserExist(String username) {
        return new UserDAOImp().checkUserExist(username);
    }

    @Override
    public void register(String username, String password) {
        new UserDAOImp().register(username, password);
    }
}
