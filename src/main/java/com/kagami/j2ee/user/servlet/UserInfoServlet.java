package com.kagami.j2ee.user.servlet;

import com.kagami.j2ee.user.entity.UserInfo;
import com.kagami.j2ee.user.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserInfoServlet", value = "/user/content")
public class UserInfoServlet extends HttpServlet {

    private UserService userService = new UserService();

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);
    }

    public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String userid = request.getParameter("userid");
        UserInfo userInfo = this.userService.getUserInfo(userid == null ? 0 : Integer.parseInt(userid));
        request.getSession().setAttribute("userInfo", userInfo);
        request.getRequestDispatcher("userinfo.jsp").forward(request,response);
    }

    public void destroy() {
    }
}
