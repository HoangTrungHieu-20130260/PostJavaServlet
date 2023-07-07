package dao.impls;

import Database.DBConnect;
import dao.IPostDAO;
import model.PostModel;

import java.sql.*;
import java.util.ArrayList;
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
        String query = "SELECT post.*, `account`.username AS `name` FROM post INNER JOIN `account` ON post.id_account = `account`.id_account order by `date_time` desc ";
        try {
            conn = statement.getConnection();
            preparedStatement = conn.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String title = resultSet.getString("title");
                int id_post = resultSet.getInt("id_post");
                String content = resultSet.getString("content");
                int id_user = resultSet.getInt("id_account");
                String userName = resultSet.getString("name");
                Timestamp date1 = resultSet.getTimestamp("date_time");
                PostModel post = new PostModel(id_post,id_user,title,content,date1, userName);
                posts.add(post);
            }
            return posts;
        }catch (SQLException e ) {
            throw new RuntimeException(e);

        }
    }

    @Override
    public void addPost(PostModel post) {
    	

    	String query = "insert into post(title, content, date_time, id_account) values(?,?,?,?)";
    	try {
			conn = statement.getConnection();
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, post.getTitle());
			preparedStatement.setString(2, post.getContent());
			preparedStatement.setTimestamp(3, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
			preparedStatement.setInt(4, post.getId_user());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    @Override
    public void updatePost(PostModel post) {
    	String query = "update post set title = ?, content = ?, date_time = ? where id_post = ?";
    	try {
			conn = statement.getConnection();
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, post.getTitle());
			preparedStatement.setString(2,post.getContent());
			preparedStatement.setTimestamp(3, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
			preparedStatement.setInt(4, post.getIdPost());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

    @Override
    public void deletePost(PostModel post) {
    	String query = "delete from post where id_post = ?";
    	try {
			conn = statement.getConnection();
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, post.getIdPost());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

	@Override
	public List<PostModel> getPostByIdUser(int id_user) {
		List<PostModel> posts = new ArrayList<>();
	    String query = "SELECT post.*, `account`.username AS `name` FROM post INNER JOIN `account` ON post.id_account = `account`.id_account WHERE post.id_account = ? ORDER BY post.date_time desc";
		try {
			conn = statement.getConnection();
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, id_user);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				    int id_account = resultSet.getInt("id_account");
				    String title = resultSet.getString("title");
				    int id_post = resultSet.getInt("id_post");
	                String content = resultSet.getString("content");
	                Timestamp date = resultSet.getTimestamp("date_time");
	                String username = resultSet.getString("name");
	                PostModel post = new PostModel(id_post,id_user, title, content, date, username);
	                posts.add(post);
			}
			return posts;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		// TODO Auto-generated method stub
	
	}

	@Override
	public PostModel getPostByIdPost(int idPost) {
		PostModel postModel = null;
		String query = "SELECT post.*, `account`.username AS `name` FROM post INNER JOIN `account` ON post.id_account = `account`.id_account WHERE post.id_post = ? ORDER BY post.date_time desc";
		try {
			conn = statement.getConnection();
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1,idPost);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
                int id_post = resultSet.getInt("id_post");
				String title = resultSet.getString("title");
                String content = resultSet.getString("content");
                int id_user = resultSet.getInt("id_account");
                String userName = resultSet.getString("name");
                Timestamp date1 = resultSet.getTimestamp("date_time");
                postModel = new PostModel(id_post,id_user,title,content,date1, userName);
            	
			}
			return postModel;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return postModel;
	
	}
}
