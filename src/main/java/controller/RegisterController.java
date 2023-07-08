package controller;

import model.Register;
import model.User;
import service.IUserService;
import service.impls.UserServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "registerController", value = "/registerController")
public class RegisterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String re_password = request.getParameter("re-password");
        Random random = new Random();
        int code = random.nextInt(9999);
        IUserService userService = new UserServiceImp();
        User user = userService.checkUserExist(username);
        if (!password.equals(re_password)) {
            request.setAttribute("notify", "<div class=\"alert alert-danger\" role=\"alert\">\n" +
                    "  Các mật khẩu không khớp!\n" +
                    "</div>");
            request.getRequestDispatcher("register.jsp").forward(request,response);
        } else if (user != null) {
            request.setAttribute("notify", "<div class=\"alert alert-danger\" role=\"alert\">\n" +
                    "  Email đã tồn tại!\n" +
                    "</div>");
            request.getRequestDispatcher("register.jsp").forward(request,response);
        } else {
            Register register = new Register(username,password,code);
            userService.sendMail(register);
            HttpSession session = request.getSession();
            session.setAttribute("register", register);
            response.sendRedirect("checkcoderegister.jsp");
        }
    }
}
    