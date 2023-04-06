<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>BookAdd</title>
</head>
<body>
<h1 align="center">新增用户信息</h1>
<br/>
<form action="add" method="post">
    <table align="center" border="0" width="60%">
        <tr>
            <td width="25%" align="right">用户：</td>
            <td align="left" width="100%">
                <input type="text" name="username" value="" style="width: 75%">
            </td>
        </tr>
        <tr>
            <td align="right">密码：</td>
            <td align="left" width="100%">
                <input type="text" name="password" value="" style="width: 75%">
        </tr>
        <tr>
            <td align="right">性别：</td>
            <td align="left" width="100%">
                <input type="text" name="sex" value="" style="width: 75%">
            </td>
        </tr>
        <tr>
            <td align="right">电话：</td>
            <td align="left" width="100%">
                <input type="text" name="phone" value="" style="width: 75%">
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
