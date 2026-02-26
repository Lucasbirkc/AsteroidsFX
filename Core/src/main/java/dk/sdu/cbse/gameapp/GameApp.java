package dk.sdu.cbse.gameapp;

import javafx.application.Application;
import javafx.stage.Stage;

public class GameApp extends Application{

    public static void main(String[] args){
        launch(GameApp.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        System.out.println("GameApp main");

        Game game = new Game();
        game.start(window);
        game.render();
    }
}
