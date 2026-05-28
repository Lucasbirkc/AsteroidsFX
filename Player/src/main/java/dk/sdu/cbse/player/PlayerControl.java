package dk.sdu.cbse.player;

import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IEntityProcessorService;
import dk.sdu.cbse.commoninput.data.GameAction;
import dk.sdu.cbse.commoninput.services.IInputService;

public class PlayerControl implements IEntityProcessorService {
    private final double rotationDelta = 5;
    private final double thrustDelta = 1;

    @Override
    public void process(GameData gameData, World world)
    {
        IInputService input = gameData.getInputService();

        if (input == null)
        {
            return;
        }

        for (Entity player : world.getEntities(Player.class))
        {
            if (input.isActive(GameAction.MOVE_LEFT))
            {
                player.setRotation(player.getRotation() - rotationDelta);
            }
            if (input.isActive(GameAction.MOVE_RIGHT))
            {
                player.setRotation(player.getRotation() + rotationDelta);
            }
            if (input.isActive(GameAction.THRUST))
            {
                double radians = Math.toRadians(player.getRotation());
                player.setPosX(player.getPosX() + Math.cos(radians) * thrustDelta);
                player.setPosY(player.getPosY() + Math.sin(radians) * thrustDelta);
            }
            if (input.isActive(GameAction.SHOOT)) {
                System.out.println("Shooting not implemented");
            }

            if (player.getPosX() < 0) {
                player.setPosX(1);
            }

            if (player.getPosX() > gameData.getDisplayWidth()) {
                player.setPosX(gameData.getDisplayWidth()-1);
            }

            if (player.getPosY() < 0) {
                player.setPosY(1);
            }

            if (player.getPosY() > gameData.getDisplayHeight()) {
                player.setPosY(gameData.getDisplayHeight()-1);
            }
        }
    }
}
