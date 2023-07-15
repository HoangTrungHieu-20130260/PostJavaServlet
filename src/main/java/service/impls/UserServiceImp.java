package service.impls;

import dao.impls.UserDAOImp;
import model.Register;
import model.User;
import service.IUserService;

import java.util.List;

public class UserServiceImp implements IUserService {
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

    @Override
    public void sendMail(Register register) {
        new UserDAOImp().sendMail(register);
    }
    @Override
    public List<User> userList(String username) {
        return new UserDAOImp().userList(username);
    }

    @Override
    public void changeStatus(String username, String status) {
        new UserDAOImp().changeStatus(username, status);
    }

    @Override
    public void deleteUser(int id) {
        new UserDAOImp().deleteUser(id);
    }
}
