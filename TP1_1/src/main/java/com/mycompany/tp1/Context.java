/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tp1;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author nicolas
 */
public class Context {
    private Personnes personnes;
    private StringProperty loginSP;
    private StringProperty passwordSP;

    public Context(Personnes personnes){
        this.personnes = personnes;
        loginSP = new SimpleStringProperty();
        passwordSP = new SimpleStringProperty();
    }
    
    public Personnes getPersonnes (){
        return personnes;
    }
    
    public StringProperty loginSPProperty(){
        return loginSP;
    }
    
     public StringProperty passwordSPProperty(){
        return passwordSP;
    }
    
    
    public String getLoginSP(){
        return loginSP.getValue();
    }
    
    public String getPasswordSP(){
        return passwordSP.getValue();
    }
    
    public Personne identification (){
        return personnes.identification(loginSP.getValue(), passwordSP.getValue());
    }
}
