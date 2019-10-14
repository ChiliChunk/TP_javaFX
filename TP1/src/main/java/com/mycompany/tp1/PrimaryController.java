package com.mycompany.tp1;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class PrimaryController{

    @FXML
    private PasswordField password;
    @FXML
    private TextField login;
    
    private Context context;
    
    @FXML
    private void submit() throws IOException {
        System.out.println("Login : "+context.getLoginSP()+"\nPassword : "+context.getPasswordSP());
        Personne personneConnectee =  this.context.identification();
        
        if (personneConnectee != null){
            try{
                Stage stage = (Stage)this.login.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(App.class.getResource("MainWindow.fxml"));
                AnchorPane rootLayout = (AnchorPane) loader.load(); 
                
                MainWindowController controller = loader.getController();
                controller.setContext(context);
                controller.init();
                Scene scene = new Scene(rootLayout, 600, 400);
                stage.setScene(scene);
                stage.centerOnScreen();
            }
            catch (IOException e){
                System.err.println(e.getMessage());
            }
            catch (Exception e){
                System.err.println(e.getMessage());
            }
        }
    }
    
    public void setContext(Context context){
        this.context = context;
        context.loginSPProperty().bind(login.textProperty());
        context.passwordSPProperty().bind(password.textProperty());

    }

}
