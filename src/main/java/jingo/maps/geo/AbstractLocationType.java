package jingo.maps.geo;

public class AbstractLocationType implements LocationType {

    private String type;

    public AbstractLocationType(String type) {
        this.type = type;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

}
