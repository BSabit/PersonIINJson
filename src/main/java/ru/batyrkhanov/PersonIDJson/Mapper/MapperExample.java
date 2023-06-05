package ru.batyrkhanov.PersonIDJson.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.batyrkhanov.PersonIDJson.Controller.PersonController;
import ru.batyrkhanov.PersonIDJson.Dto.ExampleDTO;
import ru.batyrkhanov.PersonIDJson.Model.*;
import ru.batyrkhanov.PersonIDJson.annatation.*;

import java.util.Date;
import java.util.List;

@Mapper(componentModel = "spring")
public interface MapperExample {

    MapperExample INSTANCE = Mappers.getMapper(MapperExample.class);

    @Mapping(target = "lastName", source = "surname")
    @Mapping(target = "fatherName", source = "patronymic")
    @Mapping(target = "gender", source = "gender", qualifiedBy = Gender.class)
    @Mapping(target = "isResident", source = "citizenship", qualifiedBy = IsResident.class)
    @Mapping(target = "birthPlace", source = "birthPlace", qualifiedBy = BirthPlaceAnn.class)
    @Mapping(target = "addressCity", source = "regAddress", qualifiedBy = AddressCity.class)
    @Mapping(target = "addressPlace", source = "regAddress", qualifiedBy = AddressPlace.class)
    @Mapping(target = "addressHouseNo", source = "regAddress", qualifiedBy = AddressHouseNo.class)
    @Mapping(target = "addressAptNo", source = "regAddress", qualifiedBy = AddressAptNo.class)
    @Mapping(target = "addressTitle", source = "regAddress", qualifiedBy = AddressTitle.class)
    @Mapping(target = "isCitizenship", source = "citizenship", qualifiedBy = IsCitizenship.class)
    @Mapping(target = "paperTitle", source = "documents", qualifiedBy = PaperTitle.class)
    @Mapping(target = "paperType", source = "documents", qualifiedBy = paperType.class)
    @Mapping(target = "paperIssueDate", source = "documents", qualifiedBy = paperIssueDate.class)
    @Mapping(target = "paperValidityDate", source = "documents", qualifiedBy = paperValidityDate.class)
    @Mapping(target = "paperIssuer", source = "documents", qualifiedBy = paperIssuer.class)
    @Mapping(target = "paperNumber", source = "documents", qualifiedBy = paperNumber.class)
    ExampleDTO modelToDTO(ExampleModel exampleModel);






    @Gender
    public static String gender(GenericClass exampleModel) {
        if(exampleModel.getCode().equals("1")) {
            return "MALE";
        } else {
            return "FAMALE";

        }
    }

    @IsResident
    public static String isResident(GenericClass citizenship) {
        if (citizenship.getCode().equals("398")) {
            return  "true";
        } else {
            return "false";
        }
    }

    @BirthPlaceAnn
    public static String birthPlace(BirthPlace birthPlace) {
        return birthPlace.getCountry().getNameRu() + ", " +
                birthPlace.getDistrict().getNameRu() + ", " +
                birthPlace.getRegion().getNameRu() + ", " +
                birthPlace.getCity();
    }

    @AddressCity
    public static String addressCity(RegAddress regAddress) {
        return regAddress.getRegion().getNameRu();
    }

    @AddressPlace
    public static String addressPlace(RegAddress regAddress) {
        return regAddress.getStreet();
    }

    @AddressHouseNo
    public static String AddressHouseNo(RegAddress regAddress) {
        return regAddress.getBuilding();
    }

    @AddressAptNo
    public static String AddressAptNo(RegAddress regAddress) {
        return regAddress.getFlat();
    }

    @AddressTitle
    public static String AddressTitle(RegAddress regAddress) {
        return regAddress.getRegion().getNameRu() + ", " + regAddress.getStreet() + ", " +
                regAddress.getBuilding() + ", " + regAddress.getFlat();
    }

    @IsCitizenship
    public static String IsCitizenship(GenericClass citizenship) {
        if (citizenship.getCode().equals("398")){
            return "true";
        } else {
            return "false";
        }
    }






    @PaperTitle
    public static String PaperTitle(Documents documents) {
        ListOfDocument listOfDocument = sortDocument(documents);
        return listOfDocument.getType().getNameRu();
    }

    @paperType
    public static String paperType(Documents documents) {
        ListOfDocument listOfDocument = sortDocument(documents);
        if (listOfDocument.getType().getNameRu().equals("УДОСТОВЕРЕНИЕ РК")) {
            return "IDEN";
        } else {
            return "PASS";
        }
    }

    @paperIssueDate
    public static String paperIssueDate(Documents documents) {
        ListOfDocument listOfDocument = sortDocument(documents);
        return listOfDocument.getBeginDate();
    }

    @paperValidityDate
    public static Date paperValidityDate(Documents documents) {
        ListOfDocument listOfDocument = sortDocument(documents);
        return listOfDocument.getEndDate();
    }

    @paperIssuer
    public static String paperIssuer(Documents documents) {
        ListOfDocument listOfDocument = sortDocument(documents);
        return listOfDocument.getIssueOrganization().getNameRu();
    }

    @paperNumber
    public static String paperNumber(Documents documents) {
        ListOfDocument listOfDocument = sortDocument(documents);
        return listOfDocument.getNumber();
    }



    public static ListOfDocument sortDocument(Documents documents) {
        List<ListOfDocument> listDoc = documents.getListOfDocuments();
        ListOfDocument udv = null;
        ListOfDocument pas = null;


        for (ListOfDocument d : listDoc) {
            if (d.getStatus().getNameRu().equals("ДОКУМЕНТ ДЕЙСТВИТЕЛЕН")) {
                if (d.getType().getNameRu().equals("УДОСТОВЕРЕНИЕ РК")) {
                    if (udv == null) {
                        udv = d;
                    } if (d.getEndDate().after(udv.getEndDate())) {
                        udv = d;
                    }
                } if (pas == null) {
                    pas = d;
                } if (d.getEndDate().after(pas.getEndDate())) {
                    pas = d;
                }
            }
        }


        if (udv == null && pas == null) {
            return new ListOfDocument();
        }

        if (udv == null) {
            return pas;
        }
        return udv;
    }
}
