package dk.sdu.cbse.common.parts;

import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;

public interface IEntityPart {
    /**
     *
     * @param gameData holds information about window/display and keys for playing
     * @param entity holds all the parts necessary for the specific entity
     */
    void process(GameData gameData, Entity entity);
}
