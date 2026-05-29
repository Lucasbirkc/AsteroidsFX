package dk.sdu.cbse.main;

import dk.sdu.cbse.common.services.IEntityProcessorService;
import dk.sdu.cbse.common.services.IGamePluginService;
import dk.sdu.cbse.common.services.IPostEntityProcessorService;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collection;

// Hard dependencies : Imports for testing
import dk.sdu.cbse.player.PlayerPlugin;
import dk.sdu.cbse.player.PlayerControl;
import dk.sdu.cbse.enemy.EnemyControl;
import dk.sdu.cbse.enemy.EnemyPlugin;
import dk.sdu.cbse.asteroid.AsteroidControl;
import dk.sdu.cbse.asteroid.AsteroidPlugin;
import dk.sdu.cbse.bullet.BulletControl;
import dk.sdu.cbse.collisiondetector.CollisionDetector;

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
        // Direct dependency implementation
        Collection<IGamePluginService> plugins = new ArrayList<>();

        plugins.add(new EnemyPlugin());
        plugins.add(new PlayerPlugin());
        plugins.add(new AsteroidPlugin());

        return plugins;
    }

    private Collection<? extends IEntityProcessorService> getEntityProcessingServices()
    {
        // Direct dependency implementation
        Collection<IEntityProcessorService> processors = new ArrayList<>();
        BulletControl bulletFactory = new BulletControl();
        processors.add(bulletFactory);
        processors.add(new EnemyControl(bulletFactory));
        processors.add(new PlayerControl(bulletFactory));
        processors.add(new AsteroidControl());

        return processors;
    }

    private Collection<? extends IPostEntityProcessorService> getPostEntityProcessingServices()
    {
        // Direct dependency implementation
        Collection<IPostEntityProcessorService> postProcessors = new ArrayList<>();

        postProcessors.add(new CollisionDetector());

        return postProcessors;
    }
}
