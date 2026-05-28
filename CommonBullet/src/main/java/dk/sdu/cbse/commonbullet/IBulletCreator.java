package dk.sdu.cbse.commonbullet;

import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;

public interface IBulletCreator {
    Entity createBullet(Entity entity, GameData gameData);
}
