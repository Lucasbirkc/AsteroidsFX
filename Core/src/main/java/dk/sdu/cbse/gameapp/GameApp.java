package dk.sdu.cbse.gameapp;

import javafx.application.Application;
import javafx.stage.Stage;

public class GameApp extends Application{

    public static void main(String[] args){
        launch(GameApp.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        System.out.println("GameApp main");
    }
}
