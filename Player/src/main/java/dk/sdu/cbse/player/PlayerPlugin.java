package dk.sdu.cbse.player;

public class PlayerPlugin {

    private string player;

    public PlayerPlugin() {
        System.out.println("PlayerPlugin initialized");
    }

    public void start() {
        System.out.println("PlayerPlugin started");
    }

    public void stop() {
        System.out.println("PlayerPlugin stopped");
    }
}
