package dk.sdu.cbse.main;

import dk.sdu.cbse.commoninput.data.GameAction;
import dk.sdu.cbse.commoninput.services.IInputService;

import java.util.EnumMap;
import java.util.Map;

public class InputManager implements IInputService {
    private final Map<GameAction, Boolean> currentKeys = new EnumMap<>(GameAction.class);
    private final Map<GameAction, Boolean> previousKeys = new EnumMap<>(GameAction.class);

    public InputManager()
    {
        for (GameAction action : GameAction.values())
        {
            currentKeys.put(action, false);
            previousKeys.put(action, false);
        }
    }

    @Override
    public boolean isActive(GameAction action)
    {
        return currentKeys.getOrDefault(action, false);
    }

    @Override
    public void setActionState(GameAction action, boolean isActive)
    {
        currentKeys.put(action, isActive);
    }

    @Override
    public void update()
    {
        previousKeys.putAll(currentKeys);
    }
}
