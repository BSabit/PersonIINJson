package ru.batyrkhanov.PersonIDJson.Dto;


import ru.batyrkhanov.PersonIDJson.Model.BirthPlace;
import ru.batyrkhanov.PersonIDJson.Model.Documents;
import ru.batyrkhanov.PersonIDJson.Model.GenericClass;
import ru.batyrkhanov.PersonIDJson.Model.RegAddress;

import java.util.Date;

public class ExampleDTO {


    private String firstName;
    private String lastName;
    private String fatherName;
    private String gender;
    private String birthDate;
    private String isResident;
    private String iin;
    private String mobilePhone;
    private String birthPlace;
    private String addressCity;
    private String addressPlace;
    private String addressHouseNo;
    private String addressAptNo;
    private String addressTitle;
    private String isCitizenship;
    private String paperTitle;
    private String paperType;
    private String paperIssueDate;
    private Date paperValidityDate;
    private String paperIssuer;
    private String paperNumber;
    private String paperStatus = "APPR";
    private String paperBSystem = "SMBK";
    private String registeredBy = "Зарегистрирован в SmartBank 3.0";
    private String regChannelId = "WEBB";


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getIsResident() {
        return isResident;
    }

    public void setIsResident(String isResident) {
        this.isResident = isResident;
    }

    public String getIin() {
        return iin;
    }

    public void setIin(String iin) {
        this.iin = iin;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressPlace() {
        return addressPlace;
    }

    public void setAddressPlace(String addressPlace) {
        this.addressPlace = addressPlace;
    }

    public String getAddressHouseNo() {
        return addressHouseNo;
    }

    public void setAddressHouseNo(String addressHouseNo) {
        this.addressHouseNo = addressHouseNo;
    }

    public String getAddressAptNo() {
        return addressAptNo;
    }

    public void setAddressAptNo(String addressAptNo) {
        this.addressAptNo = addressAptNo;
    }

    public String getAddressTitle() {
        return addressTitle;
    }

    public void setAddressTitle(String addressTitle) {
        this.addressTitle = addressTitle;
    }

    public String getIsCitizenship() {
        return isCitizenship;
    }

    public void setIsCitizenship(String isCitizenship) {
        this.isCitizenship = isCitizenship;
    }

    public String getPaperTitle() {
        return paperTitle;
    }

    public void setPaperTitle(String paperTitle) {
        this.paperTitle = paperTitle;
    }

    public String getPaperType() {
        return paperType;
    }

    public void setPaperType(String paperType) {
        this.paperType = paperType;
    }

    public String getPaperIssueDate() {
        return paperIssueDate;
    }

    public void setPaperIssueDate(String paperIssueDate) {
        this.paperIssueDate = paperIssueDate;
    }

    public Date getPaperValidityDate() {
        return paperValidityDate;
    }

    public void setPaperValidityDate(Date paperValidityDate) {
        this.paperValidityDate = paperValidityDate;
    }

    public String getPaperIssuer() {
        return paperIssuer;
    }

    public void setPaperIssuer(String paperIssuer) {
        this.paperIssuer = paperIssuer;
    }

    public String getPaperNumber() {
        return paperNumber;
    }

    public void setPaperNumber(String paperNumber) {
        this.paperNumber = paperNumber;
    }

    public String getPaperStatus() {
        return paperStatus;
    }

    public void setPaperStatus(String paperStatus) {
        this.paperStatus = paperStatus;
    }

    public String getPaperBSystem() {
        return paperBSystem;
    }

    public void setPaperBSystem(String paperBSystem) {
        this.paperBSystem = paperBSystem;
    }

    public String getRegisteredBy() {
        return registeredBy;
    }

    public void setRegisteredBy(String registeredBy) {
        this.registeredBy = registeredBy;
    }

    public String getRegChannelId() {
        return regChannelId;
    }

    public void setRegChannelId(String regChannelId) {
        this.regChannelId = regChannelId;
    }

}
