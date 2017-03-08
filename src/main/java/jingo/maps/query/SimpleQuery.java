package jingo.maps.query;

public class SimpleQuery implements Query {

    private String query;

    private Integer maxResults;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
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
