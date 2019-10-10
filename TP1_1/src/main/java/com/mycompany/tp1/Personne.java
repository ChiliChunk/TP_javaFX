/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tp1;

import java.time.LocalDateTime;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author nicolas
 */
class Personne {
        
    StringProperty login = new SimpleStringProperty();
    StringProperty password = new SimpleStringProperty();
    private final ObjectProperty<LocalDateTime> lastConnection = new SimpleObjectProperty();
    
    public Personne (String login , String password){
        this.login.set(login);
        this.password.set(password);
    }
    
    public final LocalDateTime getLastConnection(){
        return lastConnection.getValue();
    }
    
    public final void setLastConnection(LocalDateTime date){
        this.lastConnection.set(date);
    }
    
    public ObjectProperty<LocalDateTime> lastConnectionProperty(){
        return this.lastConnection;
    }
    
    private String getLogin(){
        return login.get();
    }
    
    private StringProperty loginProperty(){
        return login;
    }
    
    public boolean checkPassword(String login , String password){
        return login.equals(this.login.getValue()) && password.equals(this.password.getValue());
    }
}
