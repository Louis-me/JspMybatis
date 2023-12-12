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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GetUsersUtils.GetUsers(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        user.setName(username);
        user.setPassword(password);
          User isUser = userService.queryOne(user);
        // 验证用户名和密码
        if (isUser != null) {
            // 登录成功，创建会话
            HttpSession session = request.getSession();
            List<User> users = userService.getUserList();
            request.setAttribute("userList", users);
            session.setAttribute("username", username);
            System.out.println("登录成功");
            request.getRequestDispatcher("homePage.jsp").forward(request, response);;
        } else {
            // 登录失败，返回登录页面
            System.out.println("登录失败");
            request.setAttribute("error", "用户名或密码错误");
            request.getRequestDispatcher("login.jsp").forward(request, response);

        }
    }
}
