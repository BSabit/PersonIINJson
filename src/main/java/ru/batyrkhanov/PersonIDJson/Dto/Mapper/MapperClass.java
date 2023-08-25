//package ru.batyrkhanov.PersonIDJson.Mapper;
//
//import ru.batyrkhanov.PersonIDJson.Controller.PersonController;
//import ru.batyrkhanov.PersonIDJson.Dto.ExampleDTO;
//import ru.batyrkhanov.PersonIDJson.Model.ExampleModel;
//import ru.batyrkhanov.PersonIDJson.Model.ListOfDocument;
//
//public class MapperClass {
//
//
//    public ExampleDTO modelToDTO(ExampleModel exampleModel) {
//
//        if ( exampleModel == null ) {
//            return null;
//        }
//        PersonController personController = new PersonController();
//        ListOfDocument listOfDocument = personController.personIIN(exampleModel);
//
//        ExampleDTO exampleDTO = new ExampleDTO();
//        exampleDTO.setFirstName(exampleModel.getFirstName());
//        exampleDTO.setLastName(exampleModel.getSurname());
//        exampleDTO.setFatherName(exampleModel.getPatronymic());
//        if(exampleModel.getGender().getCode().equals("1")) {
//            exampleDTO.setGender("MALE");
//        } else {
//            exampleDTO.setGender("FAMALE");
//
//        }
//        exampleDTO.setBirthDate( exampleModel.getBirthDate() );
//        if (exampleModel.getCitizenship().getCode().equals("398")) {
//            exampleDTO.setIsResident("true");
//        } else {
//            exampleDTO.setIsResident("false");
//        }
//        exampleDTO.setIin( exampleModel.getIin() );
//        exampleDTO.setMobilePhone(null);
//        exampleDTO.setBirthPlace(exampleModel.getBirthPlace().getCountry().getNameRu() + ", " +
//                exampleModel.getBirthPlace().getDistrict().getNameRu() + ", " +
//                exampleModel.getBirthPlace().getRegion().getNameRu() + ", " +
//                exampleModel.getBirthPlace().getCity());
//        exampleDTO.setAddressCity(exampleModel.getRegAddress().getRegion().getNameRu());
//        exampleDTO.setAddressPlace(exampleModel.getRegAddress().getStreet());
//        exampleDTO.setAddressHouseNo(exampleModel.getRegAddress().getBuilding());
//        exampleDTO.setAddressAptNo(exampleModel.getRegAddress().getFlat());
//        exampleDTO.setAddressTitle(exampleModel.getRegAddress().getRegion().getNameRu() + ", " +
//                exampleModel.getRegAddress().getStreet() + ", " +
//                exampleModel.getRegAddress().getBuilding() + ", " +
//                exampleModel.getRegAddress().getFlat());
//        if (exampleModel.getCitizenship().getCode().equals("398")){
//            exampleDTO.setIsCitizenship("true");
//        } else {
//            exampleDTO.setIsCitizenship("false");
//        }
//        exampleDTO.setPaperTitle(listOfDocument.getType().getNameRu());
//        if (listOfDocument.getType().getNameRu().equals("УДОСТОВЕРЕНИЕ РК")) {
//            exampleDTO.setPaperType("IDEN");
//        } else {
//            exampleDTO.setPaperType("PASS");
//        }
//        exampleDTO.setPaperIssueDate(listOfDocument.getBeginDate());
//        exampleDTO.setPaperValidityDate(listOfDocument.getEndDate());
//        exampleDTO.setPaperIssuer(listOfDocument.getIssueOrganization().getNameRu());
//        exampleDTO.setPaperNumber(listOfDocument.getNumber());
//        exampleDTO.setPaperStatus("APPR");
//        exampleDTO.setPaperBSystem("SMBK");
//        exampleDTO.setRegisteredBy("Зарегистрирован в SmartBank 3.0");
//        exampleDTO.setRegChannelId("WEBB");
//
//
//        return exampleDTO;
//    }
//}
