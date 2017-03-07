package jingo.maps.result.geocode;

import jingo.maps.result.JingoResource;

import java.util.Arrays;

public class GeocodeResource implements JingoResource {
    private float[] bbox;

    private String name;

    public float[] getBbox() {
        return bbox;
    }

    public void setBbox(float[] bbox) {
        this.bbox = bbox;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "GeocodeResource{" +
                "bbox=" + Arrays.toString(bbox) +
                ", name='" + name + '\'' +
                '}';
    }
}