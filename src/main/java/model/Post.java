package model;

public class Post {
    private int id_post;
    private String title;
    private String content;
    private String date;
    private int id_user;

    public Post(int id_post, String title, String content, String date, int id_user) {
        this.id_post = id_post;
        this.title = title;
        this.content = content;
        this.date = date;
        this.id_user = id_user;
    }

    public int getId_post() {
        return id_post;
    }

    public void setId_post(int id_post) {
        this.id_post = id_post;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id_post=" + id_post +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", date='" + date + '\'' +
                ", id_user=" + id_user +
                '}';
    }
}
