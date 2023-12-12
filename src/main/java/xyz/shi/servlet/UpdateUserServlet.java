package xyz.shi.servlet;

import xyz.shi.entity.User;
import xyz.shi.service.UserService;
import xyz.shi.service.impl.UserServiceImpl;
import xyz.shi.utils.GetUsersUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userUpdate")
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        int userId = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(userId, username, password);
        int flag = userService.modify(user);
        if (flag > 0) {
            System.out.println("修改数据成功");
            GetUsersUtils.GetUsers(request, response);
        } else {
            // 登录失败，返回登录页面
            System.out.println("修改数据失败");
            request.setAttribute("message", "failed");

        }
    }
}

