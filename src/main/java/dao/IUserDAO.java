package dao;

import model.Register;
import model.User;

import java.util.List;

public interface IUserDAO {
    User signIn(String userame, String password);
    User checkUserExist(String username);
    void register(String username, String password);
    void sendMail(Register register);
    List<User> userList(String username);
    void changeStatus(String username, String status);
    void deleteUser(int id);
}
