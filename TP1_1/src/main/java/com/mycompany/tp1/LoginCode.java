/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tp1;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

/**
 *
 * @author nicolas
 */
public class LoginCode extends BorderPane{
     Label titre;
     TextField login;
     PasswordField password;
     LoginControllerCode controller;
   
     public void setController (LoginControllerCode controller){
         this.controller = controller;
     }
     
     public LoginCode(){
        titre = new Label("Identification");
        titre.setId("Titre");
        this.setTop(titre);
        GridPane centerPane = new GridPane();
        Label label1 = new Label("login");
        label1.setPrefWidth(100);
        centerPane.add(label1,0,0);
        login = new TextField();
        centerPane.add(login,1,0);
        Label label2 = new Label("password");
        centerPane.add(label2,0,1);
        password = new PasswordField();
        centerPane.add(password,1,1);
        this.setCenter(centerPane);
        FlowPane bottomPane = new FlowPane();
        bottomPane.setHgap(10);
        Button okButton = new Button("OK");
        okButton.setDefaultButton(true);
        okButton.setOnAction(e -> {controller.submit(e);});
        Button cancelButton = new Button("cancel");
        cancelButton.setCancelButton(true);
        cancelButton.setOnAction(e -> {controller.processCancel(e);});
        ProgressBar pb = new ProgressBar();
        password.textProperty().addListener((obs , oldValue , newValue)->{
            pb.setProgress(password.getText().length()/8.0f);
        });
        bottomPane.getChildren().addAll(okButton , cancelButton , pb);

        this.setBottom(bottomPane);
        this.setPrefSize(437, 187);
        this.setPadding(new Insets(10,0,10,0));
    }
     
     
     
}
