/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Joselito
 */
public class Note extends BaseModel {
    
    private Eleve eleve;
    private Matiere matiere;
    private int annee;
    
    //setters
   
    public void setEleve(Eleve e){
        eleve=e;
    }
    public void setMatiere(Matiere m){
        matiere=m;
    }
    public void setAnnee(int a) throws Exception{
        if(a<0){
            annee=a;
        }
        else{
            throw new Exception("annee invalide");
        }
    }
    
    //getters
   
    public Eleve getEleve(){
        return eleve;
    }
    public Matiere getMatiere(){
        return matiere;
    }
    public int getAnnee(){
        return annee;
    }
    
    //constructeur
 public Note(){
     
 }   
 public Note(String i,Eleve e,Matiere m,int a) throws Exception{
     setId(i);
     setEleve(e);
     setMatiere(m);
     setAnnee(a);
 }
}
