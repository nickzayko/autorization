package by.tms.servlets;

import by.tms.models.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/registration")
public class Registration extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        int userAge = Integer.parseInt(req.getParameter("userAge"));
        String userLogin = req.getParameter("userLogin");
        String userPassword = req.getParameter("userPassword");
        ArrayList<Users> users = new ArrayList<>();
        for (Users user : Users.getUsers()){
            users.add(user);
        }
        for (Users user : users){
            if (userLogin.equals(user.getLogin())){
                req.getServletContext().setAttribute("login", userLogin);
                req.getServletContext().getRequestDispatcher("/badRegistration.jsp").forward(req, resp);
            }
        }
    }
}
