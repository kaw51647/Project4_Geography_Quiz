package edu.uga.cs.project4_geography_quiz;

public class Question {

    private long id;
    private String option1;
    private String option2;
    private String option3;
    public Country countryX;
    private String correctAnswer;

    //constructors
    public Question() {
        this.id = -1;
        this.option1 = null;
        this.option2 = null;
        this.option3 = null;
        this.countryX = null;
    }

    public Question(String option1, String option2, String option3, Country countryX) {
        this.id = -1;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.countryX = countryX;
    }


    //getters/setters
    public long getId()
    {
        return id;
    }
    public void setId(long id)
    {
        this.id = id;
    }

    public String getOption1()
    {
        return option1;
    }
    public String getOption2()
    {
        return option2;
    }
    public String getOption3()
    {
        return option3;
    }

    public void setOption1(String option1)
    {
        this.option1 = option1;
    }
    public void setOption2(String option2)
    {
        this.option2 = option2;
    }
    public void setOption3(String option3)
    {
        this.option3 = option3;
    }

    public Country getCountryX()
    {
        return countryX;
    }
    public void setCountryX(Country countryX)
    {
        this.countryX = countryX;
    }


    /* function that loads data into Question */
    /*public void populateQuestion() {

        Country temp = null;    /* LOAD RANDOM DATABASE COUNTRY OBJECT INTO THIS VARIABLE */
        String tempCountry = null, tempContinent = null;  /* OR LOAD STRING VALUES FROM DATABASE INTO THESE AND I WILL CONVERT THOSE INTO A COUNTRY OBJECT */

        /*
        temp.setCountryName(tempCountry);
        temp.setContinent(tempContinent);
        */

        //this.countryX = temp;


        // this is where I will populate the other answer choices randomly

   // }

}
