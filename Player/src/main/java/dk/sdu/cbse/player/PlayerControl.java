package dk.sdu.cbse.player;

import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IEntityProcessorService;

public class PlayerControl implements IEntityProcessorService {

    public void process() {
        System.out.println("PlayerControl processed");
    }

    @Override
    public void process(GameData gameData, World world)
    {
        for (Entity player : world.getEntities(Player.class))
        {

        }
    }
}
