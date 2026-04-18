package dk.sdu.cbse.main;

import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.parts.IEntityPart;
import dk.sdu.cbse.common.services.IEntityProcessorService;
import dk.sdu.cbse.common.services.IGamePluginService;
import dk.sdu.cbse.common.services.IPostEntityProcessorService;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Collection;

class Game {
    private final GameData gameData = new GameData();
    private final World world = new World();
    private final Pane gameWindow = new Pane();
    private final Collection<? extends IEntityProcessorService> entityProcessorServices;
    private final Collection<? extends IPostEntityProcessorService> postEntityProcessorServices;
    private final Collection<? extends IGamePluginService> gamePluginServices;

    Game(Collection<? extends IGamePluginService> gamePluginServices, Collection<? extends IEntityProcessorService> entityProcessingServices, Collection<? extends IPostEntityProcessorService> postEntityProcessingServices) {
        this.entityProcessorServices = entityProcessingServices;
        this.postEntityProcessorServices = postEntityProcessingServices;
        this.gamePluginServices = gamePluginServices;
    }

    public void start(Stage window) throws Exception {
        System.out.println("Game starts");
        gameWindow.setPrefSize(gameData.getDisplayWidth(), gameData.getDisplayHeight());

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

    public Collection<? extends IGamePluginService> getGamePluginServices() { return gamePluginServices; }
    public Collection<? extends IEntityProcessorService> getEntityProcessorServices() { return entityProcessorServices; }
    public Collection<? extends IPostEntityProcessorService> getPostEntityProcessorServices() { return postEntityProcessorServices; }
}
