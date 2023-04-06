package com.kagami.j2ee.user.servlet;

import com.kagami.j2ee.user.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserDeleteServlet", value = "/user/delete")
public class UserDeleteServlet extends HttpServlet {

    private UserService userService = new UserService();

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);
    }

    public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String userid = request.getParameter("userid");
        Boolean result = this.userService.deleteUserInfo(userid == null ? 0 : Integer.parseInt(userid));
        if (!result)
            System.out.println("删除用户信息失败！");
        response.sendRedirect("list");
    }

    public void destroy() {
    }
}
