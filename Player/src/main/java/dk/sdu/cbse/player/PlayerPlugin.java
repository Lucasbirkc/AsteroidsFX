package dk.sdu.cbse.player;

import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IGamePluginService;

public class PlayerPlugin implements IGamePluginService {

    private String player;

    public PlayerPlugin() {
        System.out.println("PlayerPlugin initialized");
    }

    @Override
    public void start(GameData gameData, World world)
    {
        System.out.println("PlayerPlugin started");
    }

    @Override
    public void stop(GameData gameData, World world)
    {
        System.out.println("PlayerPlugin stopped");
    }
}
