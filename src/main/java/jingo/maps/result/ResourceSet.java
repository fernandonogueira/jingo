package jingo.maps.result;


import java.util.List;

public class ResourceSet<S extends JingoResource> {

    private Long estimatedTotal;

    private List<S> resources;

    public Long getEstimatedTotal() {
        return estimatedTotal;
    }

    public void setEstimatedTotal(Long estimatedTotal) {
        this.estimatedTotal = estimatedTotal;
    }

    public List<S> getResources() {
        return resources;
    }

    public void setResources(List<S> resources) {
        this.resources = resources;
    }

    @Override
    public String toString() {
        return "ResourceSet{" +
                "estimatedTotal=" + estimatedTotal +
                ", resources=" + resources +
                '}';
    }
}
