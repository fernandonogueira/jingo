package jingo.maps.geo;

public class Point extends AbstractLocationType {

    private float[] coordinates;

    public Point() {
        super(LocationTypeName.POINT.getName());
    }

    public float[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(float[] coordinates) {
        this.coordinates = coordinates;
    }
}
