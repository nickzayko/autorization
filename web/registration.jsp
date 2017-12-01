<%--
  Created by IntelliJ IDEA.
  User: Nikolay
  Date: 01.12.2017
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
</head>
<body>
<h2>Добро пожаловать на страничку регистрации!</h2>
<hr>
<h3>Напоминаем,что для успешной регистрации необходимо обязательно заполнить все поля, будьте внимательны при заполнении!</h3>
<br>
<form action="/registration" method="get">
    <div>Введите Ф.И.О.:</div>
    <input type="text" name="userName"><br>
    <div>Введите возраст:</div>
    <input type="number" name="userAge"><br>
    <div>Введите логин:</div>
    <input type="text" name="userLogin"><br>
    <div>Введите пароль:</div>
    <input type="text" name="userPassword"><br>
    <input type="submit" value="Зарегестрироваться">
</form>
</body>
</html>
