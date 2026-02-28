package dk.sdu.cbse.common.services;

import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;

public interface IPostEntityProcessorService {
    /**
     *
     * @param gameData holds information about window/display and keys for playing
     * @param world holds information about world with regards all Entities (Player, bullets, asteroids etc.)
     */
    void process(GameData gameData, World world);
}
