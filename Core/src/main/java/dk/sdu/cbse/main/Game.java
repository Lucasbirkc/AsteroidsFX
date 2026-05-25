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
import java.util.HashMap;
import java.util.Map;

class Game {
    private final GameData gameData = new GameData();
    private final World world = new World();
    private final Pane gameWindow = new Pane();
    private final Map<Entity, Polygon> entityPolygons = new HashMap<>();
    private final Collection<? extends IEntityProcessorService> entityProcessorServices;
    private final Collection<? extends IPostEntityProcessorService> postEntityProcessorServices;
    private final Collection<? extends IGamePluginService> gamePluginServices;

    Game(Collection<? extends IGamePluginService> gamePluginServices, Collection<? extends IEntityProcessorService> entityProcessingServices, Collection<? extends IPostEntityProcessorService> postEntityProcessingServices) {
        this.entityProcessorServices = entityProcessingServices;
        this.postEntityProcessorServices = postEntityProcessingServices;
        this.gamePluginServices = gamePluginServices;
    }

    public void start(Stage window) throws Exception {
        gameWindow.setPrefSize(gameData.getDisplayWidth(), gameData.getDisplayHeight());

        Scene scene = new Scene(gameWindow);

        for (IGamePluginService iGamePluginService : getGamePluginServices())
        {
            iGamePluginService.start(gameData, world);
        }

        window.setScene(scene);
        window.setTitle("Asteroids");
        window.show();
    }

    public void render() {
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
                draw();
            }
        }.start();
    }

    public void update() {
        for (IEntityProcessorService entityProcessorService : getEntityProcessorServices())
        {
            entityProcessorService.process(gameData, world);
        }
        for (IPostEntityProcessorService postEntityProcessorService : getPostEntityProcessorServices())
        {
            postEntityProcessorService.process(gameData, world);
        }
    }

    public void draw() {
        entityPolygons.entrySet().removeIf(entry -> {
            Entity entity = entry.getKey();
            Polygon polygon = entry.getValue();

            if (!world.getEntities().contains(entity))
            {
                removePolygonFromGameWindow(polygon);
                return true;
            }
            return false;
        });

        for (Entity entity : world.getEntities())
        {
            Polygon polygon = entityPolygons.computeIfAbsent(entity, e -> {
                Polygon newPolygon = new Polygon(e.getCoordinates());
                addPolygonToGameWindow(newPolygon);
                return newPolygon;
            });

            setPolygonPosition(polygon, entity);
        }
    }

    private Collection<? extends IGamePluginService> getGamePluginServices() { return gamePluginServices; }
    private Collection<? extends IEntityProcessorService> getEntityProcessorServices() { return entityProcessorServices; }
    private Collection<? extends IPostEntityProcessorService> getPostEntityProcessorServices() { return postEntityProcessorServices; }

    private void addPolygonToGameWindow(Polygon polygon) { gameWindow.getChildren().add(polygon); }
    private void removePolygonFromGameWindow(Polygon polygon) { gameWindow.getChildren().remove(polygon); }

    private void setPolygonPosition(Polygon polygon, Entity entity)
    {
        polygon.setTranslateX(entity.getPosX());
        polygon.setTranslateY(entity.getPosY());
        polygon.setRotate(entity.getRotation());
    }
}
