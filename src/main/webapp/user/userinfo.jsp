<%@ page import="com.kagami.j2ee.user.entity.UserInfo" %>
<%@ page import="java.util.List" %>
<%@ page import="com.kagami.j2ee.user.entity.UserInfo" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>BookInfo</title>
</head>
<%
    UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
    if(userInfo == null) { %>
<script type="text/javascript">
    alert("未查询到指定用户的信息！");
</script>
<%  } %>
<body>
<h1 align="center">用户详细信息</h1>
<br/>
<form action="list" method="post">
</form>
<table align="center" border="1" width="60%">
    <tr>
        <td width="25%" align="center">昵称</td>
        <td align="center"><%=userInfo.getUserName()%></td>
    </tr>
    <tr>
        <td align="center">密码</td>
        <td align="center"><%=userInfo.getPassword()%></td>
    </tr>
    <tr>
        <td align="center">性别</td>
        <td align="center"><%=userInfo.getSex()%></td>
    </tr>
    <tr>
        <td align="center">电话</td>
        <td align="center"><%=userInfo.getPhone()%></td>
    </tr>
</table>
<br>
<div align="center">
    <button type="button" onclick="javascript:history.back();">返回</button>
</div>
</body>
</html>
