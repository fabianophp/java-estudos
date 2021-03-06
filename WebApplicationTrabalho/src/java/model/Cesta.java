/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author fabiano
 */
@Entity
public class Cesta implements Serializable{
    
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
    private Integer id;
    private String login;
    private String item;
    
    
    public Integer getId(){
        return id;
    }
    public void setId(Integer id){
        this.id = id;
    }
    
    public String getLogin(){
        return login;
    }
    public void setLogin(String login){
        this.login = login;
    }
    
    public String getItem(){
        return item;
    }
    public void setItem(String item){
        this.item = item;
    }
}
