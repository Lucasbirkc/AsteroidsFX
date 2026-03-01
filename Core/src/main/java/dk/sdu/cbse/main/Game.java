package dk.sdu.cbse.main;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

class Game {

    private final Pane gameWindow = new Pane();

    public void start(Stage window) throws Exception {
        System.out.println("Game starts");
        gameWindow.setPrefSize(500, 500);

        Scene scene = new Scene(gameWindow);

        window.setScene(scene);
        window.setTitle("Asteroids");
        window.show();
    }

    public void render() {
        System.out.println("Game rendered");
    }

    public void update() {

    }

    public void draw() {

    }
}
