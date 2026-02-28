package dk.sdu.cbse.common.services;

import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;

public interface IEntityProcessorService {
    /**
     *
     * @param gameData
     * @param world
     */
    void process(GameData gameData, World world);
}
