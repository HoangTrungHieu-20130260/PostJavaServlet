package controller;

import model.User;
import service.IUserService;
import service.impls.UserServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "changeStatus", value = "/changeStatus")
public class ChangeStatus extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        IUserService userService = new UserServiceImp();
        User user = userService.checkUserExist(username);
        if (user.getStatus().equals("disable")) {
            userService.changeStatus(username, "enable");
        } else {
            userService.changeStatus(username, "disable");
        }
        response.sendRedirect("getAllUser");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
