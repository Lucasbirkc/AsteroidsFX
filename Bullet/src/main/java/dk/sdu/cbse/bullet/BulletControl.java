package dk.sdu.cbse.bullet;

import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IEntityProcessorService;
import dk.sdu.cbse.commonbullet.Bullet;
import dk.sdu.cbse.commonbullet.IBulletCreator;

public class BulletControl implements IEntityProcessorService, IBulletCreator {

    public BulletControl() {}

    @Override
    public void process(GameData gameData, World world) {
        float moveSpeed = 7;

        for (Entity entity : world.getEntities(Bullet.class))
        {
            double radians = Math.toRadians(entity.getRotation());

            entity.setPosX(entity.getPosX() + Math.cos(radians) * moveSpeed);
            entity.setPosY(entity.getPosY() + Math.sin(radians) * moveSpeed);

            if (isOutOfBounds(entity, gameData))
            {
                world.removeEntity(entity);
            }
        }
    }

    @Override
    public Entity createBullet(Entity entity, GameData gameData) {
        float bulletRadius = 2;

        Entity bullet = new Bullet();

        double entityRotationRadians = Math.toRadians(entity.getRotation());
        bullet.setRotation(entity.getRotation());

        double offset = entity.getRadius() + bulletRadius;
        bullet.setPosX(entity.getPosX() + Math.cos(entityRotationRadians) * offset);
        bullet.setPosY(entity.getPosY() + Math.sin(entityRotationRadians) * offset);

        bullet.setCoordinates(new double[]{
                -1, -1,
                 1, -1,
                 1, 1,
                -1, 1
        });

        return bullet;
    }

    private boolean isOutOfBounds(Entity bullet, GameData gameData)
    {
        return bullet.getPosX() < 0
                || bullet.getPosX() > gameData.getDisplayWidth()
                || bullet.getPosY() < 0
                || bullet.getPosY() > gameData.getDisplayHeight();
    }
}
