package vk2;

import java.util.Random;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SalasanaGeneraattori extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Luo Slider-elementti ja asettaa sen arvon välille 8 ja 32
        Slider slider = new Slider(8, 100, 8);

        // Luo TextField-elementin ja asettaa sen pituudeksi sliderin nykyisen arvon
        TextField salasanaKentta = new TextField();
        salasanaKentta.setPrefColumnCount(slider.valueProperty().intValue());

        // Luo Label-elementin, joka näyttää sliderin nykyisen arvon
        Label pituusLabel = new Label("Salasanan pituus: " + slider.valueProperty().intValue());

        // Lisää Slider-elementille listener, joka päivittää TextFieldin pituuden sliderin arvon mukaiseksi
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            salasanaKentta.setPrefColumnCount(newValue.intValue());
            pituusLabel.setText("Salasanan pituus: " + newValue.intValue());

            // Generoi uuden satunnaisen salasanan ja päivittää sen TextFieldiin
            StringBuilder salasana = new StringBuilder();
            int pituus = newValue.intValue();
            Random random = new Random();
            for (int i = 0; i < pituus; i++) {
                char merkki = (char) (random.nextInt(94) + 33);
                salasana.append(merkki);
            }
            salasanaKentta.setText(salasana.toString());
        });

        // Luo VBox-elementin, joka sisältää Sliderin, TextFieldin ja Labelin
        VBox vbox = new VBox(slider, pituusLabel, salasanaKentta);

        // Luo uuden Scene-elementin ja asettaa sen primaryStage:n
        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Salasana Generaattori");

        // Näyttää primaryStage:n
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}