package com.springpractice.dao;

import com.springpractice.db.DbConnection;
import com.springpractice.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReadDbDAO {
    private static Connection connection;

    public ReadDbDAO() {
        connection = DbConnection.getConnection();
    }

    private final String LOGIN_QUERY = "SELECT * FROM user WHERE email=? AND password=?";
    private final String SELECT_ALL_QUERY = "SELECT * FROM user";

    private final String INSERT_QUERY = "INSERT INTO user (fName,lName,email,password,gender,country,languages) VALUES (?,?,?,?,?,?,?)";

    public User loginUser(String email, String pass){
        User user = null;
        try {
            PreparedStatement ps = connection.prepareStatement(LOGIN_QUERY);
            ps.setString(1,email);
            ps.setString(2,pass);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("fName")+" "+rs.getString("lName"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setGender(rs.getString("gender"));
                user.setUserCountry(rs.getString("country"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    public List<User> allData(){
        List<User> allUsers = new ArrayList<>();
        User user = null;
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL_QUERY);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("fName")+" "+rs.getString("lName"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setGender(rs.getString("gender"));
                user.setLanguages(rs.getString("languages").split(","));
                user.setUserCountry(rs.getString("country"));
                allUsers.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return allUsers;
    }

    public void addUser(User user, String languages){
        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_QUERY);
            ps.setString(1,user.getName().split(" ")[0]);
            ps.setString(2,user.getName().split(" ")[1]);
            ps.setString(3,user.getEmail());
            ps.setString(3,user.getPassword());
            ps.setString(4,user.getGender());
            ps.setString(5,user.getUserCountry());
            ps.setString(6,languages);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
