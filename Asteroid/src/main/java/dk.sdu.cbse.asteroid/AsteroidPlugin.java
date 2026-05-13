package dk.sdu.cbse.asteroid;

import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IGamePluginService;
import jdk.jshell.spi.ExecutionControl;

public class AsteroidPlugin implements IGamePluginService {
    public void start(GameData gameData, World world)
    {
        Entity asteroid = createAsteroid(gameData);
        world.addEntity(asteroid);
    }

    public void stop(GameData gameData, World world)
    {
        for (Entity asteroid : world.getEntities(Asteroid.class))
        {
            world.removeEntity(asteroid);
        }
    }

    private Entity createAsteroid(GameData gameData)
    {
        Entity asteroid = new Asteroid();
    }
}
