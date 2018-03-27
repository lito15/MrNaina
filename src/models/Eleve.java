/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;

/**
 *
 * @author Joselito
 */
public class Eleve extends BaseModel{
    
    //attribut

    private String nom;
    private String prenom;
    private Date daty;
    private String ville;
    private String adresse;
    private int numero;
    
    //settters
  
    public void setNom(String n){
        nom=n;
    }
    public void setPrenom(String p){
        prenom=p;
    }
    public void setDate(Date d){
        daty=d;
    }
    public void setVille(String v){
        ville=v;
    }
    public void setAdresse(String a){
        adresse=a;
    }
    public void setNumero(int n) throws Exception{
        if(n<0){
            numero=n;
        }
        else{
            throw new Exception("numero invalide");
        }
    }
    //getters
    

    public String getNom(){
        return nom;
    }
    public String getPrenom(){
        return prenom;
    }
    public Date getDate(){
        return daty;
    }
    public String getVille(){
        return ville;
    }
    public String getAdresse(){
        return adresse;
    }
    public int getNumero(){
        return numero;
    }
    public Eleve(){
        
    }
    public Eleve(String i,String n,String p,Date d,String v,String a,int nu) throws Exception{
        this.setId(i);
        this.setNom(n);
        this.setPrenom(p);
        this.setDate(d);
        this.setVille(v);
        this.setAdresse(a);
        this.setNumero(nu);
    }
    
}
