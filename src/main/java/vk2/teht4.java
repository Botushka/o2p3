package vk2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class teht4 extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Luodaan valintalista
        ListView<String> lista = new ListView<>();
        lista.getItems().addAll("Kalle", "Ville", "Sakari", "Heikki", "Armas", "Toivo", "Kalevi");
        lista.getSelectionModel().setSelectionMode(javafx.scene.control.SelectionMode.MULTIPLE);

        // Luodaan teksti, joka näyttää valitut vaihtoehdot
        Label valitut = new Label("Ei valittuja vaihtoehtoja");
        valitut.setAlignment(Pos.CENTER);

        // Lisätään toiminnallisuus valintalistaan
        lista.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            String valitutVaihtoehdot = "Valitut vaihtoehdot: " + String.join(", ", lista.getSelectionModel().getSelectedItems());
            valitut.setText(valitutVaihtoehdot);
        });

        // Luodaan paneelit komponenteille
        VBox listaPaneeli = new VBox(lista);
        VBox valitutPaneeli = new VBox(valitut);
        BorderPane root = new BorderPane();
        root.setLeft(listaPaneeli);
        root.setBottom(valitutPaneeli);
        root.setPadding(new Insets(20, 20, 20, 20));

        // Luodaan Scene ja näytetään ikkuna
        Scene scene = new Scene(root, 300, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Valintalistan valinnat");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


