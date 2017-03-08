package jingo.maps.geo;

public enum LocationTypeName {

    POINT("Point");

    private String name;

    LocationTypeName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
