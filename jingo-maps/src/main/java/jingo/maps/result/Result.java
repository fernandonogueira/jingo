package jingo.maps.result;

import java.util.List;

public class Result<S extends JingoResource> {

    private String authenticationResultCode;
    private List<ResourceSet<S>> resourceSets;

    public String getAuthenticationResultCode() {
        return authenticationResultCode;
    }

    public void setAuthenticationResultCode(String authenticationResultCode) {
        this.authenticationResultCode = authenticationResultCode;
    }

    public List<ResourceSet<S>> getResourceSets() {
        return resourceSets;
    }

    public void setResourceSets(List<ResourceSet<S>> resourceSets) {
        this.resourceSets = resourceSets;
    }

    @Override
    public String toString() {
        return "Result{" +
                "authenticationResultCode='" + authenticationResultCode + '\'' +
                ", resourceSets=" + resourceSets +
                '}';
    }
}
