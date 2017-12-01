<%--
  Created by IntelliJ IDEA.
  User: Nikolay
  Date: 30.11.2017
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Init</title>
  </head>
  <body>
  <h1>Для дальнейшей работы необходимо авторизоваться</h1>
  <form action="/autorization">
    <div><pre>Введите логин            Введите пароль</pre></div>
    <input type="text" name="login">
    <input type="password" name="password">
    <input type="submit" value="Войти">
  </form>

  </body>
</html>
