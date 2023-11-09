package com.example.Eval.dao;

import com.example.Eval.modele.*;

import java.sql.*;
import java.util.ArrayList;

public class LaptopDao
{
    public void insert(Connection con, int idMarque, String reference, int idProcesseur, double ram,int idDur,double ecran,double prix) throws SQLException
    {
        Statement req;
        req=con.createStatement();
        String sql="insert into laptop(idmarque,reference,idprocesseur,ram,iddur,ecran,prix) values("+idMarque+",'"+reference+"',"+idProcesseur+","+ram+","+idDur+","+ecran+","+prix+")";
        req.executeQuery(sql);
    }

    public Laptop[] select(Connection con) throws SQLException
    {
        Statement req;
        ResultSet res;

        req=con.createStatement();
        String sql="select*from v_laptop";
        res=req.executeQuery(sql);

        MarqueDao marqueDao=new MarqueDao();
        ProcesseurDao procDao=new ProcesseurDao();
        DurDao durDao=new DurDao();

        ArrayList<Laptop> liste=new ArrayList();

        while(res.next())
        {
            Marque marque=marqueDao.selectMarqueById(con,res.getInt("idmarque"));
            Processeur proc=procDao.selectById(con,res.getInt("idprocesseur"));
            DisqueDur dur=durDao.selectById(con,res.getInt("iddur"));
            liste.add(new Laptop(res.getInt("id"),marque,res.getString("reference"),proc,res.getDouble("ram"),dur,res.getDouble("ecran"),res.getDouble("prix")));
        }
        Laptop[] laptop=new Laptop[liste.size()];
        for(int i=0;i< liste.size();i++)
        {
            laptop[i]= liste.get(i);
        }
        return laptop;
    }

    public int getLastAddedId(Connection con,String modele) throws SQLException {
        Statement req;
        ResultSet res;

        req=con.createStatement();
        String sql="select*from laptop where reference='"+modele+"'";
        res=req.executeQuery(sql);
        int id=0;

        while(res.next()) {
            id=res.getInt("id");
        }
        return id;
    }

    public void initilizeStockMagasin(Connection con, int idLaptop) throws SQLException
    {
        Statement req;
        req=con.createStatement();
        String sql="insert into stockmagasin(idlaptop,quantite) values("+idLaptop+",0)";
        req.executeQuery(sql);
    }

    public void initilizeStockPv(Connection con, int idLaptop,int idPv) throws SQLException
    {
        Statement req;
        req=con.createStatement();
        String sql="insert into stockpointdevente(idlaptop,idpv,quantite) values("+idLaptop+","+idPv+",0)";
        req.executeQuery(sql);
    }

    public void insertStockMagasin(Connection con, int idLaptop,int quantite) throws SQLException
    {
        Statement req;
        req=con.createStatement();
        String sql="update stockmagasin set quantite=quantite+"+quantite+" where idlaptop="+idLaptop;
        req.executeQuery(sql);
    }

    public StockMagasin[] selectStockMagasin(Connection con) throws SQLException
    {
        Statement req;
        ResultSet res;

        req=con.createStatement();
        String sql="select*from v_stockmagasin";
        res=req.executeQuery(sql);

        MarqueDao marqueDao=new MarqueDao();
        ProcesseurDao procDao=new ProcesseurDao();
        DurDao durDao=new DurDao();

        ArrayList<StockMagasin> liste=new ArrayList();

        while(res.next())
        {
            Marque marque=marqueDao.selectMarqueById(con,res.getInt("idmarque"));
            Processeur proc=procDao.selectById(con,res.getInt("idprocesseur"));
            DisqueDur dur=durDao.selectById(con,res.getInt("iddur"));
            Laptop laptop=new Laptop(res.getInt("id"),marque,res.getString("reference"),proc,res.getDouble("ram"),dur,res.getDouble("ecran"),res.getDouble("prix"));
            liste.add(new StockMagasin(laptop, res.getInt("quantite")));
        }
        StockMagasin[] stock=new StockMagasin[liste.size()];
        for(int i=0;i< liste.size();i++)
        {
            stock[i]= liste.get(i);
        }
        return stock;
    }

    public void insertTransfert(Connection con, int idPv, int idLaptop, int quantite, String daty) throws SQLException
    {
        Statement req;
        req=con.createStatement();
        String sql="insert into transfert(idpointdevente,idlaptop,quantite,daty,etat) values("+idPv+","+idLaptop+","+quantite+",'"+daty+"',1)";
        req.executeQuery(sql);
    }

    public StockMagasin[] selectStockPv(Connection con,int idPv) throws SQLException
    {
        Statement req;
        ResultSet res;

        req=con.createStatement();
        String sql="select*from v_stockpv";
        res=req.executeQuery(sql);

        MarqueDao marqueDao=new MarqueDao();
        ProcesseurDao procDao=new ProcesseurDao();
        DurDao durDao=new DurDao();

        ArrayList<StockMagasin> liste=new ArrayList();

        while(res.next())
        {
            Marque marque=marqueDao.selectMarqueById(con,res.getInt("idmarque"));
            Processeur proc=procDao.selectById(con,res.getInt("idprocesseur"));
            DisqueDur dur=durDao.selectById(con,res.getInt("iddur"));
            Laptop laptop=new Laptop(res.getInt("id"),marque,res.getString("reference"),proc,res.getDouble("ram"),dur,res.getDouble("ecran"),res.getDouble("prix"));
            liste.add(new StockMagasin(laptop, res.getInt("quantite")));
        }
        StockMagasin[] stock=new StockMagasin[liste.size()];
        for(int i=0;i< liste.size();i++)
        {
            stock[i]= liste.get(i);
        }
        return stock;
    }

    public void insertStockPv(Connection con, int idLaptop,int quantite,int idPv) throws SQLException
    {
        Statement req;
        req=con.createStatement();
        String sql="update stockpointdevente set quantite=quantite+"+quantite+" where idlaptop="+idLaptop+" and idpv="+idPv;
        req.executeQuery(sql);
    }
}
