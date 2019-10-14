package com.mycompany.tp1;

import java.util.ArrayList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nicolas
 */
public class MainWindowController {
    
    @FXML
    private Canvas myCanva;
    @FXML
    private ComboBox<String> comboFace;
    @FXML
    private Slider sliderHair;
    @FXML
    private ListView <String> listSkinColor;
    
    private Context context;
    int faceShape = 0; // 0 = round , 1 = square , 2 = ovale
    Color skinColor = Color.PINK;
    int hairSize = 75;

    
    public void setContext(Context context){
        this.context = context;
    }
    
    private Personne getCurrentPersonne(){
        return context.getPersonnes().identification(context.getLoginSP(), context.getPasswordSP());
    }
    
    
    public void init() {
        //Init local variables with value of the connected user
        this.faceShape = this.getCurrentPersonne().getFaceShape();
        this.skinColor = this.getCurrentPersonne().getSkinColor();
        this.hairSize = this.getCurrentPersonne().getHairSize();
        //Init UI
        this.initCombo();
        this.initSlider();
        this.initLV();
        this.drawShapes();
    }
    
    private void initLV(){
        ObservableList <String> ol = observableArrayList("Rose" , "Rouge" , "Vert");
        this.listSkinColor.setItems(ol);
        listSkinColor.getSelectionModel().selectedIndexProperty().addListener((obs , oldValue , newValue) -> {
            switch (newValue.intValue()){
                case 0 :
                    this.skinColor = Color.PINK;
                    break;
                case 1:
                    this.skinColor = Color.RED;
                    break;
                case 2:
                    this.skinColor = Color.GREEN;
                    break;
            }
            this.drawShapes();
            this.getCurrentPersonne().setSkinColor(this.skinColor);
        });
    }
    
    private void initSlider(){
        sliderHair.valueProperty().addListener((obs, oldValue, newValue) ->{ 
          this.hairSize = newValue.intValue();
           drawShapes();
           this.getCurrentPersonne().setHairSize(this.hairSize);
        });
       
    }

    private void initCombo() {
        comboFace.getItems().addAll("Rond" , "Carré" , "Ovale");
       comboFace.valueProperty().addListener((obs, oldValue, newValue) ->{ 
           if(newValue.equals("Rond")){
               this.faceShape = 0;
           }
           else if(newValue.equals("Carré")){
               this.faceShape = 1;
           }
           else if(newValue.equals("Ovale")){
               this.faceShape = 2;
           }
            drawShapes();
            this.getCurrentPersonne().setFaceShape(this.faceShape);
        });
    }
    

    private void drawShapes() {
        GraphicsContext gc = myCanva.getGraphicsContext2D();
        gc.clearRect(0, 0, myCanva.getWidth(), myCanva.getHeight());
        gc.setStroke(Color.BLACK);
        double center = myCanva.getWidth()/2d;
        this.drawFace(gc, center);
        this.drawHair(gc,center);
        gc.setFill(Color.WHITE);
        gc.fillOval(center+30 , 65 , 15 , 15);
        gc.fillOval(center+60 , 65 , 15 , 15);
        gc.setFill(Color.BLUE);
        gc.fillOval(center+40 , 73 , 5 , 5);
        gc.fillOval(center+60 , 73 , 5 , 5);
    }

    private void drawFace(GraphicsContext gc , double center) {
        gc.setFill(this.skinColor);
        switch (this.faceShape){
            case 0 : 
                gc.fillOval(center, 30, 100, 100);
                break;
            case 1 :
                gc.fillRect(center, 30, 100, 100);
                break;
            case 2 :
                gc.fillOval(center , 30 , 100 , 120);
                break;
                
        }        
    }

    private void drawHair(GraphicsContext gc, double center) {
        gc.setFill(Color.BLACK);
        gc.fillRect(center-2, 50, 10, this.hairSize);       
        gc.fillRect(center+93, 50, 10, this.hairSize);

    }
}
