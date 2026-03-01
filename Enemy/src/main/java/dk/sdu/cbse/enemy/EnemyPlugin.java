package dk.sdu.cbse.enemy;

public class EnemyPlugin {

    private String enemy;

    public EnemyPlugin() {
        System.out.println("EnemyPlugin initialized");
    }

    public void start() {
        System.out.println("EnemyPlugin started");
    }

    public void stop() {
        System.out.println("EnemyPlugin stopped");
    }
}
