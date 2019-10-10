/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tp1;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author nicolas
 */
class Personnes {
    private final ObservableList<Personne> list;
    
    public Personnes(){
        this(new ArrayList<Personne>());
    }
    
    public Personnes (ArrayList<Personne> list){
        this.list = FXCollections.observableArrayList(list);
        this.list.add(new Personne("login1", "password1"));
        this.list.add(new Personne("login2", "password2"));

    }
    
    public ObservableList<Personne> getList(){
        return this.list;
    }
    
    public Personne identification(String login , String password){
        for (Personne p : list){
            if(p.checkPassword(login, password)){
                return p;
            }
        }
        return null;
    }
}
