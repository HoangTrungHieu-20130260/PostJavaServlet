package dao.impls;

import Database.DBConnect;
import dao.IUserDAO;
import model.Register;
import model.User;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

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
                "values(?,?,2,'enable')";
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

    @Override
    public void sendMail(Register register) {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.name", "Blog Web");

        String subject = "Mã OTP đăng ký Blog Web";
        String text = "<h1 style=\"padding: 0; font-size: 25px;color: #2dd100;font-family:sans-serif\">Mã đăng ký Blog Web</h1>" +
                "<p style=\"padding: 0;font-size: 14px;color: #000000;font-family:sans-serif\">Mã OTP của bạn, hãy nhập OTP: <strong style=\"font-size: 18px; color: #2dd100; font-family:sans-serif\">" + register.getCode() + "</strong></p>" +
                "<p style=\"padding: 0;font-size: 14px;color: #000000;font-family:sans-serif\">Cảm ơn bạn,</p><p style=\"padding: 0;font-size: 14px;color: #2dd100;font-family:sans-serif\">BlogWeb.</p>";
        String account = "hthclone01@gmail.com";
        String pass = "cclrphrhungmhhbm";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(account,pass);
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(account));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(register.getUsername()));
            message.setHeader("Content-Type", "text/html; charset=UTF-8");
            message.setSubject(subject);
            message.setContent(text, "text/html; charset=UTF-8");
            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> userList(String username) {
        List<User> userList = new ArrayList<>();
        String query = "SELECT * FROM `account` WHERE username NOT LIKE ?";
        statement = DBConnect.getInstall().get();
        try {
            preparedStatement = statement.getConnection().prepareStatement(query);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                userList.add(new User(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getString(5)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }

    @Override
    public void changeStatus(String username, String status) {
        String query = "UPDATE account SET status = ? WHERE username = ?;";
        statement = DBConnect.getInstall().get();
        try {
            preparedStatement = statement.getConnection().prepareStatement(query);
            preparedStatement.setString(1, status);
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteUser(int id) {
        String disableForeign = "SET FOREIGN_KEY_CHECKS=0;";
        String query = "DELETE `account`, `post`\n" +
                "FROM account\n" +
                "LEFT JOIN post ON account.id_account = post.id_account\n" +
                "WHERE account.id_account = ?;";
        String enableForeign =  "SET FOREIGN_KEY_CHECKS=1;";

        statement = DBConnect.getInstall().get();
        try {
            preparedStatement = statement.getConnection().prepareStatement(disableForeign);
            preparedStatement.executeUpdate();
            preparedStatement.close();

            preparedStatement = statement.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();

            preparedStatement = statement.getConnection().prepareStatement(enableForeign);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new UserDAOImp().deleteUser(6);
    }

}
