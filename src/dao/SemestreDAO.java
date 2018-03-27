/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import models.BaseModel;
import models.Eleve;
import models.Semestre;

/**
 *
 * @author Joselito
 */
public class SemestreDAO implements InterfaceDAO{
     Statement stat=null;
     ResultSet rs=null;
      Connection con=null;
     @Override
    public List<BaseModel> getAll() throws Exception{
        List<BaseModel> resultats=new  ArrayList<BaseModel>();
        try{
           ConnectBdd connectionBdd=new ConnectBdd();
        con=connectionBdd.getConnection();
        stat=con.createStatement();
        String requete="select*from semestre";
       rs=stat.executeQuery(requete);
        while(rs.next()){
            resultats.add(new Semestre(rs.getString("id"),rs.getString("code"),rs.getString("description")));
            
            
        } 
        }
        catch(Exception e){
            throw new Exception("erreur de donnee getAll ->semestre");
        } 
        finally{
            con.close();
            stat.close();
            rs.close();
        }
        return resultats;
    }
    
     @Override
      public Semestre getById(String id) throws Exception{
        Semestre resultats=new  Semestre();
        try{
           ConnectBdd connectionBdd=new ConnectBdd();
        con=connectionBdd.getConnection();
        stat=con.createStatement();
        String requete="select*from semestre where id="+id;
       rs=stat.executeQuery(requete);
        while(rs.next()){
            resultats= new Semestre(rs.getString("id"),rs.getString("code"),rs.getString("description"));
            
            
        } 
        }
        catch(Exception e){
            throw new Exception("erreur de donnee getById ->semestre");
        } 
        finally{
            con.close();
            stat.close();
            rs.close();
        }
        return resultats;
    }
     @Override
       public void insert(BaseModel seme) throws Exception{
         try{
        ConnectBdd connectionBdd=new ConnectBdd();
        con=connectionBdd.getConnection();
        stat=con.createStatement();
        Semestre semestre=(Semestre)seme;
        String requete="INSERT INTO `semestre` (`code`, `description`) VALUES ('"+semestre.getCode()+"', '"+semestre.getDescription()+"')";
        stat.executeUpdate(requete);
         }
         catch(Exception e){
             throw new Exception("erreur insertion ->semestre");
         }
         finally{
            con.close();
            stat.close();
            rs.close();
        }
     }
     @Override
     public void update(String id,String chang) throws Exception{
           try{
        ConnectBdd connectionBdd=new ConnectBdd();
        con=connectionBdd.getConnection();
        stat=con.createStatement();
        String requete="UPDATE `semestre` SET "+chang+" WHERE `semestre`.`id` = "+id;
        stat.executeUpdate(requete);
         }
         catch(Exception e){
             throw new Exception("erreur update ->semestre");
         }
         finally{
            con.close();
            stat.close();
            rs.close();
        }
     }
     @Override
     public void delete(String id) throws Exception{
            try{
        ConnectBdd connectionBdd=new ConnectBdd();
        con=connectionBdd.getConnection();
        stat=con.createStatement();
        String requete="delete from semestre where id="+id;
        stat.executeUpdate(requete);
         }
         catch(Exception e){
             throw new Exception("erreur delete ->semestre");
         }
         finally{
            con.close();
            stat.close();
            rs.close();
        }
     }

}
