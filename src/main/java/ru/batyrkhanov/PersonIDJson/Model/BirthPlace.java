package ru.batyrkhanov.PersonIDJson.Model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class BirthPlace {


    @JsonProperty("city")
    private String city;
    @JsonProperty("country")
    private GenericClass country;
    @JsonProperty("district")
    private GenericClass district;
    @JsonProperty("region")
    private GenericClass region;




    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    @JsonProperty("country")
    public GenericClass getCountry() {
        return country;
    }

    public void setCountry(GenericClass country) {
        this.country = country;
    }


    @JsonProperty("district")
    public GenericClass getDistrict() {
        return district;
    }

    public void setDistrict(GenericClass district) {
        this.district = district;
    }


    @JsonProperty("region")
    public GenericClass getRegion() {
        return region;
    }

    public void setRegion(GenericClass region) {
        this.region = region;
    }




}



