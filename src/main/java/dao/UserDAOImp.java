package dao;

import Database.DBConnect;
import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAOImp implements IUserDAO {
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    @Override
    public User signIn(String username, String password) {
        String query = "SELECT * FROM account WHERE username LIKE ? AND password LIKE ?";
        statement = DBConnect.getInstall().get();
        try {
            preparedStatement = statement.getConnection().prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2,password);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return new User(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getString(5));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public User checkUserExist(String username) {
        String query = "SELECT * FROM account WHERE username LIKE ?";
        statement = DBConnect.getInstall().get();
        try {
            preparedStatement = statement.getConnection().prepareStatement(query);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return new User(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getString(5));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void register(String username, String password) {
        String query = "insert into account(username, password, roles, status)" +
                "values(?,?,1,'bình thường')";
        statement = DBConnect.getInstall().get();
        try {
            preparedStatement = statement.getConnection().prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2,password);
            preparedStatement.executeUpdate();
            System.out.println("insert access");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
