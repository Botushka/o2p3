package vk2;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.concurrent.atomic.AtomicInteger;


public class tehtava_5 extends Application
{
    public void start(Stage alkuIkkuna) {
        Pane juuri = new VBox(40);
        Text teksti = new Text("punainen: d, sininen:f, vihreä: j, keltainen: k");
        juuri.getChildren().add(teksti);


        Pane pallot = new HBox();
        Circle punainen = new Circle(30, Color.RED);
        Circle sininen = new Circle(30, Color.BLUE);
        Circle vihrea = new Circle(30, Color.GREEN);
        Circle keltainen = new Circle(30, Color.YELLOW);
        pallot.getChildren().addAll(punainen, sininen, vihrea, keltainen);
        juuri.getChildren().add(pallot);

        Button nappi = new Button("Aloita");
        juuri.getChildren().add(nappi);

        EventHandler<ActionEvent> kasittelija = e -> {
            int luku = (int) (1 + (Math.random() * (4 - 1)));
            if (luku == 1) {
                sininen.setFill(Color.BLACK);
                vihrea.setFill(Color.BLACK);
                keltainen.setFill(Color.BLACK);
                punainen.setFill(Color.RED);
            }
            else if (luku == 2) {
                punainen.setFill(Color.BLACK);
                vihrea.setFill(Color.BLACK);
                keltainen.setFill(Color.BLACK);
                sininen.setFill(Color.BLUE);
            }
            else if (luku == 3) {
                punainen.setFill(Color.BLACK);
                sininen.setFill(Color.BLACK);
                keltainen.setFill(Color.BLACK);
                vihrea.setFill(Color.GREEN);
            }
            else if (luku == 4) {
                punainen.setFill(Color.BLACK);
                vihrea.setFill(Color.BLACK);
                sininen.setFill(Color.BLACK);
                keltainen.setFill(Color.YELLOW);
            }

        };
        AtomicInteger pisteet = new AtomicInteger();
        nappi.setOnAction(e -> {

            teksti.setText("punainen: d, sininen:f, vihreä: j, keltainen: k");
            Timeline animaatio = new Timeline(new KeyFrame(Duration.seconds(2), kasittelija));
            animaatio.setCycleCount(Timeline.INDEFINITE);
            animaatio.play();

            juuri.setOnKeyPressed(b -> {

                if (b.getCode() == KeyCode.D && punainen.getFill() == Color.RED) {
                    pisteet.addAndGet(1);
                }
                else if (b.getCode() == KeyCode.F && sininen.getFill() == Color.BLUE) {
                    pisteet.addAndGet(1);
                }
                else if (b.getCode() == KeyCode.J && vihrea.getFill() == Color.GREEN) {
                    pisteet.addAndGet(1);
                }
                else if (b.getCode() == KeyCode.K && keltainen.getFill() == Color.YELLOW) {
                    pisteet.addAndGet(1);
                }
                else {
                    teksti.setText("Sait oikein " + pisteet + " väriä.");
                    animaatio.pause();
                }
            });
        });

        Scene kehys = new Scene(juuri, 400, 250);
        alkuIkkuna.setTitle("Väripeli!");
        alkuIkkuna.setScene(kehys);
        alkuIkkuna.show();
        juuri.requestFocus();

    }
    public static void main(String [] args)
    {
        Application.launch(args);
    }
}