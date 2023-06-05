package ru.batyrkhanov.PersonIDJson.Model;

import com.fasterxml.jackson.annotation.*;

public class ExampleModel {

    @JsonProperty("birthDate")
    private String birthDate;
    @JsonProperty("birthPlace")
    private BirthPlace birthPlace;
    @JsonProperty("citizenship")
    private GenericClass citizenship;
    @JsonProperty("documents")
    private Documents documents;

    @JsonProperty("engFirstName")
    private String engFirstName;
    @JsonProperty("engSurname")
    private String engSurname;
    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("gender")
    private GenericClass gender;
    @JsonProperty("iin")
    private String iin;
    @JsonProperty("lifeStatus")
    private GenericClass lifeStatus;
    @JsonProperty("nationality")
    private GenericClass nationality;
    @JsonProperty("patronymic")
    private String patronymic;
    @JsonProperty("regAddress")
    private RegAddress regAddress;
    @JsonProperty("surname")
    private String surname;




    @JsonProperty("birthDate")
    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }


    @JsonProperty("birthPlace")
    public BirthPlace getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(BirthPlace birthPlace) {
        this.birthPlace = birthPlace;
    }


    @JsonProperty("citizenship")
    public GenericClass getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(GenericClass citizenship) {
        this.citizenship = citizenship;
    }


    @JsonProperty("documents")
    public Documents getDocuments() {
        return documents;
    }

    public void setDocuments(Documents documents) {
        this.documents = documents;
    }


    @JsonProperty("engFirstName")
    public String getEngFirstName() {
        return engFirstName;
    }

    public void setEngFirstName(String engFirstName) {
        this.engFirstName = engFirstName;
    }


    @JsonProperty("engSurname")
    public String getEngSurname() {
        return engSurname;
    }

    public void setEngSurname(String engSurname) {
        this.engSurname = engSurname;
    }


    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    @JsonProperty("gender")
    public GenericClass getGender() {
        return gender;
    }

    public void setGender(GenericClass gender) {
        this.gender = gender;
    }


    @JsonProperty("iin")
    public String getIin() {
        return iin;
    }

    public void setIin(String iin) {
        this.iin = iin;
    }


    @JsonProperty("lifeStatus")
    public GenericClass getLifeStatus() {
        return lifeStatus;
    }

    public void setLifeStatus(GenericClass lifeStatus) {
        this.lifeStatus = lifeStatus;
    }


    @JsonProperty("nationality")
    public GenericClass getNationality() {
        return nationality;
    }

    public void setNationality(GenericClass nationality) {
        this.nationality = nationality;
    }


    @JsonProperty("patronymic")
    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }


    @JsonProperty("regAddress")
    public RegAddress getRegAddress() {
        return regAddress;
    }

    public void setRegAddress(RegAddress regAddress) {
        this.regAddress = regAddress;
    }


    @JsonProperty("surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
