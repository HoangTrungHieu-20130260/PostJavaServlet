package model;


import java.sql.*;


public class PostModel {
    private int idPost;
    private int id_user;
    private String title;
    private String content;
    private Timestamp date;
    private String userName;
    public PostModel(){}
    //LocalDate createDate = Local.now();
    public PostModel(int id_post, int id_user, String title, String content, Timestamp date, String userName) {
        this.id_user = id_user;
        this.title = title;
        this.content = content;
        this.date = date;
        this.userName = userName;
        this.idPost = id_post;
    }
    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getIdPost() {
		return idPost;
	}
	public void setIdPost(int id_post) {
		this.idPost = id_post;
	}
	@Override
	public String toString() {
		return "PostModel [id_post=" + idPost + ", id_user=" + id_user + ", title=" + title + ", content=" + content
				+ ", date=" + date + ", userName=" + userName + "]";
	}
	
   
}
