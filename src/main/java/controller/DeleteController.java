package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PostModel;
import service.impls.PostService;

@WebServlet("/deletePost")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
        public DeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PostService postSV = new PostService();
		int id_Post = Integer.parseInt(request.getParameter("idPost"));
		System.out.println("idposst------------"+id_Post);
		PostModel post = new PostModel(id_Post, 0, null, null, null, null);
		postSV.deletePost(post);
		
	}

}
