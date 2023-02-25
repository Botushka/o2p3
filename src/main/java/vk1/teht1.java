package vk1;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class teht1 extends Application {

    private Rectangle suorakulmio;
    private Button liikuButton;

    @Override
    public void start(Stage stage) {
        suorakulmio = new Rectangle(100, 100, 200, 100);
        liikuButton = new Button("LIIKU!");

        Pane pane = new Pane();
        pane.getChildren().addAll(suorakulmio, liikuButton);

        liikuButton.setLayoutX(170);
        liikuButton.setLayoutY(10);


        liikuButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                suorakulmio.setRotate(suorakulmio.getRotate() + 20);
            }
        });

        Scene scene = new Scene(pane, 400, 300);
        stage.setTitle("Liikettä suorakulmiolle");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}