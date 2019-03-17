<%--
  Created by IntelliJ IDEA.
  User: Nikolay
  Date: 01.12.2017
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
</head>
<body>
<h3>Поздравляем Вас с успешной регистрацией!</h3>
<br><hr>
<h4>Запомните Ваши данные для использования в дальнейшем:</h4>
<br><hr>
<div>Ваш логин: ${login}</div><br>
<div>Ваш пароль: ${password}</div><br>
<div>Имя: ${name}</div><br>
<div>Возраст: ${age}</div><br>
<form action="goodAutorization.jsp" method="get">
    <input type="submit" value="Начать работу">
</form>
</body>
</html>
