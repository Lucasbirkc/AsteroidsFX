package dk.sdu.cbse.enemy;

import dk.sdu.cbse.bullet.BulletControl;
import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IEntityProcessorService;
import dk.sdu.cbse.commoninput.data.GameAction;
import dk.sdu.cbse.commoninput.services.IInputService;

import java.util.Random;

public class EnemyControl implements IEntityProcessorService {

    private BulletControl bulletFactory;

    private final Random random = new Random();
    private final float enemySpeed = 1;
    private float shootTimer = 0;

    public EnemyControl(BulletControl bulletFactory)
    {
        this.bulletFactory = bulletFactory;
    }

    @Override
    public void process(GameData gameData, World world)
    {
        for (Entity entity : world.getEntities(Enemy.class))
        {
            if (random.nextFloat() < 0.05)
            {
                entity.setRotation(entity.getRotation() + (random.nextDouble() * 90 - 45));
            }

            double radians = Math.toRadians(entity.getRotation());
            entity.setPosX(entity.getPosX() + Math.cos(radians) * enemySpeed);
            entity.setPosY(entity.getPosY() + Math.sin(radians) * enemySpeed);

            handleShooting(entity, gameData, world);

            handleOutOfBounds(entity, gameData);
        }
    }

    private void handleShooting(Entity entity, GameData gameData, World world)
    {
        shootTimer = shootTimer + gameData.getDeltaTime();

        if (shootTimer >= 2)
        {
            if (random.nextFloat() < 1)
            {
                fireBullet(entity, gameData, world);
                shootTimer = 0;
            }
        }
    }

    private void fireBullet(Entity entity, GameData gameData, World world)
    {
        Entity bullet = bulletFactory.createBullet(entity, gameData);
        world.addEntity(bullet);
    }

    private void handleOutOfBounds(Entity entity, GameData gameData)
    {
        if (entity.getPosX() < 0) {
            entity.setPosX(gameData.getDisplayWidth());
        } else if (entity.getPosX() > gameData.getDisplayWidth()) {
            entity.setPosX(0);
        }

        if (entity.getPosY() < 0) {
            entity.setPosY(gameData.getDisplayHeight());
        } else if (entity.getPosY() > gameData.getDisplayHeight()) {
            entity.setPosY(0);
        }
    }
}
