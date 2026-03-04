package dk.sdu.cbse.player;

import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IEntityProcessorService;

public class PlayerControl implements IEntityProcessorService {
    @Override
    public void process(GameData gameData, World world) {
        System.out.println("PlayerControl processed");
    }
}
