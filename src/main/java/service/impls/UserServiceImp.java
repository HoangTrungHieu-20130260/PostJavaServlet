package service.impls;

import dao.impls.UserDAOImp;
import model.Register;
import model.User;
import service.IUserService;

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
}
