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

/**
 *
 * @author Joselito
 */
public class EleveDAO implements InterfaceDAO{
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
        String requete="select*from eleve";
       rs=stat.executeQuery(requete);
        while(rs.next()){
            SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yy");
            Date daty=sdf.parse(rs.getString("daty"));
            resultats.add(new Eleve(rs.getString("id"),rs.getString("nom"),rs.getString("prenom"),daty,rs.getString("ville"),rs.getString("adresse"),Integer.parseInt(rs.getString("numero"))));
            
            
        } 
        }
        catch(Exception e){
            throw new Exception("erreur de donnee getAll ->eleve");
        } 
        finally{
            con.close();
            stat.close();
            rs.close();
        }
        return resultats;
    }
    
    @Override
     public Eleve getById(String ident) throws Exception{
        Eleve resultats=new  Eleve();
        try{
           ConnectBdd connectionBdd=new ConnectBdd();
        con=connectionBdd.getConnection();
        stat=con.createStatement();
        String requete="select*from eleve where id='"+ident+"'";
       rs=stat.executeQuery(requete);
        while(rs.next()){
            SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yy");
            Date daty=sdf.parse(rs.getString("daty"));
            resultats=new Eleve(rs.getString("id"),rs.getString("nom"),rs.getString("prenom"),daty,rs.getString("ville"),rs.getString("adresse"),Integer.parseInt(rs.getString("numero")));
            
            
        } 
        }
        catch(Exception e){
            throw new Exception("erreur de donnee getById ->eleve");
        } 
        finally{
            con.close();
            stat.close();
            rs.close();
        }
        return resultats;
    }
    @Override
     public void insert(BaseModel b) throws Exception{
         try{
        ConnectBdd connectionBdd=new ConnectBdd();
        con=connectionBdd.getConnection();
        stat=con.createStatement();
        Eleve eleve=(Eleve)b;
        String requete="INSERT INTO `eleve` (`nom`, `prenom`, `daty`, `ville`, `adresse`, `numero`) VALUES ('"+eleve.getNom()+"', '"+eleve.getPrenom()+"', '"+eleve.getDate()+"', '"+eleve.getVille()+"', '"+eleve.getAdresse()+"', '"+eleve.getNumero()+"');";
        stat.executeUpdate(requete);
         }
         catch(Exception e){
             throw new Exception("erreur insertion ->eleve");
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
        String requete="UPDATE `eleve` SET "+chang+" WHERE `eleve`.`id` = "+id;
        stat.executeUpdate(requete);
         }
         catch(Exception e){
             throw new Exception("erreur update ->eleve");
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
        String requete="delete from eleve where id="+id;
        stat.executeUpdate(requete);
         }
         catch(Exception e){
             throw new Exception("erreur delete ->eleve");
         }
         finally{
            con.close();
            stat.close();
            rs.close();
        }
     }

  


}
