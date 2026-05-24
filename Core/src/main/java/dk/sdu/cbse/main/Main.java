package dk.sdu.cbse.main;

import dk.sdu.cbse.common.services.IEntityProcessorService;
import dk.sdu.cbse.common.services.IGamePluginService;
import dk.sdu.cbse.common.services.IPostEntityProcessorService;
import dk.sdu.cbse.player.Player;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collection;

// Hard dependencies : Imports for testing
import dk.sdu.cbse.player.PlayerPlugin;
import dk.sdu.cbse.player.PlayerControl;

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
        Collection<IGamePluginService> plugins = new ArrayList<>();

        plugins.add(new PlayerPlugin());

        return plugins;
    }

    private Collection<? extends IEntityProcessorService> getEntityProcessingServices()
    {
        Collection<IEntityProcessorService> processors = new ArrayList<>();

        return processors;
    }

    private Collection<? extends IPostEntityProcessorService> getPostEntityProcessingServices()
    {
        Collection<IPostEntityProcessorService> postProcessors = new ArrayList<>();

        return postProcessors;
    }
}
