package vk2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class teht1 extends Application {

    private Line hourHand;
    private Line minuteHand;
    private Line secondHand;

    @Override
    public void start(Stage primaryStage) {

        Pane pane = new Pane();
        Pane text = new Pane();

        Circle face = new Circle(100, 100, 95);
        face.setFill(Color.WHITE);
        face.setStroke(Color.BLACK);

        hourHand = new Line(100, 100, 100, 50);
        hourHand.setStrokeWidth(5);
        hourHand.setStroke(Color.BLUE);
        minuteHand = new Line(100, 100, 150, 100);
        minuteHand.setStrokeWidth(3);
        minuteHand.setStroke(Color.RED);
        secondHand = new Line(100, 100, 150, 150);
        secondHand.setStrokeWidth(1);
        secondHand.setStroke(Color.GREEN);

        for (int i = 0; i < 12; i++) {
            Line hourMarker = new Line(100, 5, 100, 15);
            hourMarker.setStrokeWidth(2);
            hourMarker.setRotate(i * 30);
            text.getChildren().add(hourMarker);
        }

        Text twelve = new Text(95, 25, "12");
        twelve.setFont(new Font(16));
        Text three = new Text(175, 105, "3");
        three.setFont(new Font(16));
        Text six = new Text(98, 185, "6");
        six.setFont(new Font(16));
        Text nine = new Text(15, 105, "9");
        nine.setFont(new Font(16));

        Text hourLabel = new Text(40, 20, "Hour:");
        hourLabel.setFont(new Font(12));
        TextField hourField = new TextField("12");
        hourField.setLayoutX(80);
        hourField.setLayoutY(5);
        hourField.setPrefWidth(30);
        hourField.setOnAction(e -> setHourHand(hourField.getText()));
        Text minuteLabel = new Text(110, 20, "Minute:");
        minuteLabel.setFont(new Font(12));
        TextField minuteField = new TextField("00");
        minuteField.setLayoutX(160);
        minuteField.setLayoutY(5);
        minuteField.setPrefWidth(30);
        minuteField.setOnAction(e -> setMinuteHand(minuteField.getText()));
        Text secondLabel = new Text(190, 20, "Second:");
        secondLabel.setFont(new Font(12));
        TextField secondField = new TextField("00");
        secondField.setLayoutX(240);
        secondField.setLayoutY(5);
        secondField.setPrefWidth(30);
        secondField.setOnAction(e -> setSecondHand(secondField.getText()));
        text.getChildren().addAll(hourHand,minuteHand,secondHand,hourLabel,hourField, minuteLabel, minuteField, secondLabel, secondField);

        pane.getChildren().addAll(face, hourHand, minuteHand, secondHand, twelve,three,six
                ,nine);
        pane.setTranslateY(50);
        pane.setTranslateX(50);
        StackPane tulos = new StackPane();
        tulos.getChildren().addAll(text, pane);
        Scene scene = new Scene(tulos, 300, 400);


        primaryStage.setScene(scene);
        primaryStage.setTitle("Kellon ajan asettaminen");
        primaryStage.show();
    }

    private void setHourHand(String hour) {
        int h = Integer.parseInt(hour);
        if (h < 1 || h > 12) {
            return;
        }
        double angle = (h % 12) * 30;
        hourHand.setEndX(100 + 40 * Math.sin(Math.toRadians(angle)));
        hourHand.setEndY(100 - 40 * Math.cos(Math.toRadians(angle)));
    }

    private void setMinuteHand(String minute) {
        int m = Integer.parseInt(minute);
        if (m < 0 || m > 59) {
            return;
        }
        double angle = m * 6;
        minuteHand.setEndX(100 + 60 * Math.sin(Math.toRadians(angle)));
        minuteHand.setEndY(100 - 60 * Math.cos(Math.toRadians(angle)));
    }

    private void setSecondHand(String second) {
        int s = Integer.parseInt(second);
        if (s < 0 || s > 59) {
            return;
        }
        double angle = s * 6;
        secondHand.setEndX(100 + 60 * Math.sin(Math.toRadians(angle)));
        secondHand.setEndY(100 - 60 * Math.cos(Math.toRadians(angle)));
    }
}