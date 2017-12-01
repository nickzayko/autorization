package by.tms.servlets;


import by.tms.models.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/autorization")
public class Autorization extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String login = req.getParameter("login");
            String password = req.getParameter("password");
            ArrayList<Users> users = new ArrayList<Users>();
            if (login.trim().length() == 0 || login == null || password.trim().length() == 0 || password == null) {
                req.getServletContext().getRequestDispatcher("/badAutorization.jsp").forward(req, resp);
            } else {
                for (Users user : Users.getUsers()) {
                    users.add(user);
                }
                for (Users user : users) {
                    if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                        req.getServletContext().setAttribute("name", user.getName());
                        req.getServletContext().setAttribute("age", user.getAge());
                        req.getServletContext().setAttribute("login", user.getLogin());
                        req.getServletContext().setAttribute("password", user.getPassword());
                        req.getServletContext().getRequestDispatcher("/goodAutorization.jsp").forward(req, resp);
                    }
                }
            }
        } catch (IOException e) {
            req.getServletContext().getRequestDispatcher("/badAutorization.jsp").forward(req, resp);
        }
    }
}
