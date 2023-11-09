package com.example.Eval.dao;

import com.example.Eval.modele.Marque;
import com.example.Eval.modele.PointDeVente;
import com.example.Eval.modele.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MarqueDao
{
    public void insertMarque(Connection con, String nom) throws SQLException
    {
        Statement req;
        req=con.createStatement();
        String sql="insert into marque(nom) values('"+nom+"')";
        req.executeQuery(sql);
    }

    public void updateMarque(Connection con,int id, String nom) throws SQLException
    {
        Statement req;
        req=con.createStatement();
        String sql="update marque set nom='"+nom+"' where id="+id;
        req.executeQuery(sql);
    }

    public void deleteMarque(Connection con, int id) throws SQLException
    {
        Statement req;
        req=con.createStatement();
        String sql="delete from marque where id="+id;
        req.executeQuery(sql);
    }

    public Marque[] selectMarque(Connection con) throws SQLException
    {
        Statement req;
        ResultSet res;

        req=con.createStatement();
        String sql="select*from marque";
        res=req.executeQuery(sql);

        ArrayList<Marque> liste=new ArrayList();

        while(res.next())
        {
            liste.add(new Marque(res.getInt("id"),res.getString("nom")));
        }
        Marque[] marque=new Marque[liste.size()];
        for(int i=0;i< liste.size();i++)
        {
            marque[i]= liste.get(i);
        }
        return marque;
    }

    public Marque selectMarqueById(Connection con, int id) throws SQLException
    {
        Statement req;
        ResultSet res;

        req=con.createStatement();
        String sql="select*from marque where id="+id;
        res=req.executeQuery(sql);
        Marque marque=null;

        while(res.next())
        {
            marque=new Marque(res.getInt("id"),res.getString("nom"));
        }
        return marque;
    }
}
