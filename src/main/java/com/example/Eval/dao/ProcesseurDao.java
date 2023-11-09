package com.example.Eval.dao;

import com.example.Eval.modele.Marque;
import com.example.Eval.modele.Processeur;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProcesseurDao {
    public void insert(Connection con, String marque,String modele,int generation,double frequence) throws SQLException
    {
        Statement req;
        req=con.createStatement();
        String sql="insert into processeur(marque,modele,generation,frequence) values('"+marque+"','"+modele+"',"+generation+","+frequence+")";
        req.executeQuery(sql);
    }

    public Processeur[] select(Connection con) throws SQLException
    {
        Statement req;
        ResultSet res;

        req=con.createStatement();
        String sql="select*from processeur";
        res=req.executeQuery(sql);

        ArrayList<Processeur> liste=new ArrayList();

        while(res.next())
        {
            liste.add(new Processeur(res.getInt("id"),res.getString("marque"),res.getString("modele"),res.getInt("generation"),res.getDouble("frequence")));
        }
        Processeur[] processeur=new Processeur[liste.size()];
        for(int i=0;i< liste.size();i++)
        {
            processeur[i]= liste.get(i);
        }
        return processeur;
    }

    public Processeur selectById(Connection con,int id) throws SQLException
    {
        Statement req;
        ResultSet res;

        req=con.createStatement();
        String sql="select*from processeur where id="+id;
        res=req.executeQuery(sql);

        Processeur proc=null;

        while(res.next())
        {
            proc=new Processeur(res.getInt("id"),res.getString("marque"),res.getString("modele"),res.getInt("generation"),res.getDouble("frequence"));
        }

        return proc;
    }
}
