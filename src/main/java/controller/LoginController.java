package controller;

import model.User;
import service.IUserService;
import service.UserServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginController", value = "/loginController")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        IUserService userService = new UserServiceImp();
        User user = userService.signIn(username,password);
        if (user == null) {
            request.setAttribute("notify", "<div class=\"alert alert-danger\" role=\"alert\">\n" +
                    "  Tài khoản hoặc mật khẩu không đúng!\n" +
                    "</div>");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        } else if (user.getStatus().equals("bị khóa")){
            request.setAttribute("notify", "<div class=\"alert alert-danger\" role=\"alert\">\n" +
                    "  Tài khoản đã bị khóa!\n" +
                    "</div>");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("index.jsp");
        }
    }
}
