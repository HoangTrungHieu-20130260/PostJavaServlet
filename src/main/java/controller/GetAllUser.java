package controller;

import model.User;
import service.IUserService;
import service.impls.UserServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "getAllUser", value = "/getAllUser")
public class GetAllUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IUserService userService = new UserServiceImp();
        User user = (User) request.getSession().getAttribute("user");
        List<User> userList = userService.userList(user.getUsername());
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("admin.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
