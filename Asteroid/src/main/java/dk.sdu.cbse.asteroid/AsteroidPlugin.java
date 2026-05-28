package dk.sdu.cbse.asteroid;

import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IGamePluginService;
import jdk.jshell.spi.ExecutionControl;

import java.util.Random;

public class AsteroidPlugin implements IGamePluginService {

    @Override
    public void start(GameData gameData, World world)
    {
        for (int i = 0; i < 5; i++)
        {
            Entity asteroid = createAsteroid(gameData);
            world.addEntity(asteroid);
        }
    }

    @Override
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

        Random random = new Random();

        float radius = 10 + random.nextFloat() * 10;
        asteroid.setRadius(radius);

        asteroid.setRotation(random.nextDouble() * 360);

        int points = 8;
        double[] coordinates = new double[points * 2];

        for (int i = 0; i < points; i++)
        {
            double angle = (2 * Math.PI / points) * i;

            double randomlyScaledRadius = radius * (0.8 + random.nextDouble() * 0.4);
            coordinates[i * 2] = Math.cos(angle) * randomlyScaledRadius;
            coordinates[i * 2 + 1] = Math.sin(angle) * randomlyScaledRadius;
        }

        asteroid.setCoordinates(coordinates);

        asteroid.setPosX(random.nextDouble() * gameData.getDisplayWidth());
        asteroid.setPosY(random.nextDouble() * gameData.getDisplayHeight());

        return asteroid;
    }
}
