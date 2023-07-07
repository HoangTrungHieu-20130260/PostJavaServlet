	package service.impls;

import dao.IPostDAO;
import dao.impls.PostDAO;
import model.PostModel;
import service.IPostService;

import java.util.List;

public class PostService implements IPostService {

    @Override
    public List<PostModel> getPost() {
        return new PostDAO().getPost();
    }
// đẻ đây có gì cần thì tham khảo
//    @Override
//    public List<PostModel> getPost() {
//        IPostDAO postDAO = new PostDAO();
//        List<PostModel> postModels = postDAO.getPost();
//        return postModels;
//    }

	@Override
	public List<PostModel> getPostByIdUser(int id_user) {
		// TODO Auto-generated method stub
		return new PostDAO().getPostByIdUser(id_user);
	}

	@Override
	public void addPost(PostModel postModel) {
		new PostDAO().addPost(postModel);
		
	}

	@Override
	public PostModel getPostByIdPost(int idPost) {
		// TODO Auto-generated method stub
		return new PostDAO().getPostByIdPost(idPost);
	}

	@Override
	public void updatePost(PostModel post) {
	   new PostDAO().updatePost(post);
		
	}

	@Override
	public void deletePost(PostModel post) {
		new PostDAO().deletePost(post);
		
	}



}
