package com.kagami.j2ee.user.servlet;

import com.kagami.j2ee.user.entity.UserInfo;
import com.kagami.j2ee.user.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserModifyServlet", value = "/user/modify")
public class UserModifyServlet extends HttpServlet {

    private UserService userService = new UserService();

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);
    }

    public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserid(request.getParameter("userid") == null ? 0 : Integer.parseInt(request.getParameter("userid")));
        userInfo.setUserName(request.getParameter("userName") == null ? "" : request.getParameter("userName"));
        userInfo.setPassword(request.getParameter("password") == null ? "" : request.getParameter("password"));
        userInfo.setSex(request.getParameter("sex") == null ? "" : request.getParameter("sex"));
        userInfo.setPhone(request.getParameter("phone") == null ? "" : request.getParameter("phone"));
        UserInfo result = this.userService.modifyUserInfo(userInfo);
        if (result == null)
            System.out.println("修改书籍信息失败！");
        response.sendRedirect("list");
    }

    public void destroy() {
    }
}
