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
            int ifUserExist = 0;
            Users tmpUser = new Users();
            String login = req.getParameter("login");
            String password = req.getParameter("password");
            ArrayList<Users> users = new ArrayList<Users>();
            if (isNull(login, password)){
                req.getServletContext().getRequestDispatcher("/badAutorization.jsp").forward(req, resp);
//                goToBadAutorization();
            } else {
                for (Users user : Users.getUsers()) {
                    users.add(user);
                }
                for (Users user : users) {
                    if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                       ifUserExist++;
                       tmpUser = user;
                    }
                }
            }
            if (ifUserExist != 0){
                req.getServletContext().setAttribute("name", tmpUser.getName());
                req.getServletContext().setAttribute("age", tmpUser.getAge());
                req.getServletContext().setAttribute("login", tmpUser.getLogin());
                req.getServletContext().setAttribute("password", tmpUser.getPassword());
                req.getServletContext().getRequestDispatcher("/goodAutorization.jsp").forward(req, resp);
            } else {
                req.getServletContext().getRequestDispatcher("/badAutorization.jsp").forward(req, resp);
//                goToBadAutorization();
            }
        } catch (IOException e) {
            req.getServletContext().getRequestDispatcher("/badAutorization.jsp").forward(req, resp);
        }
    }


//    public void goToBadAutorization () {
//        ServletRequest req = null;
//        ServletResponse resp = null;
//        try {
//             req.getServletContext().getRequestDispatcher("/badAutorization.jsp").forward(req, resp);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    public boolean isNull (String login, String password){
        boolean check;
        if (login == null || password == null || login.trim().length() == 0 || password.trim().length() == 0){
            check = true;
        } else {
            check = false;
        }
        return check;
    }


}
