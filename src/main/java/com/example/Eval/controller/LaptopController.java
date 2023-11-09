package com.example.Eval.controller;

import com.example.Eval.dao.Connexion;
import com.example.Eval.dao.LaptopDao;
import com.example.Eval.dao.ProfilDao;
import com.example.Eval.fonction.Fonction;
import com.example.Eval.modele.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("laptop")
@CrossOrigin(origins={"http://localhost:3000/","http://localhost:3001/"})
public class LaptopController
{
    @PostMapping("/insert")
    public ResponseEntity<Object> insert(@RequestBody Laptop laptop)
    {
        Fonction fonction=new Fonction();
        Map<String,Object> response=new HashMap<>();
        HttpStatus status=null;
        try
        {
            fonction.insertLaptop(laptop);
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

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id)
    {
        Fonction fonction=new Fonction();
        Map<String,Object> response=new HashMap<>();
        HttpStatus status=null;
        try
        {
            fonction.deleteMarque(id);
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

    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestBody Marque marque)
    {
        Fonction fonction=new Fonction();
        Map<String,Object> response=new HashMap<>();
        HttpStatus status=null;
        try
        {
            fonction.updateMarque(marque);
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

    @GetMapping("/getAll")
    public ResponseEntity<Object> getAll()
    {
        Fonction fonction=new Fonction();
        Laptop[] laptop=null;
        Map<String,Object> response=new HashMap<>();
        HttpStatus status=null;
        try
        {
            laptop=fonction.getAllLaptop();
            status=HttpStatus.OK;
            response.put("msg","succes");
            response.put("laptop",laptop);
        }
        catch(Exception e)
        {
            status=HttpStatus.OK;
            response.put("msg",e.getMessage());
        }
        return new ResponseEntity<>(response, status);
    }

    @GetMapping("/magasin/getStock")
    public ResponseEntity<Object> getStock() throws ClassNotFoundException {
        LaptopDao laptopDao=new LaptopDao();
        Connexion connexion=new Connexion();
        Connection con= connexion.connect();

        Map<String,Object> response=new HashMap<>();
        HttpStatus status=null;
        StockMagasin[] stock=null;

        try
        {
            stock=laptopDao.selectStockMagasin(con);
            status=HttpStatus.OK;
            response.put("msg","succes");
            response.put("stock",stock);
        }
        catch(Exception e)
        {
            status=HttpStatus.OK;
            response.put("msg",e.getMessage());
        }
        return new ResponseEntity<>(response, status);
    }

    @GetMapping("/pv/getStock")
    public ResponseEntity<Object> getStockPv() throws ClassNotFoundException {
        LaptopDao laptopDao=new LaptopDao();
        Connexion connexion=new Connexion();
        Connection con= connexion.connect();

        Map<String,Object> response=new HashMap<>();
        HttpStatus status=null;
        StockMagasin[] stock=null;

        try
        {
            stock=laptopDao.selectStockMagasin(con);
            status=HttpStatus.OK;
            response.put("msg","succes");
            response.put("stock",stock);
        }
        catch(Exception e)
        {
            status=HttpStatus.OK;
            response.put("msg",e.getMessage());
        }
        return new ResponseEntity<>(response, status);
    }

    @PostMapping("/magasin/addStock/{idLaptop}/{quantite}")
    public ResponseEntity<Object> ajouterStock(@PathVariable int idLaptop,@PathVariable int quantite) throws ClassNotFoundException, SQLException {
        Fonction fonction=new Fonction();
        LaptopDao laptopDao=new LaptopDao();
        Connexion connexion=new Connexion();
        Connection con= connexion.connect();
        Map<String,Object> response=new HashMap<>();
        HttpStatus status=null;
        try
        {
            laptopDao.insertStockMagasin(con,idLaptop,quantite);
            status=HttpStatus.OK;
            response.put("msg","succes");
        }
        catch(Exception e)
        {
            status=HttpStatus.OK;
            response.put("msg",e.getMessage());
        }
        finally {
            con.close();
        }
        return new ResponseEntity<>(response, status);
    }

    @PostMapping("/magasin/transferer/{idLaptop}/{idPv}/{quantite}/{daty}")
    public ResponseEntity<Object> transferer(@PathVariable int idLaptop,@PathVariable int idPv,@PathVariable int quantite,@PathVariable String daty) throws ClassNotFoundException, SQLException {
        LaptopDao laptopDao=new LaptopDao();
        Connexion connexion=new Connexion();
        Connection con= connexion.connect();
        Map<String,Object> response=new HashMap<>();
        HttpStatus status=null;
        try
        {
            laptopDao.insertTransfert(con,idPv,idLaptop,quantite,daty);
            status=HttpStatus.OK;
            response.put("msg","succes");
        }
        catch(Exception e)
        {
            status=HttpStatus.OK;
            response.put("msg",e.getMessage());
        }
        finally {
            con.close();
        }
        return new ResponseEntity<>(response, status);
    }
}
