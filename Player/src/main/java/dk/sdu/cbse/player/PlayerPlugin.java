package dk.sdu.cbse.player;

import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IGamePluginService;

public class PlayerPlugin implements IGamePluginService {

    private Entity player;

    public PlayerPlugin() {
        System.out.println("PlayerPlugin initialized");
    }

    public Entity createPlayer(GameData gameData)
    {
        Entity player = new Player();
        // Player position in world
        player.setPosX((double) gameData.getDisplayHeight() / 2);
        player.setPosY((double) gameData.getDisplayWidth() / 2);
        // Player structure
        player.setRadius(10);
        player.setCoordinates(new double[] {-5, -5, 10, 0, -5, 5});

        return player;
    }

    @Override
    public void start(GameData gameData, World world)
    {

        world.addEntity(player);
    }

    @Override
    public void stop(GameData gameData, World world)
    {
        world.removeEntity(player);
    }
}
