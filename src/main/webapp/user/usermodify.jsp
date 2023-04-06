 <%@ page import="com.kagami.j2ee.user.entity.UserInfo" %>
<%@ page import="java.util.List" %>
 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>UserModify</title>
</head>
<%
    UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
    if (userInfo == null) { %>
<script type="text/javascript">
    alert("未查询到指定书籍的信息！");
</script>
<% } %>
<body>
<h1 align="center">修改用户信息</h1>
<br/>
<form action="modify" method="post">
<input type="hidden" name="userid" value="<%=userInfo.getUserid()%>">
<table align="center" border="0" width="60%">
        <tr>
            <td width="25%" align="right">昵称：</td>
            <td align="left" width="100%">
                <input type="text" name="userName" value="<%=userInfo.getUserName()%>" style="width: 75%">
            </td>
        </tr>
        <tr>
            <td align="right">密码：</td>
            <td align="left" width="100%">
                <input type="text" name="password" value="<%=userInfo.getPassword()%>" style="width: 75%">
        </tr>
        <tr>
            <td align="right">性别：</td>
            <td align="left" width="100%">
                <input type="text" name="sex" value="<%=userInfo.getSex()%>" style="width: 75%">
            </td>
        </tr>
        <tr>
            <td align="right">电话：</td>
            <td align="left" width="100%">
                <input type="text" name="phone" value="<%=userInfo.getPhone()%>" style="width: 75%">
            </td>
        </tr>
    </table>
    <br>
    <div align="center">
        <button type="submit">提交</button>
        &nbsp;
        <button type="button" onclick="javascript:history.back();">返回</button>
    </div>
</form>
</body>
</html>
