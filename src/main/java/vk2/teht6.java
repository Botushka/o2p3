package vk2;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class teht6 extends Application {

    private Label label;
    private Slider colorSlider;
    private Slider positionSlider;

    @Override
    public void start(Stage primaryStage) {

        // Create a label "Edit me!" at the top of the window
        label = new Label("Muokkaa minua!");
        label.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        label.setTextAlignment(TextAlignment.CENTER);
        label.setTranslateY(190);

        // Create a slider for changing the color of the text
        colorSlider = new Slider(0, 1, 0);
        colorSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            label.setTextFill(Color.color(newValue.doubleValue(), 0, 1 - newValue.doubleValue()));
        });

        // Create a slider for changing the vertical position of the text
        positionSlider = new Slider(0, 300, 150);
        positionSlider.setOrientation(Orientation.VERTICAL);
        positionSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            double height = label.getBoundsInLocal().getHeight() - 75;
            double newY = positionSlider.getMax() - newValue.doubleValue();
            double newTranslateY = newY - height;
            label.setTranslateY(newTranslateY);
        });

        // Create a BorderPane that divides the window into three sections
        BorderPane root = new BorderPane();
        root.setTop(label);
        root.setBottom(colorSlider);
        root.setRight(positionSlider);

        // Center the label horizontally in the top section of the BorderPane
        BorderPane.setAlignment(label, Pos.CENTER);

        // Show the window
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Väriä elämään!");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}