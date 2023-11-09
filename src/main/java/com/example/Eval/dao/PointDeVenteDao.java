package com.example.Eval.dao;

import com.example.Eval.modele.Lieu;
import com.example.Eval.modele.PointDeVente;
import com.example.Eval.modele.Processeur;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PointDeVenteDao
{
    public void insertPointDeVente(Connection con, String nom,String idLieu) throws SQLException
    {
        Statement req;
        req=con.createStatement();
        String sql="insert into pointDeVente(nom,idlieu) values('"+nom+"',"+idLieu+")";
        req.executeQuery(sql);
    }

    public PointDeVente selectPVById(Connection con, int id) throws SQLException
    {
        Statement req;
        ResultSet res;

        req=con.createStatement();
        String sql="select*from v_pointdevente where id="+id;
        res=req.executeQuery(sql);

        PointDeVente pointDeVente=null;

        while(res.next())
        {
            pointDeVente=new PointDeVente(res.getInt("id"),res.getString("nom"),res.getString("nomlieu"));
        }
        return pointDeVente;
    }

    public PointDeVente[] select(Connection con) throws SQLException
    {
        Statement req;
        ResultSet res;

        req=con.createStatement();
        String sql="select*from v_pointdevente";
        res=req.executeQuery(sql);

        ArrayList<PointDeVente> liste=new ArrayList();

        while(res.next())
        {
            liste.add(new PointDeVente(res.getInt("id"),res.getString("nom"),res.getString("nomlieu")));
        }
        PointDeVente[] pointDeVente=new PointDeVente[liste.size()];
        for(int i=0;i< liste.size();i++)
        {
            pointDeVente[i]= liste.get(i);
        }
        return pointDeVente;
    }

    public void updatePointDeVente(Connection con,int id, String nom,int idLieu) throws SQLException
    {
        Statement req;
        req=con.createStatement();
        String sql="update pointdevente set nom='"+nom+"',idlieu="+idLieu+" where id="+id;
        req.executeQuery(sql);
    }

    public void deletePointDeVente(Connection con, int id) throws SQLException
    {
        Statement req;
        req=con.createStatement();
        String sql="delete from pointdevente where id="+id;
        req.executeQuery(sql);
    }

    public Lieu[] listeLieu(Connection con) throws SQLException {
        Statement req;
        ResultSet res;

        req=con.createStatement();
        String sql="select*from lieu";
        res=req.executeQuery(sql);

        ArrayList<Lieu> liste=new ArrayList();

        while(res.next())
        {
            liste.add(new Lieu(res.getInt("id"),res.getString("nom")));
        }
        Lieu[] lieu=new Lieu[liste.size()];
        for(int i=0;i<liste.size();i++)
        {
            lieu[i]=liste.get(i);
        }
        return lieu;
    }
}
