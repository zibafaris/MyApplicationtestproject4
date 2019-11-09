
package com.example.myapplicationapi.Movies;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Movies {

    private List<Search> search = null;
    private String totalResults;
    private String response;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<Search> getSearch() {
        return search;
    }

    public void setSearch(List<Search> search) {
        this.search = search;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
