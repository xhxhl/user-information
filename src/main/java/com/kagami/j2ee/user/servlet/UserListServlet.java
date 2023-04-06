package com.kagami.j2ee.user.servlet;

import com.kagami.j2ee.user.entity.UserInfo;
import com.kagami.j2ee.user.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserListServlet", value = "/user/list")
public class UserListServlet extends HttpServlet {

    private UserService userService = new UserService();

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);
    }

    public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(request.getParameter("username") == null ? "" : request.getParameter("username"));
        userInfo.setPassword(request.getParameter("password") == null ? "" : request.getParameter("password"));
        userInfo.setSex(request.getParameter("sex") == null ? "" : request.getParameter("sex"));
        List<UserInfo> userInfos = this.userService.getBookInfos(userInfo);
        request.getSession().setAttribute("searchCondition", userInfo);
        request.getSession().setAttribute("userInfos", userInfos);
        request.getRequestDispatcher("userlist.jsp").forward(request,response);
    }

    public void destroy() {
    }
}
