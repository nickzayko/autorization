<%--
  Created by IntelliJ IDEA.
  User: Nikolay
  Date: 01.12.2017
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ошибка при регистрации</title>
</head>
<body>
<h3>Ошибка при регистрации!</h3>
<br><hr>
<h4>Пользователь с таким логином ${login} уже существует, введите новый логин!</h4>
<form action="registration.jsp" method="get">
    <input type="submit" value="Повторить регистрацию">
</form>

<form action="index.jsp" method="get">
    <input type="submit" value="Вернуться на начальную страницу">
</form>
</body>
</html>
