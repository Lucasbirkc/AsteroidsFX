package dk.sdu.cbse.main;

import dk.sdu.cbse.common.services.IEntityProcessorService;
import dk.sdu.cbse.common.services.IGamePluginService;
import dk.sdu.cbse.common.services.IPostEntityProcessorService;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Collection;

public class Main extends Application{

    public static void main(String[] args){
        launch(Main.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        System.out.println("Main main");

        Game game = new Game(getGamePluginServices(), getEntityProcessingServices(), getPostEntityProcessingServices());
        game.start(window);
        game.render();
    }

    private Collection<? extends IGamePluginService> getGamePluginServices()
    {
        return null;
    }

    private Collection<? extends IEntityProcessorService> getEntityProcessingServices()
    {
        return null;
    }

    private Collection<? extends IPostEntityProcessorService> getPostEntityProcessingServices()
    {
        return null;
    }
}
