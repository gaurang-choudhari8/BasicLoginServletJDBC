package com.basicLogin.service;
//This service class makes connection to the database and adds the new registered user into the database
import com.basicLogin.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    public boolean addUser(User user){
        //1. Loading the driver:-
        try{
        Class.forName("com.mysql.jdbc.Driver");
        //2. Getting a connection to the driver:-
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb","root","root");


        //3. Creating a Statement to execute the query
        Statement statement=con.createStatement();
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS user_list(user_id INT AUTO_INCREMENT,name varchar(100),phone varchar(100),email varchar(100), city varchar(100), PRIMARY KEY (user_id))");
        PreparedStatement prepState=con.prepareStatement("INSERT INTO user_list(name,phone,email,city) VALUES(?,?,?,?);");
        prepState.setString(1,user.getName());
        prepState.setString(2,user.getPhone());
        prepState.setString(3,user.getEmail());
        prepState.setString(4,user.getCity());
        prepState.executeUpdate();
        //statement.executeUpdate("INSERT INTO user_list(name,phone,email,city) VALUES('"+(String)user.getName()+"','"+(String)user.getPhone()+"','"+(String)user.getEmail()+"','"+(String)user.getCity()+"');");

        return true;

        }catch(ClassNotFoundException e){
            System.out.println(e.toString());

        }catch(SQLException sqlException){
            System.out.println(sqlException.toString());
        }


        return false;

    }

    public List<User> getAllUsers(){
        List<User> users=new ArrayList<User>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            //2. Getting a connection to the driver:-
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb","root","root");


            //3. Creating a Statement to execute the query
            Statement statement=con.createStatement();
            ResultSet resultSet=statement.executeQuery("Select * from user_list;");
            while(resultSet.next()){
                User user=new User();
                    boolean name=user.setName(resultSet.getString("name"));
                    boolean phone=user.setPhone(resultSet.getString("phone"));
                    boolean email=user.setEmail(resultSet.getString("email"));
                    boolean city=user.setCity(resultSet.getString("city"));

                if(name&&phone&&email&&city)
                users.add(user);
            }


        }catch(ClassNotFoundException e){
            System.out.println(e.toString());

        }catch(SQLException sqlException){
            System.out.println(sqlException.toString());
        }
        return users;
    }

}
