package com.kagami.j2ee.user.dao;

import com.kagami.j2ee.user.entity.UserInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private Connection conn;

    public UserDao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/test?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8&useSSL=false";
            String user = "root";
            String passwd = "yxr520210";
            this.conn = DriverManager.getConnection(url, user, passwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//查询语句
    public List<UserInfo> list(UserInfo userInfo) {
        List<UserInfo> userInfos = new ArrayList<UserInfo>();
        try {
            String sql = "select * from book_info where username like ? and password like ? and sex like ?";
            PreparedStatement stat = this.conn.prepareStatement(sql);
            String b = userInfo.getUserName() == null ? "" : userInfo.getUserName();
            String c = userInfo.getPassword() == null ? "" : userInfo.getPassword();
            String e = userInfo.getSex() == null ? "" : userInfo.getSex();
            stat.setString(1, "%" + b + "%");
            stat.setString(2, "%" + c + "%");
            stat.setString(3, "%" + e + "%");
//            stat.setString(1, "%" + userInfo.getUserName() == null ? "" : userInfo.getUserName() + "%");
//            stat.setString(2, "%" + userInfo.getPassword() == null ? "" : userInfo.getPassword() + "%");
//            stat.setString(3, "%" + userInfo.getSex() == null ? "" : userInfo.getSex() + "%");
            ResultSet result = stat.executeQuery();
            while (result.next()) {
                UserInfo user = new UserInfo();
                user.setUserid(result.getInt("userid"));
                user.setUserName(result.getString("username"));
                user.setPassword(result.getString("password"));
                user.setPhone(result.getString("phone"));
                user.setSex(result.getString("sex"));
                userInfos.add(user);
            }
            result.close();
            stat.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userInfos;
    }

    public UserInfo get(int userid) {
        UserInfo userInfo = null;
        try {
            String sql = "select * from book_info where userid=?";
            PreparedStatement stat = this.conn.prepareStatement(sql);
            stat.setInt(1, userid);
            ResultSet result = stat.executeQuery();
            if (result.next()) {
                userInfo = new UserInfo();
                userInfo.setUserid(result.getInt("userid"));
                userInfo.setUserName(result.getString("username"));
                userInfo.setPassword(result.getString("password"));
                userInfo.setPhone(result.getString("phone"));
                userInfo.setSex(result.getString("sex"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userInfo;
    }

    public UserInfo insert(UserInfo userInfo) {
        int result = 0;
        try {
            String sql = "insert into book_info(username,password,phone,sex) value(?,?,?,?)";
            PreparedStatement stat = this.conn.prepareStatement(sql);
            stat.setString(1, userInfo.getUserName());
            stat.setString(2, userInfo.getPassword());
            stat.setString(3, userInfo.getPhone());
            stat.setString(4, userInfo.getSex());
            result = stat.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result > 0)
            return userInfo;
        else
            return null;
    }

    public UserInfo update(UserInfo userInfo) {
        int result = 0;
        try {
            String sql = "update book_info set username=?,password=?,phone=?,sex=? where userid=?";
            PreparedStatement stat = this.conn.prepareStatement(sql);
            stat.setString(1, userInfo.getUserName());
            stat.setString(2, userInfo.getPassword());
            stat.setString(3, userInfo.getPhone());
            stat.setString(4, userInfo.getSex());
            stat.setInt(5, userInfo.getUserid());
            result = stat.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result > 0)
            return userInfo;
        else
            return null;
    }

    public Boolean delete(int userid) {
        Boolean success = false;
        try {
            String sql = "delete from book_info where userid=?";
            PreparedStatement stat = this.conn.prepareStatement(sql);
            stat.setInt(1, userid);
            int result = stat.executeUpdate();
            if (result > 0)
                success = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }
}
