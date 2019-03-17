<%--
  Created by IntelliJ IDEA.
  User: Nikolay
  Date: 30.11.2017
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Начальная страница</title>
</head>
<body>
<h1>Добро пожаловать на начальную страницу!</h1>
<hr>
<h4>Информация о пользователе</h4>
<hr>
<div>Имя пользователя: ${user.name}</div>
<div>Возраст пользователя: ${age}</div>
<div>Логин: ${login}</div>
<div>Пароль: ${password}</div>
<br>
<hr>
<form action="index.jsp" method="get">
    <input type="submit" value="Выйти из учетной записи">
</form>
<hr>
</body>
</html>
