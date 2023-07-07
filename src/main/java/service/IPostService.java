package service;

import model.PostModel;

import java.util.List;

public interface IPostService {
    public List<PostModel> getPost();
    public List<PostModel> getPostByIdUser(int id_user);
    public void addPost(PostModel postModel);
    public PostModel getPostByIdPost(int idPost);
    public void updatePost(PostModel post);
    public void deletePost(PostModel post);
}
