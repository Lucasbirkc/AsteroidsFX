package dk.sdu.cbse.collisiondetector;

import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IPostEntityProcessorService;

public class CollisionDetector implements IPostEntityProcessorService {

    @Override
    public void process(GameData gameData, World world)
    {
        for (Entity entityA : world.getEntities())
        {
            for (Entity entityB : world.getEntities())
            {
                if (isSameEntity(entityA, entityB))
                {
                    continue;
                }

                if (isColliding(entityA, entityB))
                {
                    handleCollision(entityA, entityB, world);
                }
            }
        }
    }

    private boolean isSameEntity(Entity entityA, Entity entityB)
    {
        return entityA.getId().equals(entityB.getId());
    }

    private boolean isColliding(Entity entityA, Entity entityB)
    {
        double deltaX = entityA.getPosX() - entityB.getPosX();
        double deltaY = entityA.getPosY() - entityB.getPosY();
        double distance = Math.sqrt((deltaX * deltaX) + (deltaY * deltaY));
        return distance < (entityA.getRadius() + entityB.getRadius());
    }

    private void handleCollision(Entity entityA, Entity entityB, World world)
    {
        world.removeEntity(entityA);
        world.removeEntity(entityB);
    }
}
