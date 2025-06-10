package com.example.mypaint;

import com.example.mypaint.controller.DrawingController;
import com.example.mypaint.view.DrawingView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) {
        DrawingView view = new DrawingView();
        new DrawingController(view);
        Scene scene = new Scene(view.getRoot(), 1366, 768
        );
        stage.setTitle("MyPaint - Java FX Project");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
