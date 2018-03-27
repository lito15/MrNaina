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
public class Matiere extends BaseModel{
   
    private String nom;
    private String code;
    private Semestre semestre;
    
    //setters
  
    public void setNom(String n){
        nom=n;
    }
    public void setCode(String c){
        code=c;
    }
    public void setSemestre(Semestre s){
        semestre=s;
    }
    
    //getters
   
    public String getNom(){
        return nom;
    }
    public String getCode(){
        return code;
    }
    public Semestre getSemestre(){
        return semestre;
    }
    
    //constructeur
    
    public Matiere(){
        
    }
    public Matiere(String i,String n,String c,Semestre s){
        setId(i);
        setNom(n);
        setCode(c);
        setSemestre(s);
    }
}
