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
        try {
            int countOfEqualsUsers = 0;
            Users newUser = new Users();
            String userName = req.getParameter("userName");
            String userAge = (req.getParameter("userAge"));
            String userLogin = req.getParameter("userLogin");
            String userPassword = req.getParameter("userPassword");
            if (isNull(userLogin, userPassword, userName, userAge) ){
//            if (userName.trim().length() == 0 || userName == null || userLogin.trim().length() == 0 || userLogin == null || userAge == null || userPassword.trim().length() == 0 || userPassword == null) {
                req.getServletContext().getRequestDispatcher("/badRegistration2.jsp").forward(req, resp);
            } else {
                ArrayList<Users> users = new ArrayList<>();
                for (Users user : Users.getUsers()) {
                    users.add(user);
                }
                for (Users user : users) {
                    if (userLogin.equals(user.getLogin())) {
                        countOfEqualsUsers++;
                    }
                }

                if (countOfEqualsUsers != 0) {
                    req.getServletContext().setAttribute("login", userLogin);
                    req.getServletContext().getRequestDispatcher("/badRegistration.jsp").forward(req, resp);
                } else {
                    newUser.setName(userName);
                    newUser.setAge(Integer.parseInt(userAge));
                    newUser.setLogin(userLogin);
                    newUser.setPassword(userPassword);
                    newUser.saveUser();
                    req.getServletContext().setAttribute("login", userLogin);
                    req.getServletContext().setAttribute("password", userPassword);
                    req.getServletContext().setAttribute("name", userName);
                    req.getServletContext().setAttribute("age", userAge);
                    req.getServletContext().getRequestDispatcher("/goodRegistration.jsp").forward(req, resp);
                }
            }
        } catch (IOException e) {
            req.getServletContext().getRequestDispatcher("/badRegistration2.jsp").forward(req, resp);
        }
    }
    public boolean isNull (String userLogin, String userPassword, String userName, String userAge){
        boolean check;
        if (userName.trim().length() == 0 || userName == null || userLogin.trim().length() == 0 || userLogin == null || userAge == null || userPassword.trim().length() == 0 || userPassword == null){
            check = true;
        } else {
            check = false;
        }
        return check;
    }

    //делай так
//    if(isNull(user)){}
//
//    public boolean isNull(User u){
//        return isNull(u.userLogin) || isNull(u.userName) || ...;
//    }


}
