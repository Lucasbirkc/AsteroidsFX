package dk.sdu.cbse.asteroid;

import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IEntityProcessorService;

public class AsteroidControl implements IEntityProcessorService {

    @Override
    public void process(GameData gameData, World world)
    {
        double moveSpeed = 0.25;

        for (Entity asteroid : world.getEntities(Asteroid.class)) {
            double changeX = Math.cos(Math.toRadians(asteroid.getRotation()));
            double changeY = Math.sin(Math.toRadians(asteroid.getRotation()));

            asteroid.setPosX(asteroid.getPosX() + changeX * moveSpeed);
            asteroid.setPosY(asteroid.getPosY() + changeY * moveSpeed);

            handleOutOfBounds(asteroid, gameData);
        }
    }

    private void handleOutOfBounds(Entity asteroid, GameData gameData)
    {
        if (asteroid.getPosX() < 0) {
            asteroid.setPosX(gameData.getDisplayWidth());
        } else if (asteroid.getPosX() > gameData.getDisplayWidth()) {
            asteroid.setPosX(0);
        }

        if (asteroid.getPosY() < 0) {
            asteroid.setPosY(gameData.getDisplayHeight());
        } else if (asteroid.getPosY() > gameData.getDisplayHeight()) {
            asteroid.setPosY(0);
        }
    }
}
