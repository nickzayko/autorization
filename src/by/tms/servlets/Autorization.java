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
//            if (isNull(login, password)){

            //Лучше так
            if (isNull(login) || isNull(password)){



                req.getServletContext().getRequestDispatcher("/badAutorization.jsp").forward(req, resp);
            } else {


                for (Users user : Users.getUsers()) {
                    if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                       ifUserExist++;
                       tmpUser = user;
                       break;
                    }
                }
            }


            if (ifUserExist != 0){


//                req.getServletContext().setAttribute("name", tmpUser.getName());
                req.getServletContext().setAttribute("age", tmpUser.getAge());
                req.getServletContext().setAttribute("login", tmpUser.getLogin());
                req.getServletContext().setAttribute("password", tmpUser.getPassword());

                req.getServletContext().setAttribute("user", tmpUser);

                req.getServletContext().getRequestDispatcher("/goodAutorization.jsp").forward(req, resp);
            } else {
                req.getServletContext().getRequestDispatcher("/badAutorization.jsp").forward(req, resp);
            }
        } catch (IOException e) {
            req.getServletContext().getRequestDispatcher("/badAutorization.jsp").forward(req, resp);
        }
    }



//    public boolean isNull (String login, String password){
//        boolean check;
//        if (login == null || password == null || login.trim().length() == 0 || password.trim().length() == 0){
//            check = true;
//        } else {
//            check = false;
//        }
//        return check;
//    }


       // И лучше так
    public boolean isNull (String str){
        boolean check;
        if (str == null || str.trim().length() == 0){
            check = true;
        } else {
            check = false;
        }
        return check;
    }

     // равнозначные
//    public boolean isNull (String str)
//        return if (str == null || str.trim().length() == 0);
}




