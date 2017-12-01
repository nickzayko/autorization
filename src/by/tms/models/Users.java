package by.tms.models;

import by.tms.database.UsersConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Users {
    private int id;
    private String name;
    private String login;
    private String password;
    private int age;

    public Users(int id, String name, String login, String password, int age) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.age = age;
    }

    public Users() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static ArrayList<Users> getUsers() {
        try {
            String sql = " SELECT * FROM datausers ";
            ArrayList<Users> users = new ArrayList<>();
            Statement statement = UsersConnector.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Users user = new Users();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setAge(resultSet.getInt("age"));
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<Users>();
    }

    public void saveUser(Users user) {
        try {
            String sql = " INSERT INTO datausers VALUES (null, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = UsersConnector.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLogin());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setInt(4, user.getAge());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
