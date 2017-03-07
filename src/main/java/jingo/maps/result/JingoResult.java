package jingo.maps.result;

import java.util.List;

public class JingoResult<S extends JingoResource> {

    private String authenticationResultCode;
    private List<ResourceSet<S>> resourceSets;
    private int statusCode;
    private String statusDescription;
    private String traceId;

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

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    @Override
    public String toString() {
        return "Result{" +
                "authenticationResultCode='" + authenticationResultCode + '\'' +
                ", resourceSets=" + resourceSets +
                ", statusCode=" + statusCode +
                ", statusDescription='" + statusDescription + '\'' +
                ", traceId='" + traceId + '\'' +
                '}';
    }
}
