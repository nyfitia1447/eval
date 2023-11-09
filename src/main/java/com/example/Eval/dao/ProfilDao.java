package com.example.Eval.dao;

import com.example.Eval.modele.PointDeVente;
import com.example.Eval.modele.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProfilDao
{
    public ArrayList<User> selectUserByLogin(Connection con, String email, String mdp) throws SQLException
    {
        Statement req;
        ResultSet res;

        ArrayList<User> liste=new ArrayList();

        req=con.createStatement();
        String sql="select*from v_utilisateur where email='"+email+"' and mdp='"+mdp+"'";
        res=req.executeQuery(sql);

        PointDeVenteDao pvDao=new PointDeVenteDao();
        PointDeVente pv=null;

        while(res.next())
        {
            pv=pvDao.selectPVById(con,res.getInt("idpointdevente"));
            liste.add(new User(res.getInt("id") , res.getString("nom") , res.getString("email") , res.getString("mdp") , pv ));
        }
        return liste;
    }

    public User[] selectAllUser(Connection con) throws SQLException
    {
        Statement req;
        ResultSet res;

        ArrayList<User> liste=new ArrayList();

        req=con.createStatement();
        String sql="select*from v_utilisateur";
        res=req.executeQuery(sql);

        PointDeVenteDao pvDao=new PointDeVenteDao();
        PointDeVente pv=null;

        while(res.next())
        {
            pv=pvDao.selectPVById(con,res.getInt("idpointdevente"));
            liste.add(new User(res.getInt("id") , res.getString("nom") , res.getString("email") , res.getString("mdp") , pv ));
        }
        User[] user=new User[liste.size()];

        for(int i=0;i< liste.size();i++)
        {
            user[i]= liste.get(i);
        }
        return user;
    }

    public void updateUserPv(Connection con,int idUser, int idPv) throws SQLException
    {
        Statement req;
        req=con.createStatement();
        String sql="update utilisateurpointdevente set idpointdevente="+idPv+" where idutilisateur="+idUser;
        req.executeQuery(sql);
    }
}
