package ru.batyrkhanov.PersonIDJson.Model;

import com.fasterxml.jackson.annotation.*;

import java.util.Date;


public class ListOfDocument {

    @JsonProperty("beginDate")
    private String beginDate;
    @JsonProperty("birthDate")
    private String birthDate;
    @JsonProperty("endDate")
    private Date endDate;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("issueOrganization")
    private GenericClass issueOrganization;


    @JsonProperty("number")
    private String number;
    @JsonProperty("patronymic")
    private String patronymic;
    @JsonProperty("status")
    private GenericClass status;


    @JsonProperty("surname")
    private String surname;
    @JsonProperty("type")
    private GenericClass type;





    @JsonProperty("beginDate")
    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    @JsonProperty("birthDate")
    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @JsonProperty("endDate")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("issueOrganization")
    public GenericClass getIssueOrganization() {
        return issueOrganization;
    }

    public void setIssueOrganization(GenericClass issueOrganization) {
        this.issueOrganization = issueOrganization;
    }

    @JsonProperty("number")
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @JsonProperty("patronymic")
    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @JsonProperty("status")
    public GenericClass getStatus() {
        return status;
    }

    public void setStatus(GenericClass status) {
        this.status = status;
    }

    @JsonProperty("surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @JsonProperty("type")
    public GenericClass getType() {
        return type;
    }

    public void setType(GenericClass type) {
        this.type = type;
    }


}
