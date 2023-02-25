package vk1;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

public class teht5 extends Application {
    private int timeLeft = 0;
    private Timeline timeline;
    private Label timerLabel;
    private ImageView ruokakuva;
    private Text hatchText;
    private Text ruokavalmis;
    @Override
    public void start(Stage stage) {

        GridPane gridPane = new GridPane();


        Image image = new Image("E:\\vko4\\src\\main\\java\\com\\example\\vko4\\ruokalautanen.png");
        ruokakuva = new ImageView(image);
        ruokakuva.setStyle("-fx-border-color: black; -fx-border-style: solid; -fx-border-width: 50");


        hatchText = new Text("Ruoka on kohta valmis!");
        hatchText.setFill(Color.RED);
        hatchText.setFont(new Font("Tahoma", 20));
        hatchText.setTextAlignment(TextAlignment.CENTER);

        ruokavalmis = new Text("Ruoka on  valmista!");
        ruokavalmis.setFill(Color.RED);
        ruokavalmis.setFont(new Font("Tahoma", 20));
        ruokavalmis.setVisible(false);
        hatchText.setVisible(false);


        StackPane imagePane = new StackPane();
        imagePane.setStyle("-fx-border-color: black; -fx-border-style: solid; -fx-border-width: 3");
        imagePane.getChildren().addAll(ruokakuva, hatchText, ruokavalmis);


        gridPane.add(imagePane, 0, 0, 1, 7);


        timerLabel = new Label();
        timerLabel.setPrefWidth(300);
        timerLabel.setPrefHeight(100);
        timerLabel.setAlignment(Pos.CENTER);
        timerLabel.setStyle("-fx-border-color: black; -fx-border-width: 2");
        timerLabel.setFont(new Font("Tahoma", 30));
        gridPane.add(timerLabel, 2, 0, 3, 1);

        ruokakuva.setOnMouseEntered(event -> {
            hatchText.toFront();
            hatchText.setVisible(true);
            ruokakuva.setOpacity(0);
        });

        ruokakuva.setOnMouseExited(event -> {
            hatchText.setVisible(false);
            ruokakuva.setOpacity(1);
        });

        int buttonNum = 1;
        for (int i = 2; i <= 4; i++) {
            for (int j = 1; j <= 3; j++) {
                Button numberButton = new Button(String.valueOf(buttonNum));
                numberButton.setPrefWidth(100);
                numberButton.setPrefHeight(105);
                int time = buttonNum;
                numberButton.setOnAction(event -> setTime(time));
                gridPane.add(numberButton, j + 1, i);
                buttonNum++;
            }
        }

        Button zeroButton = new Button("0");
        zeroButton.setPrefWidth(100);
        zeroButton.setPrefHeight(105);
        zeroButton.setOnAction(event -> setTime(0));
        gridPane.add(zeroButton, 2, 5);

        Button nine = new Button("9");
        nine.setPrefWidth(100);
        nine.setPrefHeight(105);
        nine.setOnAction(event -> setTime(9));
        gridPane.add(nine, 4, 4);

        Button startButton = new Button("Start");
        startButton.setPrefWidth(100);
        startButton.setPrefHeight(105);
        startButton.setOnAction(event -> startTimer());
        gridPane.add(startButton, 3, 5);

        Button stopButton = new Button("Stop");
        stopButton.setPrefWidth(100);
        stopButton.setPrefHeight(105);
        stopButton.setOnAction(event -> stopTimer());
        gridPane.add(stopButton, 4, 5);


        gridPane.setHgap(0);
        gridPane.setVgap(0);



        Scene scene = new Scene(gridPane, 1150, 510);
        stage.setScene(scene);
        stage.show();
    }

    private void setTime(int time) {

        String concatenated = String.valueOf(timeLeft) + String.valueOf(time);


        timeLeft = Integer.parseInt(concatenated);

        updateTimerLabel();
    }

    private void startTimer() {

        timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            timeLeft--;
            if (timeLeft < 0) {
                timeLeft = 0;
            }
            updateTimerLabel();


            if (timeLeft == 0) {

                ruokavalmis.setVisible(true);
                ruokakuva.setVisible(false);
                ruokakuva.setOpacity(0);
                hatchText.setVisible(false);
            } else {
                ruokavalmis.setVisible(false);
                hatchText.setVisible(false);
                ruokakuva.setOpacity(1);
                ruokakuva.setVisible(true);
            }
        }));

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }



    private void stopTimer() {
        if (timeline != null) {
            timeline.stop();
        }
    }


    private void updateTimerLabel() {
        int min = timeLeft / 60;
        int sec = timeLeft % 60;
        String minuutit = String.format("%02d", min);
        String sekunnit = String.format("%02d", sec);
        timerLabel.setText(minuutit + ":" + sekunnit);
    }

    public static void main(String[] args) {
        launch(args);
    }
}