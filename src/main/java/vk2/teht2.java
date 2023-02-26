package vk2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class teht2 extends Application {

    private Circle redLight;
    private Circle yellowLight;
    private Circle greenLight;

    @Override
    public void start(Stage primaryStage) {

        redLight = new Circle(50, Color.WHITE);
        yellowLight = new Circle(50, Color.WHITE);
        greenLight = new Circle(50, Color.WHITE);

        redLight.setStroke(Color.BLACK);
        redLight.setStrokeWidth(2);
        yellowLight.setStroke(Color.BLACK);
        yellowLight.setStrokeWidth(2);
        greenLight.setStroke(Color.BLACK);
        greenLight.setStrokeWidth(2);

        redLight.setTranslateY(-100);
        yellowLight.setTranslateY(0);
        greenLight.setTranslateY(100);


        Rectangle outlineBox = new Rectangle(150, 300);
        outlineBox.setFill(Color.TRANSPARENT);
        outlineBox.setStroke(Color.BLACK);
        outlineBox.setStrokeWidth(2);

        Rectangle legBox = new Rectangle(50, 200);
        legBox.setStroke(Color.BLACK);
        legBox.setStrokeWidth(2);
        legBox.setFill(Color.WHITE);
        legBox.setTranslateY(250);

        StackPane circleStackPane = new StackPane();
        circleStackPane.getChildren().addAll(outlineBox, redLight, yellowLight, greenLight, legBox);

        StackPane.setAlignment(circleStackPane, Pos.CENTER_LEFT);
        StackPane.setMargin(circleStackPane, new Insets(50, 0, 0, 0));

        RadioButton redButton = new RadioButton("Red");
        RadioButton yellowButton = new RadioButton("Yellow");
        RadioButton greenButton = new RadioButton("Green");

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER_LEFT);
        vBox.getChildren().addAll(circleStackPane, redButton, yellowButton, greenButton);

        ToggleGroup toggleGroup = new ToggleGroup();
        redButton.setToggleGroup(toggleGroup);
        yellowButton.setToggleGroup(toggleGroup);
        greenButton.setToggleGroup(toggleGroup);

        redButton.setSelected(true);
        vBox.setPadding(new Insets(20));


        Scene scene = new Scene(vBox, 400, 700);

        redButton.setOnAction(event -> setLightsColor(Color.RED));
        yellowButton.setOnAction(event -> setLightsColor(Color.YELLOW));
        greenButton.setOnAction(event -> setLightsColor(Color.GREEN));

        primaryStage.setTitle("Aseta liikennevalo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setLightsColor(Color color) {
        redLight.setFill(color == Color.RED ? color : Color.WHITE);
        yellowLight.setFill(color == Color.YELLOW ? color : Color.WHITE);
        greenLight.setFill(color == Color.GREEN ? color : Color.WHITE);
    }

    public static void main(String[] args) {
        launch(args);
    }
}