package com.example.Eval.controller;

import com.example.Eval.dao.Connexion;
import com.example.Eval.dao.ProfilDao;
import com.example.Eval.fonction.Fonction;
import com.example.Eval.modele.PointDeVente;
import com.example.Eval.modele.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("user")
@CrossOrigin("http://localhost:3000/")
public class UserController
{
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody User utilisateur)
    {
        Fonction fonction=new Fonction();
        User user=null;
        Map<String,Object> response=new HashMap<>();
        HttpStatus status=null;
        try
        {
            user=fonction.login(utilisateur.getEmail(),utilisateur.getMdp());
            status=HttpStatus.OK;
            response.put("user",user);
            response.put("msg","succes");
            response.put("login",true);
        }
        catch(Exception e)
        {
            status=HttpStatus.OK;
            response.put("msg",e.getMessage());
            response.put("login",false);
        }
        return new ResponseEntity<>(response, status);
    }

    @GetMapping("/pageUsers")
    public ResponseEntity<Object> pageUsers() throws ClassNotFoundException, SQLException {
        Fonction fonction=new Fonction();
        ProfilDao profilDao=new ProfilDao();

        Connexion connexion=new Connexion();
        Connection con= connexion.connect();

        User[] user=null;
        PointDeVente[] pv=null;

        Map<String,Object> response=new HashMap<>();
        HttpStatus status=null;
        try
        {
            user=profilDao.selectAllUser(con);
            pv= fonction.getAllPointDeVente();

            status=HttpStatus.OK;

            response.put("users",user);
            response.put("pvs",pv);
            response.put("msg","succes");
        }
        catch(Exception e)
        {
            status=HttpStatus.OK;
            response.put("msg",e.getMessage());
            response.put("login",false);
        }
        finally {
            con.close();
        }
        return new ResponseEntity<>(response, status);
    }

    @PutMapping("/affecter/{idUser}/{idPv}")
    public ResponseEntity<Object> reaffecter(@PathVariable int idUser,@PathVariable int idPv) throws ClassNotFoundException, SQLException {
        Fonction fonction=new Fonction();

        Map<String,Object> response=new HashMap<>();
        HttpStatus status=null;
        try
        {
            fonction.reaffecterPv(idUser,idPv);
            status=HttpStatus.OK;

            response.put("msg","succes");
        }
        catch(Exception e)
        {
            status=HttpStatus.OK;
            response.put("msg",e.getMessage());
        }
        return new ResponseEntity<>(response, status);
    }
}
