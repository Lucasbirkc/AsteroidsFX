package dk.sdu.cbse.main;

import dk.sdu.cbse.common.services.IEntityProcessorService;
import dk.sdu.cbse.common.services.IGamePluginService;
import dk.sdu.cbse.common.services.IPostEntityProcessorService;

import dk.sdu.cbse.commonbullet.IBulletCreator;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Collection;
import java.util.ServiceLoader;

public class Main extends Application{

    public static void main(String[] args){
        launch(Main.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        System.out.println("Main main");

        Game game = new Game(getGamePluginServices(), getEntityProcessingServices(), getPostEntityProcessingServices());

        IBulletCreator bulletFactory = ServiceLoader.load(IBulletCreator.class).findFirst().orElse(null);

        game.start(window);
        game.render();
    }

    private Collection<? extends IGamePluginService> getGamePluginServices()
    {
        return ServiceLoader.load(IGamePluginService.class).stream()
                .map(ServiceLoader.Provider::get)
                .toList();
    }

    private Collection<? extends IEntityProcessorService> getEntityProcessingServices()
    {
        return ServiceLoader.load(IEntityProcessorService.class).stream()
                .map(ServiceLoader.Provider::get)
                .toList();
    }

    private Collection<? extends IPostEntityProcessorService> getPostEntityProcessingServices()
    {
        return ServiceLoader.load(IPostEntityProcessorService.class).stream()
                .map(ServiceLoader.Provider::get)
                .toList();
    }
}
