package ru.batyrkhanov.PersonIDJson.Model;

import com.fasterxml.jackson.annotation.*;

public class RegAddress {


    @JsonProperty("arCode")
    private String arCode;
    @JsonProperty("beginDate")
    private String beginDate;
    @JsonProperty("building")
    private String building;
    @JsonProperty("country")
    private GenericClass country;

    @JsonProperty("district")
    private GenericClass district;


    @JsonProperty("flat")
    private Object flat;
    @JsonProperty("invalidity")
    private GenericClass invalidity;

    @JsonProperty("region")
    private GenericClass region;
    @JsonProperty("status")
    private GenericClass status;
    @JsonProperty("street")
    private String street;





    @JsonProperty("arCode")
    public String getArCode() {
        return arCode;
    }

    public void setArCode(String arCode) {
        this.arCode = arCode;
    }


    @JsonProperty("beginDate")
    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }


    @JsonProperty("building")
    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
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


    @JsonProperty("flat")
    public Object getFlat() {
        return flat;
    }

    public void setFlat(Object flat) {
        this.flat = flat;
    }


    @JsonProperty("invalidity")
    public GenericClass getInvalidity() {
        return invalidity;
    }

    public void setInvalidity(GenericClass invalidity) {
        this.invalidity = invalidity;
    }


    @JsonProperty("region")
    public GenericClass getRegion() {
        return region;
    }

    public void setRegion(GenericClass region) {
        this.region = region;
    }


    @JsonProperty("status")
    public GenericClass getStatus() {
        return status;
    }

    public void setStatus(GenericClass status) {
        this.status = status;
    }


    @JsonProperty("street")
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
