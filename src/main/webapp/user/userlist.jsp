<%@ page import="com.kagami.j2ee.user.entity.UserInfo" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>UserList</title>
</head>

<%
    UserInfo searchCondition = (UserInfo)session.getAttribute("searchCondition");
    List<UserInfo> userInfos = (List) session.getAttribute("userInfos");
    if (userInfos != null && searchCondition != null) { %>
<script type="text/javascript">
    // alert("<%= "当前用户数量" + userInfos.size() + "！" %>");
</script>
<% } else { %>
<script type="text/javascript">
    alert("查询用户列表信息出错！");
</script>
<% }%>
<script type="text/javascript">
    function getUserInfo(userid) {
        let obj = document.getElementById("userid");
        obj.value = userid;
        let form = document.getElementById("forward");
        form.action = "content";
        form.submit();
    }

    function modifyUserInfo(userid) {
        let obj = document.getElementById("userid");
        obj.value = userid;
        let form = document.getElementById("forward");
        form.action = "premodify";
        form.submit();
    }

    function deleteUserInfo(userid, userName) {
        if (confirm("是否确认删除用户《" + userName + "》的信息？") == true) {
            let obj = document.getElementById("userid");
            obj.value = userid;
            let form = document.getElementById("forward");
            form.action = "delete";
            form.submit();
        }
    }
</script>
<body>
<h1 align="center">用户信息列表</h1>
<br>
<form action="list" method="post">
    <div align="center">
        <label style="size: 48px; align-content: center">
            <strong>用户查询</strong>
        </label>
    </div>
    <br>
    <div align="center">
        用户：<input type="text" name="username" value="<%=searchCondition.getUserName()%>"/>
        &nbsp;&nbsp;
        性别：<input type="text" name="sex" value="<%=searchCondition.getSex()%>"/>
        &nbsp;&nbsp;

        <input type="submit" value="查询">
    </div>
</form>
<form id="forward" action="" method="post">
    <input type="hidden" name="userid" id="userid">
</form>
<br>
<table align="center" border="1" width="90%">
    <tr>
        <th width="30%">用户</th>
        <th width="20%">密码</th>
        <th width="20%">性别</th>
        <th width="15%">电话</th>
        <th>操作</th>
    </tr>
    <% for (UserInfo userInfo : userInfos) { %>
    <tr>
        <td align="center"><a href="#"
                              onclick="getUserInfo(<%=userInfo.getUserid()%>)"><%=userInfo.getUserName()%>
        </a></td>
        <td align="center"><%=userInfo.getPassword()%>
        </td>
        <td align="center"><%=userInfo.getSex()%>
        </td>
        <td align="center"><%=userInfo.getPhone()%>
        </td>
        <td align="center">
            <button type="button" id="modify" onclick="modifyUserInfo(<%=userInfo.getUserid()%>)">修改</button>
            &nbsp;
            <button type="button" id="delete" onclick="deleteUserInfo(<%=userInfo.getUserid()%>, '<%=userInfo.getUserName()%>')">删除</button>
        </td>
    </tr>
    <% } %>
</table>
<br>
<div align="center">
    <button type="button" onclick="javascript:location.href='useradd.jsp';">添加用户</button>
</div>
</body>
</html>
