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
import models.Eleve;
import models.Matiere;
import models.Note;
import models.Semestre;

/**
 *
 * @author Joselito
 */
public class NoteDAO implements InterfaceDAO {
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
        String requete="select*from note";
       rs=stat.executeQuery(requete);
      EleveDAO eleveDAO=new EleveDAO();
      MatiereDAO matiereDAO=new MatiereDAO();
        while(rs.next()){
           Eleve eleve=eleveDAO.getById(rs.getString("idEleve"));
           Matiere matiere=matiereDAO.getById(rs.getString("idMatiere"));
            resultats.add(new Note(rs.getString("id"),eleve,matiere,Integer.parseInt(rs.getString("annee"))));
            
            
        } 
        }
        catch(Exception e){
            throw new Exception("erreur de donnee getAll ->note");
        } 
        finally{
            con.close();
            stat.close();
            rs.close();
        }
        return resultats;
    }
    
    @Override
        public Note getById(String id) throws Exception{
        Note resultats=new  Note();
        try{
           ConnectBdd connectionBdd=new ConnectBdd();
        con=connectionBdd.getConnection();
        stat=con.createStatement();
        String requete="select*from note";
       rs=stat.executeQuery(requete);
      EleveDAO eleveDAO=new EleveDAO();
      MatiereDAO matiereDAO=new MatiereDAO();
        while(rs.next()){
           Eleve eleve=eleveDAO.getById(rs.getString("idEleve"));
           Matiere matiere=matiereDAO.getById(rs.getString("idMatiere"));
            resultats=new Note(rs.getString("id"),eleve,matiere,Integer.parseInt(rs.getString("annee")));
            
            
        } 
        }
        catch(Exception e){
            throw new Exception("erreur de donnee getById ->note");
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
        Note note=(Note)seme;
        String requete="INSERT INTO `note` (`idEleve`, `idMatiere`, `annee`) VALUES ('"+note.getEleve().getId()+"', '"+note.getMatiere().getId()+"', '"+note.getAnnee()+"')";
        stat.executeUpdate(requete);
         }
         catch(Exception e){
             throw new Exception("erreur insertion ->note");
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
        String requete="UPDATE `note` SET "+chang+" WHERE `note`.`id` = "+id;
        stat.executeUpdate(requete);
         }
         catch(Exception e){
             throw new Exception("erreur update ->note");
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
        String requete="delete from note where id="+id;
        stat.executeUpdate(requete);
         }
         catch(Exception e){
             throw new Exception("erreur delete ->note");
         }
         finally{
            con.close();
            stat.close();
            rs.close();
        }
     }
    
}
