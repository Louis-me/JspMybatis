package xyz.shi.utils;

import xyz.shi.entity.User;
import xyz.shi.service.UserService;
import xyz.shi.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetUsersUtils {
    public static void GetUsers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String session = (String) req.getSession().getAttribute("username");
        if (session != null) {
            UserService userService = new UserServiceImpl();
            List<User> users = userService.getUserList();
            req.setAttribute("userList", users);
            req.getRequestDispatcher("homePage.jsp").forward(req, resp);;
        } else {
            // 登录失败，返回登录页面
            System.out.println("登录失败");
            req.setAttribute("error", "用户名或密码错误");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
