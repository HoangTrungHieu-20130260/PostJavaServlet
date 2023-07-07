package controller;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PostModel;
import service.impls.PostService;

import java.io.IOException;
import java.util.List;


@WebServlet("/post")
public class PostController extends HttpServlet {
   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String id_user = request.getParameter("id_user");
	    int id_account = Integer.parseInt(id_user);
	    System.out.println("=>>>>>>>>>>>>>>>>>>>>>>>>"+id_account);
        PostService postSV = new PostService();
        List<PostModel> posts = postSV.getPostByIdUser(id_account);
        request.setAttribute("post", posts);
        RequestDispatcher rd = request.getRequestDispatcher("post.jsp");
        rd.forward(request, response);
    }		
}
