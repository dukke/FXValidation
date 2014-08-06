package com.pixelduke.javafx.validation.tests;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Created by pedro_000 on 7/8/2014.
 */
public class TextInputSampleApp extends Application {
    static final String RESOURCE = "TextInputSample.fxml";
    static final String STYLE_SHEET = "../style.css";

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(RESOURCE));
        root.getStylesheets().add(getClass().getResource(STYLE_SHEET).toExternalForm());
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
