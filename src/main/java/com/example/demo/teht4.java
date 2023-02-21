package com.example.demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class teht4 extends Application {

    private TextField sijoitusMaaraTextField, vuosienMaaraTextField, korkoTextField;
    private Button laskeButton;
    private Text tulosText;

    @Override
    public void start(Stage stage) {

        // Luodaan lomakeelementit
        Label sijoitusMaaraLabel = new Label("Sijoituksen määrä:");
        sijoitusMaaraTextField = new TextField();

        Label vuosienMaaraLabel = new Label("Vuosien määrä:");
        vuosienMaaraTextField = new TextField();

        Label korkoLabel = new Label("Vuotuinen korko:");
        korkoTextField = new TextField();

        laskeButton = new Button("Laske tuotto");
        laskeButton.setOnAction(e -> laskeTuotto());

        tulosText = new Text("");

        // Luodaan grid-pane asettelu ja lisätään lomakeelementit siihen
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(sijoitusMaaraLabel, 0, 0);
        gridPane.add(sijoitusMaaraTextField, 1, 0);
        gridPane.add(vuosienMaaraLabel, 0, 1);
        gridPane.add(vuosienMaaraTextField, 1, 1);
        gridPane.add(korkoLabel, 0, 2);
        gridPane.add(korkoTextField, 1, 2);
        gridPane.add(laskeButton, 1, 3);
        gridPane.add(tulosText, 0, 4, 2, 1);

        // Asetetaan asettelu näyttämölle
        Scene scene = new Scene(gridPane, 300, 200);
        stage.setScene(scene);
        stage.setTitle("Sijoituksen tuotto laskuri");
        stage.show();
    }

    private void laskeTuotto() {
        // Haetaan käyttäjän antamat tiedot tekstikentistä
        double sijoitusMaara = Double.parseDouble(sijoitusMaaraTextField.getText());
        int vuosienMaara = Integer.parseInt(vuosienMaaraTextField.getText());
        double korko = Double.parseDouble(korkoTextField.getText());

        // Lasketaan tuotto käyttäen annettuja tietoja
        double tuotto = sijoitusMaara * Math.pow(1 + korko/100, vuosienMaara);

        // Näytetään laskettu tuotto käyttäjälle
        tulosText.setText("Ennustettu tuotto: " + String.format("%.2f", tuotto));
    }

    public static void main(String[] args) {
        launch(args);
    }
}