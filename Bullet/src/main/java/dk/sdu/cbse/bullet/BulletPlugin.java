package dk.sdu.cbse.bullet;

import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IGamePluginService;
import dk.sdu.cbse.commonbullet.Bullet;

public class BulletPlugin implements IGamePluginService {

    @Override
    public void start(GameData gameData, World world)
    {
    }

    @Override
    public void stop(GameData gameData, World world)
    {
        for (Entity bullet : world.getEntities(Bullet.class))
        {
            world.removeEntity(bullet);
        }
    }
}
