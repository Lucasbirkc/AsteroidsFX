package dk.sdu.cbse.main;

import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.parts.IEntityPart;
import dk.sdu.cbse.common.services.IEntityProcessorService;
import dk.sdu.cbse.common.services.IGamePluginService;
import dk.sdu.cbse.common.services.IPostEntityProcessorService;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.List;

class Game {
    private final GameData gameData = new GameData();
    private final World world = new World();
    private final Pane gameWindow = new Pane();
    private final List<IEntityProcessorService> entityProcessorServices;
    private final List<IPostEntityProcessorService> postEntityProcessorServices;
    private final List<IGamePluginService> gamePluginServices;

    Game(List<IGamePluginService> gamePluginServices, List<IEntityProcessorService> entityProcessingServices, List<IPostEntityProcessorService> postEntityProcessingServices) {
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
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
                draw();
            }
        }.start();
    }

    public void update() {
        for (IEntityProcessorService entityProcessorService : getEntityProcessorServices()) {
            entityProcessorService.process(gameData, world);
        }
    }

    public void draw() {
        System.out.println("Game drawn");
    }

    public List<IGamePluginService> getGamePluginServices() { return gamePluginServices; }
    public List<IEntityProcessorService> getEntityProcessorServices() { return entityProcessorServices; }
    public List<IPostEntityProcessorService> getPostEntityProcessorServices() { return postEntityProcessorServices; }
}
