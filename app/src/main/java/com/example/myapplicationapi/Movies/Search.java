
package com.example.myapplicationapi.Movies;

import java.util.HashMap;
import java.util.Map;

public class Search {

    private String title;
    private String year;
    private String imdbID;
    private String type;
    private String poster;
    private String Plot;
    private String Actors;
    private String Country;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    // Constructor.
    public Search(String poster, String title,String year,String imdbID,String Plot,String Actors,String Country) {

        this.poster = poster;
        this.title = title;
        this.year = year;
        this.imdbID = imdbID;
        this.Plot = Plot;
        this.Actors = Actors;
        this.Country = Country;
    }

    public String getPlot() {
        return Plot;
    }

    public void setPlot(String Plot) {
        this.Plot = Plot;
    }

    public String getActors() {
        return Actors;
    }

    public void setActors(String Actors) {
        this.Actors = Actors;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
