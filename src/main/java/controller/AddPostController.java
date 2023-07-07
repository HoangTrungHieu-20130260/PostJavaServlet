package controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PostModel;
import service.impls.PostService;

@WebServlet("/addPost")
public class AddPostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public AddPostController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("addPost.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//PostModel post = new PostModel();
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String id_user = request.getParameter("id_user");
		String name_user = request.getParameter("user_name");
			int id = Integer.parseInt(id_user);
			System.out.println("==========================>"+id);
			System.out.println("==========================>"+title);
			System.out.println("==========================>"+content);
			PostService posts = new PostService();
			PostModel post = new PostModel(0, id, title, content, null, name_user);
			posts.addPost(post);
response.sendRedirect("index.jsp");
		
	}

}
