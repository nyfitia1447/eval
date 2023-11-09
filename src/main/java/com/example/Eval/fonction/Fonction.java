package com.example.Eval.fonction;

import com.example.Eval.dao.*;
import com.example.Eval.modele.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class Fonction
{
    public User login(String email, String mdp) throws ClassNotFoundException, SQLException, Exception
    {
        ProfilDao profilDao=new ProfilDao();
        Connexion connexion=new Connexion();
        Connection con=connexion.connect();

        ArrayList<User> liste=profilDao.selectUserByLogin(con, email, mdp);
        User user=null;

        if(liste.isEmpty())
        {
            Exception e=new Exception("Identifiant invalide");
            throw e;
        }
        else
        {
            user=liste.get(0);
        }
        con.close();
        return user;
    }

    public void insertMarque(Marque marque) throws ClassNotFoundException {
        MarqueDao marqueDao=new MarqueDao();
        Connexion connexion=new Connexion();
        Connection con= connexion.connect();

        try{
            marqueDao.insertMarque(con,marque.getNom());
        }
        catch(Exception e){}
    }

    public void updateMarque(Marque marque) throws ClassNotFoundException {
        MarqueDao marqueDao=new MarqueDao();
        Connexion connexion=new Connexion();
        Connection con= connexion.connect();

        try{
            marqueDao.updateMarque(con,marque.getId(),marque.getNom());
        }
        catch(Exception e){}
    }

    public void deleteMarque(int id) throws ClassNotFoundException {
        MarqueDao marqueDao=new MarqueDao();
        Connexion connexion=new Connexion();
        Connection con= connexion.connect();

        try{
            marqueDao.deleteMarque(con,id);
        }
        catch(Exception e){}
    }

    public Marque[] getAllMarque() throws ClassNotFoundException {
        MarqueDao marqueDao=new MarqueDao();
        Connexion connexion=new Connexion();
        Connection con= connexion.connect();
        Marque[] marque=null;

        try {
            marque=marqueDao.selectMarque(con);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return marque;
    }

    public void insertProcesseur(Processeur proc) throws ClassNotFoundException {
        ProcesseurDao procDao=new ProcesseurDao();
        Connexion connexion=new Connexion();
        Connection con= connexion.connect();

        try{
            procDao.insert(con,proc.getMarque(),proc.getModele(),proc.getGeneration(),proc.getFrequence());
        }
        catch(Exception e){}
    }

    public Processeur[] getAllProc() throws ClassNotFoundException {
        ProcesseurDao procDao=new ProcesseurDao();
        Connexion connexion=new Connexion();
        Connection con= connexion.connect();
        Processeur[] processeur=null;

        try {
            processeur=procDao.select(con);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return processeur;
    }

    public DisqueDur[] getAllDur() throws ClassNotFoundException {
        DurDao durDao=new DurDao();
        Connexion connexion=new Connexion();
        Connection con= connexion.connect();
        DisqueDur[] dur=null;

        try {
            dur=durDao.select(con);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return dur;
    }

    public void insertLaptop(Laptop laptop) throws ClassNotFoundException {
        LaptopDao laptopDao=new LaptopDao();
        Connexion connexion=new Connexion();
        Connection con= connexion.connect();
        int id=0;

        try{
            laptopDao.insert(con,laptop.getMarque().getId(),laptop.getReferences(),laptop.getProcesseur().getId(),laptop.getRam(),laptop.getDisqueDur().getId(),laptop.getEcran(),laptop.getPrix());
        }
        catch(Exception e){}

        try{
            id=laptopDao.getLastAddedId(con,laptop.getReferences());
        }
        catch(Exception e){}

        try{
            laptopDao.initilizeStockMagasin(con,id);
        }
        catch(Exception e){}

        PointDeVente[] pvs=this.getAllPointDeVente();
        for(int i=0;i< pvs.length;i++) {
            System.out.println("eto");
            try {
                laptopDao.initilizeStockPv(con, id, pvs[i].getId());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    public Laptop[] getAllLaptop() throws ClassNotFoundException {
        LaptopDao laptopDao=new LaptopDao();
        Connexion connexion=new Connexion();
        Connection con= connexion.connect();
        Laptop[] laptop=null;

        try {
            laptop=laptopDao.select(con);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return laptop;
    }

    public PointDeVente[] getAllPointDeVente() throws ClassNotFoundException {
        PointDeVenteDao pvDao=new PointDeVenteDao();
        Connexion connexion=new Connexion();
        Connection con= connexion.connect();
        PointDeVente[] pv=null;

        try {
            pv=pvDao.select(con);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return pv;
    }

    public void deletePointDeVente(int id) throws ClassNotFoundException {
        PointDeVenteDao pvDao=new PointDeVenteDao();
        Connexion connexion=new Connexion();
        Connection con= connexion.connect();

        try{
            pvDao.deletePointDeVente(con,id);
        }
        catch(Exception e){}
    }

    public void insertPointDeVente(PointDeVente pv) throws ClassNotFoundException {
        PointDeVenteDao pvDao=new PointDeVenteDao();
        Connexion connexion=new Connexion();
        Connection con= connexion.connect();

        try{
            pvDao.insertPointDeVente(con,pv.getNom(),pv.getLieu());
        }
        catch(Exception e){}
    }

    public Lieu[] getAllLieu() throws ClassNotFoundException {
        PointDeVenteDao pvDao=new PointDeVenteDao();
        Connexion connexion=new Connexion();
        Connection con= connexion.connect();
        Lieu[] lieu=null;

        try {
            lieu=pvDao.listeLieu(con);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return lieu;
    }

    public void reaffecterPv(int idUser,int idPv) throws ClassNotFoundException {
        ProfilDao profilDao=new ProfilDao();
        Connexion connexion=new Connexion();
        Connection con= connexion.connect();
        try {
            profilDao.updateUserPv(con,idUser,idPv);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
