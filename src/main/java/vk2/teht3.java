package vk2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class teht3 extends Application {

    private Text teksti;
    private Pane tekstiPaneeli;

    @Override
    public void start(Stage primaryStage) {
        // Luodaan tekstikenttä
        teksti = new Text("MUOKKAA minua");
        teksti.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        teksti.setFill(Color.BLACK);
        teksti.setTranslateY(100);
        // Luodaan radiopainikkeet väreille
        ToggleGroup varit = new ToggleGroup();
        RadioButton punainen = new RadioButton("Punainen");
        punainen.setToggleGroup(varit);
        punainen.setSelected(true);
        RadioButton sininen = new RadioButton("Sininen");
        sininen.setToggleGroup(varit);
        RadioButton musta = new RadioButton("Musta");
        musta.setToggleGroup(varit);
        RadioButton oranssi = new RadioButton("Oranssi");
        oranssi.setToggleGroup(varit);
        RadioButton vihrea = new RadioButton("Vihreä");
        vihrea.setToggleGroup(varit);

        // Luodaan tekstikentän siirtopainikkeet
        Button vasemmalle = new Button("<");
        Button oikealle = new Button(">");

        // Lisätään toiminnallisuus siirtopainikkeille
        vasemmalle.setOnAction(e -> siirraTeksti(-10));
        oikealle.setOnAction(e -> siirraTeksti(10));

        // Luodaan paneeli tekstille
        tekstiPaneeli = new Pane(teksti);

        // Asetetaan tekstipaneeli keskelle BorderPane:a
        BorderPane keskusta = new BorderPane();
        keskusta.setCenter(tekstiPaneeli);
        keskusta.setPadding(new Insets(20, 20, 20, 20));

// Luodaan HBox radiopainikkeille
        HBox varivalikko = new HBox();
        varivalikko.setAlignment(Pos.CENTER);
        varivalikko.setSpacing(10);
        varivalikko.getChildren().addAll(punainen, sininen, musta, oranssi, vihrea);

// Luodaan HBox tekstikentän siirtopainikkeille
        HBox siirtopainikkeet = new HBox();
        siirtopainikkeet.setAlignment(Pos.CENTER);
        siirtopainikkeet.setSpacing(10);
        siirtopainikkeet.getChildren().addAll(vasemmalle, oikealle);

// Luodaan VBox yläreunassa oleville komponenteille
        VBox ylareuna = new VBox();
        ylareuna.setAlignment(Pos.CENTER);
        ylareuna.setSpacing(10);
        ylareuna.getChildren().addAll(siirtopainikkeet, tekstiPaneeli);

        BorderPane root = new BorderPane();
        root.setCenter(varivalikko);
        root.setTop(ylareuna);
        root.setPadding(new Insets(20, 20, 20, 20));

        // Lisätään toiminnallisuus radiopainikkeille
        punainen.setOnAction(e -> muutaVari(Color.RED));
        sininen.setOnAction(e -> muutaVari(Color.BLUE));
        musta.setOnAction(e -> muutaVari(Color.BLACK));
        oranssi.setOnAction(e -> muutaVari(Color.ORANGE));
        vihrea.setOnAction(e -> muutaVari(Color.GREEN));

        // Luodaan Scene ja näytetään ikkuna
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Leiki tekstillä");
        primaryStage.show();
    }

    // Metodi, joka muuttaa tekstikentän värin
    private void muutaVari(Color vari) {
        teksti.setFill(vari);
    }

    // Metodi, joka siirtää tekstiä annetun määrän pikseleitä
    private void siirraTeksti(int pikselit) {
        double uusiX = teksti.getX() + pikselit;
        if (uusiX < 0) {
            uusiX = 0;
        } else if (uusiX + teksti.getBoundsInLocal().getWidth() > tekstiPaneeli.getWidth()) {
            uusiX = tekstiPaneeli.getWidth() - teksti.getBoundsInLocal().getWidth();
        }
        teksti.setX(uusiX);
    }

    public static void main(String[] args) {
        launch(args);
    }
}