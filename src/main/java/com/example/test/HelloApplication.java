package com.example.test;

import com.example.test.Clase.FirMarire;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("magazine.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        ControllerMagazine controllerMagazine= new ControllerMagazine();
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}