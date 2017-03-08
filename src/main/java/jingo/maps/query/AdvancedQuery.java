package jingo.maps.query;

public class AdvancedQuery implements Query {

    /**
     * A string specifying the country or region name of an address.
     */
    private String countryRegion;

    /**
     * A string specifying the subdivision name in the country or region for an address.
     * This element is typically treated as the first order administrative subdivision,
     * but in some cases it is the second, third,
     * or fourth order subdivision in a country, dependency, or region.
     */
    private String adminDistrict;

    /**
     * A string specifying the populated place for the address.
     * This typically refers to a city, but may refer to a suburb or a neighborhood in certain countries.
     */
    private String locality;

    /**
     * A string specifying the post code, postal code, or ZIP Code of an address.
     */
    private String postalCode;

    /**
     * The official street line of an address relative to the area,
     * as specified by the Locality, or PostalCode, properties.
     * Typical use of this element would be to provide a street address or any official address.
     */
    private String addressLine;

    private String userLocation;

    private String userIp;

    private String includeNeighborhood;

    /**
     * Max results
     */
    private Integer maxResults;

    public String getCountryRegion() {
        return countryRegion;
    }

    public void setCountryRegion(String countryRegion) {
        this.countryRegion = countryRegion;
    }

    public String getAdminDistrict() {
        return adminDistrict;
    }

    public void setAdminDistrict(String adminDistrict) {
        this.adminDistrict = adminDistrict;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public String getIncludeNeighborhood() {
        return includeNeighborhood;
    }

    public void setIncludeNeighborhood(String includeNeighborhood) {
        this.includeNeighborhood = includeNeighborhood;
    }

    @Override
    public Integer getMaxResults() {
        return maxResults;
    }

    @Override
    public void setMaxResults(Integer maxResults) {
        this.maxResults = maxResults;
    }
}
