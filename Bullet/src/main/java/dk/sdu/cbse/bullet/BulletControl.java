package dk.sdu.cbse.bullet;

import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IEntityProcessorService;
import dk.sdu.cbse.commonbullet.Bullet;
import dk.sdu.cbse.commonbullet.IBulletCreator;

public class BulletControl implements IEntityProcessorService, IBulletCreator {

    @Override
    public void process(GameData gameData, World world) {

    }

    @Override
    public Entity createBullet(Entity entity, GameData gameData) {
        float bulletRadius = 2;

        Entity bullet = new Bullet();

        double entityRotation = Math.toRadians(entity.getRotation());

        bullet.setRadius(bulletRadius);

        return bullet;
    }
}