package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.PostModel;
import model.User;
import service.impls.PostService;

@WebServlet("/updatePost")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
	    int id = Integer.parseInt(request.getParameter("idPost"));
		System.out.println("idposst------------------"+id);
		PostService postService = new PostService();
		PostModel post = postService.getPostByIdPost(id);
		request.setAttribute("post", post);
		RequestDispatcher rd = request.getRequestDispatcher("updatePost.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PostService postSV = new PostService();
		int idPost = Integer.parseInt(request.getParameter("id_post"));
		System.out.println("===========================idPost"+idPost);
		String title = request.getParameter("title");
		System.out.println("===========================title"+title);
		String content = request.getParameter("content");
		System.out.println("===========================content"+content);
		PostModel post = new PostModel(idPost, 0, title, content, null, null);
		postSV.updatePost(post);
		response.sendRedirect("index.jsp");
		
	}

}
