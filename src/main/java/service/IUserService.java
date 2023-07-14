package service;

import model.Register;
import model.User;

import java.util.List;

public interface IUserService {
    User signIn(String username, String password);
    User checkUserExist(String username);
    void register(String username, String password);
    void sendMail(Register register);
    List<User> userList(String username);
    void changeStatus(String username, String status);
}
