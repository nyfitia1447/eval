package com.example.Eval.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion
{
    String username="postgres";
    String pwd="bass.1447";
    String url="jdbc:postgresql://localhost:5432/eval";

    public Connection connect() throws ClassNotFoundException
    {
        Class.forName("org.postgresql.Driver");
        Connection conn=null;
        try
        {
            conn = DriverManager.getConnection(url,username,pwd);
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
