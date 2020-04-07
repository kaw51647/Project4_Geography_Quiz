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

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getCountryName()
    {
        return countryName;
    }

    public void setCountryName(String countryName)
    {
        this.countryName = countryName;
    }

    public String getContinent()
    {
        return continent;
    }

    public void setContinent(String continent)
    {
        this.continent = continent;
    }

}
