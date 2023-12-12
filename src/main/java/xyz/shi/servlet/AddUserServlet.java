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

@WebServlet("/userAdd")
public class AddUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        user.setPassword(password);
        user.setName(username);
        int flag = userService.addUser(user);
        // 检查新增
        if (flag>0) {
            System.out.println("新增数据成功");
            GetUsersUtils.GetUsers(request, response);

        } else {
            // 登录失败，返回登录页面
            System.out.println("新增数据失败");
            request.setAttribute("message", "failed");

        }
    }
}
