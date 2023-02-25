package vk1;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class teht2 extends Application {

    private Text teksti;
    private boolean vaihto = false;

    @Override
    public void start(Stage stage) {
        teksti = new Text("Muuttuva teksti");
        teksti.setFont(new Font(30));

        Pane pane = new Pane();
        pane.getChildren().add(teksti);

        teksti.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (vaihto) {
                    teksti.setText("Muuttuva teksti");
                    vaihto = false;
                } else {
                    teksti.setText("HIIRI TEKSTI");
                    vaihto = true;
                }
            }
        });
        teksti.setLayoutX(200);
        teksti.setLayoutY(200);
        Scene scene = new Scene(pane, 600, 500);

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getText().equals("p")) {
                    teksti.setFill(Color.RED);
                } else {
                    teksti.setFill(Color.BLACK);
                }
            }
        });
        stage.setTitle("Muuta hiirellä ja näppiksellä!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}