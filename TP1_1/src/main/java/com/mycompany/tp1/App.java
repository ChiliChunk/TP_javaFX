package com.mycompany.tp1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        
        BorderPane rootLayout = (BorderPane) new LoginCode();
        
        LoginControllerCode controller = new LoginControllerCode();
        Context context = new Context(new Personnes());
        
        controller.setUi((LoginCode)rootLayout);
        //controller.initialize();
        controller.setContext(context);
        scene = new Scene(rootLayout , 332 , 194);
        stage.setScene(scene);
        scene.getStylesheets().add(LoginControllerCode.class.getResource("style.css").toExternalForm());
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}