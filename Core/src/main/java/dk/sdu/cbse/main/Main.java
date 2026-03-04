package dk.sdu.cbse.main;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.List;
import java.util.ServiceLoader;
import dk.sdu.cbse.common.services.IEntityProcessorService;
import dk.sdu.cbse.common.services.IGamePluginService;
import dk.sdu.cbse.common.services.IPostEntityProcessorService;

import static java.util.stream.Collectors.toList;

public class Main extends Application{

    public static void main(String[] args){
        launch(Main.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        System.out.println("Main main");

        Game game = new Game(gamePluginServices(), entityProcessingServiceList(), postEntityProcessingServices());
        game.start(window);
        game.render();
    }

    public List<IEntityProcessorService> entityProcessingServiceList(){
        return ServiceLoader.load(IEntityProcessorService.class).stream().map(ServiceLoader.Provider::get).collect(toList());
    }

    public List<IGamePluginService> gamePluginServices() {
        return ServiceLoader.load(IGamePluginService.class).stream().map(ServiceLoader.Provider::get).collect(toList());
    }

    public List<IPostEntityProcessorService> postEntityProcessingServices() {
        return ServiceLoader.load(IPostEntityProcessorService.class).stream().map(ServiceLoader.Provider::get).collect(toList());
    }
}
