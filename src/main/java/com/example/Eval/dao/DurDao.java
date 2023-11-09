package com.example.Eval.dao;

import com.example.Eval.modele.DisqueDur;
import com.example.Eval.modele.Processeur;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DurDao {
    public DisqueDur[] select(Connection con) throws SQLException
    {
        Statement req;
        ResultSet res;

        req=con.createStatement();
        String sql="select*from v_dur";
        res=req.executeQuery(sql);

        ArrayList<DisqueDur> liste=new ArrayList();

        while(res.next())
        {
            liste.add(new DisqueDur(res.getInt("id"),res.getString("typedur"),res.getDouble("capacite")));
        }
        DisqueDur[] dur=new DisqueDur[liste.size()];
        for(int i=0;i< liste.size();i++)
        {
            dur[i]= liste.get(i);
        }
        return dur;
    }

    public DisqueDur selectById(Connection con,int id) throws SQLException
    {
        Statement req;
        ResultSet res;

        req=con.createStatement();
        String sql="select*from v_dur where id="+id;
        res=req.executeQuery(sql);

        DisqueDur dur=null;

        while(res.next())
        {
            dur=new DisqueDur(res.getInt("id"),res.getString("typedur"),res.getDouble("capacite"));
        }

        return dur;
    }
}
