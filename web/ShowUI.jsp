<%@ page import="com.Javarecruit.pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: 001
  Date: 2022/7/18
  Time: 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
用户id:${LoginU.uid}
<br>
用户名:${LoginU.uname}
<br>
手机号:${LoginU.phone}
<br>
身份证号:${LoginU.nid}
<br>
邮箱地址:${LoginU.email}
<br>
学历:${LoginU.study}
<br>
工作经验:${LoginU.job}
<br>
现住址:${LoginU.address}
<br>
<form action="MuI.jsp" method="post">
    <input type="submit" value="修改个人信息" name="sub">
</form>
</body>
</html>