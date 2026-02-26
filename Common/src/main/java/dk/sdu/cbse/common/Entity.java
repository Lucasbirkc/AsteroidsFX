package dk.sdu.cbse.common;

public class Entity {

    private double[] polygonCoordinates;
    private double posX;
    private double posY;
    private double rotation;
    private double radius;

    public void setPolygonCoordinates(double[] newPolygonCoordinates) {
        this.polygonCoordinates = newPolygonCoordinates;
    }

    public double[] getPolygonCoordinates() {
        return polygonCoordinates;
    }

    public void setPosX(double newPosX) {
        this.posX = newPosX;
    }

    public double getPosX() {
        return posX;
    }

    public void setPosY(double newPosY) {
        this.posY = newPosY;
    }

    public double getPosY() {
        return posY;
    }

    public void setRotation(double newRotation) {
        this.rotation = newRotation;
    }

    public double getRotation() {
        return rotation;
    }

    public void setRadius(double newRadius) {
        this.radius = newRadius;
    }

    public double getRadius() {
        return radius;
    }
}
