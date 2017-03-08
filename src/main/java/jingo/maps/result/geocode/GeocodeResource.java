package jingo.maps.result.geocode;

import jingo.maps.geo.Address;
import jingo.maps.geo.Point;
import jingo.maps.result.JingoResource;

import java.util.Arrays;

public class GeocodeResource implements JingoResource {

    /**
     * A geographic area that contains the location.
     * A bounding box contains SouthLatitude, WestLongitude,
     * NorthLatitude, and EastLongitude values in units of degrees.
     */
    private float[] bbox;

    /**
     * Resource name
     */
    private String name;

    /**
     * The latitude and longitude coordinates of the location.
     */
    private Point point;

    /**
     * The postal address for the location.
     * An address can contain AddressLine, Neighborhood, Locality, AdminDistrict,
     * AdminDistrict2, CountryRegion, CountryRegionIso2, PostalCode, FormattedAddress, and Landmark fields.
     */
    private Address address;

    /**
     * The level of confidence that the geocoded location result is a match.
     * Use this value with the match code to determine for more complete information about the match.
     */
    private Confidence confidence;

    /**
     * The classification of the geographic entity returned, such as Address.
     * For a list of entity types, see Location and Area Types.
     */
    private String entityType;

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

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Confidence getConfidence() {
        return confidence;
    }

    public void setConfidence(Confidence confidence) {
        this.confidence = confidence;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    @Override
    public String toString() {
        return "GeocodeResource{" +
                "bbox=" + Arrays.toString(bbox) +
                ", name='" + name + '\'' +
                ", point=" + point +
                ", address=" + address +
                ", confidence='" + confidence + '\'' +
                ", entityType='" + entityType + '\'' +
                '}';
    }
}