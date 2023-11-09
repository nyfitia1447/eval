package com.example.Eval.controller;

import com.example.Eval.dao.Connexion;
import com.example.Eval.dao.ProfilDao;
import com.example.Eval.fonction.Fonction;
import com.example.Eval.modele.Marque;
import com.example.Eval.modele.Processeur;
import com.example.Eval.modele.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("proc")
@CrossOrigin("http://localhost:3000/")
public class ProcesseurController
{
    @PostMapping("/insert")
    public ResponseEntity<Object> insert(@RequestBody Processeur proc)
    {
        Fonction fonction=new Fonction();
        Map<String,Object> response=new HashMap<>();
        HttpStatus status=null;
        try
        {
            fonction.insertProcesseur(proc);
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
        Processeur[] proc=null;
        Map<String,Object> response=new HashMap<>();
        HttpStatus status=null;
        try
        {
            proc=fonction.getAllProc();
            status=HttpStatus.OK;
            response.put("msg","succes");
            response.put("proc",proc);
        }
        catch(Exception e)
        {
            status=HttpStatus.OK;
            response.put("msg",e.getMessage());
        }
        return new ResponseEntity<>(response, status);
    }
}
