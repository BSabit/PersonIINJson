package ru.batyrkhanov.PersonIDJson.Model;

import com.fasterxml.jackson.annotation.*;
import java.util.Objects;


public class GenericClass {

    @JsonProperty("code")
    private String code;
    @JsonProperty("nameRu")
    private String nameRu;
    @JsonProperty("nameKz")
    private String nameKz;
    @JsonProperty("changeDate")
    private String changeDate;





    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @JsonProperty("nameRu")
    public String getNameRu() {
        return nameRu;
    }

    public void setNameRu(String nameRu) {
        this.nameRu = nameRu;
    }

    @JsonProperty("nameKz")
    public String getNameKz() {
        return nameKz;
    }

    public void setNameKz(String nameKz) {
        this.nameKz = nameKz;
    }

    @JsonProperty("changeDate")
    public String getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(String changeDate) {
        this.changeDate = changeDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenericClass type = (GenericClass) o;
        return Objects.equals(nameRu, type.nameRu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameRu);
    }
}
