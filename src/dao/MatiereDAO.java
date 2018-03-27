/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.BaseModel;
import models.Matiere;
import models.Semestre;

/**
 *
 * @author Joselito
 */
public class MatiereDAO implements InterfaceDAO{
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
        String requete="select*from matiere";
       rs=stat.executeQuery(requete);
       SemestreDAO semestreDAO=new SemestreDAO();
        while(rs.next()){
            Semestre semestre=semestreDAO.getById(rs.getString("idSemestre"));
            resultats.add(new Matiere(rs.getString("id"),rs.getString("nom"),rs.getString("code"),semestre));
            
            
        } 
        }
        catch(Exception e){
            throw new Exception("erreur de donnee getAll ->matiere");
        } 
        finally{
            con.close();
            stat.close();
            rs.close();
        }
        return resultats;
    }
    
    @Override
        public Matiere getById(String id) throws Exception{
        Matiere resultats=new  Matiere();
        try{
           ConnectBdd connectionBdd=new ConnectBdd();
        con=connectionBdd.getConnection();
        stat=con.createStatement();
        String requete="select*from matiere where id="+id;
       rs=stat.executeQuery(requete);
       SemestreDAO semestreDAO=new SemestreDAO();
        while(rs.next()){
            Semestre semestre=semestreDAO.getById(rs.getString("idSemestre"));
            resultats=new Matiere(rs.getString("id"),rs.getString("nom"),rs.getString("code"),semestre);
            
            
        } 
        }
        catch(Exception e){
            throw new Exception("erreur de donnee getById ->matiere");
        } 
        finally{
            con.close();
            stat.close();
            rs.close();
        }
        return resultats;
    }
        
    @Override
          public void insert(BaseModel mati) throws Exception{
         try{
        ConnectBdd connectionBdd=new ConnectBdd();
        con=connectionBdd.getConnection();
        stat=con.createStatement();
        Matiere matiere=(Matiere)mati;
        String requete="INSERT INTO `matiere` (`nom`, `code`, `idSemestre`) VALUES ('"+matiere.getNom()+"', '"+matiere.getCode()+"', '"+matiere.getSemestre().getId()+"')";
        stat.executeUpdate(requete);
         }
         catch(Exception e){
             throw new Exception("erreur insertion ->matiere");
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
        String requete="UPDATE `matiere` SET "+chang+" WHERE `matiere`.`id` = "+id;
        stat.executeUpdate(requete);
         }
         catch(Exception e){
             throw new Exception("erreur update ->matiere");
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
        String requete="delete from matiere where id="+id;
        stat.executeUpdate(requete);
         }
         catch(Exception e){
             throw new Exception("erreur delete ->matiere");
         }
         finally{
            con.close();
            stat.close();
            rs.close();
        }
     }
}
