package dk.sdu.cbse;
import dk.sdu.cbse.bullet.Bullet;

public class App {
    public static void main(String[] args)
    {
        System.out.println("Hello, Modular World!");

        Bullet myBullet = new Bullet();
        myBullet.shoot();
    }
}