package dk.sdu.cbse.common.data;

import java.io.Serializable;
import java.util.UUID;

public class Entity implements Serializable {
    private final UUID id = UUID.randomUUID();

    private double[] coordinates;
    private double posX;
    private double posY;
    private double rotation;
    private float radius;

    public UUID getId() { return this.id; }

    public double[] getCoordinates()
    {
        return this.coordinates;
    }

    public double getPosX()
    {
        return this.posX;
    }

    public double getPosY()
    {
        return this.posY;
    }

    public double getRotation()
    {
        return this.rotation;
    }

    public double getRadius()
    {
        return this.radius;
    }

    public void setCoordinates(double[] newCoordinates)
    {
        this.coordinates = newCoordinates;
    }

    public void setPosX(double newX)
    {
        this.posX = newX;
    }

    public void setPosY(double newY)
    {
        this.posY = newY;
    }

    public void setRotation(double newRotation)
    {
        this.rotation = newRotation;
    }

    public void setRadius(float newRadius)
    {
        this.radius = newRadius;
    }
}
