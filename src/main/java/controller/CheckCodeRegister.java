package controller;

import model.Register;
import service.IUserService;
import service.impls.UserServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "checkCodeRegister", value = "/checkCodeRegister")
public class CheckCodeRegister extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int code = Integer.parseInt(request.getParameter("code"));
        IUserService userService = new UserServiceImp();
        Register register = (Register) request.getSession().getAttribute("register");
        if (code != (register.getCode())) {
            request.setAttribute("notify", "<div class=\"alert alert-danger\" role=\"alert\">\n" +
                    "  Mã nhập không đúng!\n" +
                    "</div>");
            request.getRequestDispatcher("checkcoderegister.jsp").forward(request,response);
        } else {
            userService.register(register.getUsername(),register.getPassword());
            request.getSession().setAttribute("register", null);
            request.setAttribute("notify", "<div class=\"alert alert-success\" role=\"alert\">\n" +
                    "  Đăng ký thành công, đăng nhập để tiếp tục!\n" +
                    "</div>");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }
}
