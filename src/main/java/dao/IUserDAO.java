package dao;

import model.User;

public interface IUserDAO {
    User signIn(String userame, String password);
}
