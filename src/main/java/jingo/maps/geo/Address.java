package jingo.maps.geo;

public class Address extends AbstractLocationType {

    /**
     * The official street line of an address relative to the area,
     * as specified by the Locality, or PostalCode, properties.
     * Typical use of this element would be to provide a street address or any official address.
     */
    private String addressLine;
    /**
     * A string specifying the populated place for the address.
     * This typically refers to a city, but may refer to a suburb or a neighborhood in certain countries.
     */
    private String locality;
    /**
     * A string specifying the neighborhood for an address.
     * You must specify includeNeighborhood=1 in your request to return the neighborhood.
     */
    private String neighborhood;
    /**
     * A string specifying the subdivision name in the country or region for an address.
     * This element is typically treated as the first order administrative subdivision,
     * but in some cases it is the second, third,
     * or fourth order subdivision in a country, dependency, or region.
     */
    private String adminDistrict;
    /**
     * A string specifying the subdivision name in the country or region for an address.
     * This element is used when there is another level of
     * subdivision information for a location, such as the county.
     */
    private String adminDistrict2;
    /**
     * A string specifying the complete address. This address may not include the country or region.
     */
    private String formattedAddress;
    /**
     * A string specifying the post code, postal code, or ZIP Code of an address.
     */
    private String postalCode;
    /**
     * A string specifying the country or region name of an address.
     */
    private String countryRegion;
    /**
     * A string specifying the two-letter ISO country code.
     * You must specify include=ciso2 in your request to return this ISO country code.
     */
    private String countryRegionIso2;
    /**
     * A string specifying the name of the landmark when there is a landmark associated with an address.
     */
    private String landmark;

    public Address() {
        super("Address");
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getAdminDistrict() {
        return adminDistrict;
    }

    public void setAdminDistrict(String adminDistrict) {
        this.adminDistrict = adminDistrict;
    }

    public String getAdminDistrict2() {
        return adminDistrict2;
    }

    public void setAdminDistrict2(String adminDistrict2) {
        this.adminDistrict2 = adminDistrict2;
    }

    public String getFormattedAddress() {
        return formattedAddress;
    }

    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountryRegion() {
        return countryRegion;
    }

    public void setCountryRegion(String countryRegion) {
        this.countryRegion = countryRegion;
    }

    public String getCountryRegionIso2() {
        return countryRegionIso2;
    }

    public void setCountryRegionIso2(String countryRegionIso2) {
        this.countryRegionIso2 = countryRegionIso2;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressLine='" + addressLine + '\'' +
                ", locality='" + locality + '\'' +
                ", neighborhood='" + neighborhood + '\'' +
                ", adminDistrict='" + adminDistrict + '\'' +
                ", adminDistrict2='" + adminDistrict2 + '\'' +
                ", formattedAddress='" + formattedAddress + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", countryRegion='" + countryRegion + '\'' +
                ", countryRegionIso2='" + countryRegionIso2 + '\'' +
                ", landmark='" + landmark + '\'' +
                '}';
    }
}
