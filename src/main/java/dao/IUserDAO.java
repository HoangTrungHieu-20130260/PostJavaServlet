package dao;

import model.Register;
import model.User;

public interface IUserDAO {
    User signIn(String userame, String password);
    User checkUserExist(String username);
    void register(String username, String password);
    void sendMail(Register register);
}
