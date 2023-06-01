package ru.batyrkhanov.PersonIDJson.Model;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

public class Documents {

    @JsonProperty("listOfDocuments")
    private List<ListOfDocument> listOfDocuments;




    @JsonProperty("listOfDocuments")
    public List<ListOfDocument> getListOfDocuments() {
        return listOfDocuments;
    }

    public void setListOfDocuments(List<ListOfDocument> listOfDocuments) {
        this.listOfDocuments = listOfDocuments;
    }

}
