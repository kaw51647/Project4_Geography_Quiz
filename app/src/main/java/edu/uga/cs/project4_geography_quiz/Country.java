package edu.uga.cs.project4_geography_quiz;

public class Country {

    private long id;
    private String countryName;
    private String continent;

    public Country() {
        this.id = -1;
        this.countryName = null;
        this.continent = null;
    }

    public Country(String countryName, String continent) {
        this.id = -1;
        this.countryName = countryName;
        this.continent = continent;
    }


}
