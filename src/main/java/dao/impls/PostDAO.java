package dao.impls;

import Database.DBConnect;
import dao.IPostDAO;
import model.PostModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostDAO implements IPostDAO {
    Statement statement = DBConnect.getInstall().get();
    Connection conn = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    //String sql1= "SELECT post.*, `account`.username AS `name` FROM post INNER JOIN `account` ON post.id_account = `account`.id_account";


    @Override
    public List<PostModel> getPost() {
        List<PostModel> posts = new ArrayList<>();
        String query = "select * from post";
        try {
            conn = statement.getConnection();
            preparedStatement = conn.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String title = resultSet.getString("title");
                String content = resultSet.getString("content");
                Date date = resultSet.getDate("date");
                int id_user = resultSet.getInt("id_account");
                PostModel post = new PostModel(id_user,title,content,date);
                posts.add(post);
            }
            return posts;
        }catch (SQLException e ) {
            throw new RuntimeException(e);

        }
    }

    @Override
    public void addPost(PostModel post) {

    }

    @Override
    public void updatePost(PostModel post) {

    }

    @Override
    public void deletePost(PostModel post) {

    }
}
