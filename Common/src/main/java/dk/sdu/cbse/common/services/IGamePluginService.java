package dk.sdu.cbse.common.services;

import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;

public interface IGamePluginService {
    /**
     *
     * @param gameData holds information about window/display and keys for playing
     * @param world holds information about world with regards all Entities (Player, bullets, asteroids etc.)
     */
    void start(GameData gameData, World world);

    void stop(GameData gameData, World world);
}
