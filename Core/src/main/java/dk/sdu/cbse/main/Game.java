package dk.sdu.cbse.main;
// Project imports
import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IEntityProcessorService;
import dk.sdu.cbse.common.services.IGamePluginService;
import dk.sdu.cbse.common.services.IPostEntityProcessorService;
// Game "Engine" imports
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
// Data structures, etc.
import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

class Game {
    private final GameData gameData = new GameData();
    private final World world = new World();
    private final Pane gameWindow = new Pane();
    private final Map<UUID, Polygon> entityPolygons = new ConcurrentHashMap<>();
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

        for (IGamePluginService iGamePluginService : getGamePluginServices())
        {
            iGamePluginService.start(gameData, world);
        }

        for (Entity entity : world.getEntities())
        {
            Polygon polygon = new Polygon(entity.getCoordinates());

            entityPolygons.put(entity.getId(), polygon);
            addPolygonToGameWindow(polygon);
        }

        window.setScene(scene);
        window.setTitle("Asteroids");
        window.show();
    }

    public void render() {
        System.out.println("Game rendering");
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                System.out.println("Rendering");
                update();
                draw();
            }
        }.start();
    }

    public void update() {
        System.out.println("Updating");
    }

    public void draw() {
        System.out.println("Drawing");
    }

    private Collection<? extends IGamePluginService> getGamePluginServices() { return gamePluginServices; }
    private Collection<? extends IEntityProcessorService> getEntityProcessorServices() { return entityProcessorServices; }
    private Collection<? extends IPostEntityProcessorService> getPostEntityProcessorServices() { return postEntityProcessorServices; }

    private void addPolygonToGameWindow(Polygon polygon) { gameWindow.getChildren().add(polygon); }
}
