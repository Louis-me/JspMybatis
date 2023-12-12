package xyz.shi.servlet;

import xyz.shi.entity.User;
import xyz.shi.service.UserService;
import xyz.shi.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userFind")
public class FindUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        int userId = Integer.parseInt(req.getParameter("id"));
        User user = userService.queryById(userId);
        if (user != null) {
            req.setAttribute("user", user);
            req.getRequestDispatcher("find.jsp").forward(req, resp);
        } else {
            // 登录失败，返回登录页面
            System.out.println("查找数据失败");
            req.setAttribute("message", "failed");

        }
    }
}

