package dao;

import model.PostModel;

import java.util.List;

public interface IPostDAO {

    public List<PostModel> getPost () ;
    public void addPost(PostModel post);
    public void updatePost(PostModel post);
    public void deletePost(PostModel post);
}
