package dk.sdu.cbse.commoninput.services;

import dk.sdu.cbse.commoninput.data.GameAction;

public interface IInputService {
    boolean isActive(GameAction action);
    void setActionState(GameAction action, boolean state);
    void update();
}
