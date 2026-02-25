package dk.sdu.cbse.common.objects;

public class Entity {

    private double[] polygonCoordinates
    private double posX;
    private double posY;
    private double rotation;
    private double radius;

    public void setPolygonCoordinates(double[] newPolygonCoordinates) {
        this.polygonCoordinates = newPolygonCoordinates;
    }

    public void getPolygonCoordinates() {
        return polygonCoordinates;
    }

    public void setPosX(double newPosX) {
        this.posX = newPosX;
    }

    public void getPosX() {
        return posX;
    }

    public void setPosY(double newPosY) {
        this.posY = newPosY;
    }

    public void getPosY() {
        return posY;
    }

    public void setRotation(double newRotation) {
        this.rotation = newRotation;
    }

    public void getRotation() {
        return rotation;
    }

    public void setRadius(double newRadius) {
        this.radius = newRadius;
    }

    public void getRadius() {
        return radius;
    }
}