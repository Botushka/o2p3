package com.example.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class teht3 extends Application {

    private Circle ympyra;
    private double ympyraX;
    private double ympyraY;

    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 400, 400);

        ympyra = new Circle(50, Color.BLUE);
        ympyraX = (scene.getWidth() - ympyra.getRadius()) / 2;
        ympyraY = (scene.getHeight() - ympyra.getRadius()) / 2;
        ympyra.setCenterX(ympyraX);
        ympyra.setCenterY(ympyraY);
        pane.getChildren().add(ympyra);

        Button vasen = new Button("Vasemmalle");
        vasen.setLayoutX(10);
        vasen.setLayoutY(10);
        vasen.setOnAction(e -> liikutaYmpyraa(-10, 0));
        pane.getChildren().add(vasen);

        Button oikea = new Button("Oikealle");
        oikea.setLayoutX(90);
        oikea.setLayoutY(10);
        oikea.setOnAction(e -> liikutaYmpyraa(10, 0));
        pane.getChildren().add(oikea);

        Button ylos = new Button("Ylöspäin");
        ylos.setLayoutX(150);
        ylos.setLayoutY(10);
        ylos.setOnAction(e -> liikutaYmpyraa(0, -10));
        pane.getChildren().add(ylos);

        Button alas = new Button("Alaspäin");
        alas.setLayoutX(210);
        alas.setLayoutY(10);
        alas.setOnAction(e -> liikutaYmpyraa(0, 10));
        pane.getChildren().add(alas);

        stage.setScene(scene);
        stage.show();
    }

    private void liikutaYmpyraa(double x, double y) {
        ympyraX += x;
        ympyraY += y;
        double r = ympyra.getRadius();
        if (ympyraX < r) {
            ympyraX = r;
        } else if (ympyraX > ympyra.getParent().getBoundsInLocal().getWidth() - r) {
            ympyraX = ympyra.getParent().getBoundsInLocal().getWidth() - r;
        }
        if (ympyraY < r) {
            ympyraY = r;
        } else if (ympyraY > ympyra.getParent().getBoundsInLocal().getHeight() - r) {
            ympyraY = ympyra.getParent().getBoundsInLocal().getHeight() - r;
        }
        ympyra.setCenterX(ympyraX);
        ympyra.setCenterY(ympyraY);
    }

    public static void main(String[] args) {
        launch(args);
    }

}