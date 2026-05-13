package dk.sdu.cbse.enemy;

import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IGamePluginService;

public class EnemyPlugin implements IGamePluginService {

    private Entity enemy;

    public EnemyPlugin()
    {
        System.out.println("EnemyPlugin initialized");
    }

    public Entity createEnemy(GameData gameData)
    {
        Entity enemy = new Enemy();
        // Enemy position in world
        enemy.setPosX((double) gameData.getDisplayHeight() / 4);
        enemy.setPosY((double) gameData.getDisplayWidth() / 4);
        // Enemy structure
        enemy.setRadius(10);
        enemy.setCoordinates(new double[] {-5, -5, 10, 0, -5, 5});

        return enemy;
    }

    @Override
    public void start(GameData gameData, World world)
    {
        world.addEntity(enemy);
    }

    @Override
    public void stop(GameData gameData, World world)
    {
        world.removeEntity(enemy);
    }
}
