package dk.sdu.cbse.common.data;

import dk.sdu.cbse.commoninput.services.IInputService;

public class GameData {

    private int displayHeight = 500;
    private int displayWidth = 500;
    private float deltaTime = 0;
    private IInputService inputService;

    public void setDisplayHeight(int height) {
        this.displayHeight = height;
    }

    public int getDisplayHeight() {
        return displayHeight;
    }

    public void setDisplayWidth(int width) {
        this.displayWidth = width;
    }

    public int getDisplayWidth() {
        return displayWidth;
    }

    public void setDeltaTime(float deltaTime) {this.deltaTime = deltaTime; }

    public float getDeltaTime() { return deltaTime; }

    public void setInputService(IInputService inputService) { this.inputService = inputService; }

    public IInputService getInputService() { return this.inputService; }
}
