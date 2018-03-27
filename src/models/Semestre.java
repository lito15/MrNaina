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
public class Semestre extends BaseModel{
  
    private String code;
    private String description;
    
    //setters
    
   
    public void setCode(String c){
        code=c;
    }
    public void setDescription(String d){
        description=d;
    }
    
    //getters
  
    public String getCode(){
        return code;
    }
    public String getDescription(){
        return description;
    }
    
    //constructeur
    
    public Semestre(){
        
    }
    public Semestre(String i,String c,String d){
        setId(i);
        setCode(c);
        setDescription(d);
    }
}
