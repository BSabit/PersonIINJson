package ru.batyrkhanov.PersonIDJson.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.bind.annotation.*;
import ru.batyrkhanov.PersonIDJson.Dto.ExampleDTO;

import ru.batyrkhanov.PersonIDJson.Mapper.MapperExample;
import ru.batyrkhanov.PersonIDJson.Model.*;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/people")
public class PersonController {

    List<ExampleModel> listDB = new ArrayList<>();


    @PostMapping
    public ListOfDocument personIIN( ExampleModel example) {
        List<ListOfDocument> listDoc = example.getDocuments().getListOfDocuments();
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

    @PostMapping("/{id}")
    public ExampleDTO personDTO(@PathVariable("id") String iin) {

        String user = db(iin);
        ObjectMapper mapper = new ObjectMapper();
        ExampleModel example = null;
        try {
            example = mapper.readValue(user, ExampleModel.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

//         MapperClass mapper = new MapperClass();
//         return mapper.modelToDTO(example);
//
//        return MapperBirthPlace.INSTANCE.placeToDto(example);
        return MapperExample.INSTANCE.modelToDTO(example);
    }





    Map<String, String> personIIN = new HashMap<String, String>();
    public String db(String iin) {


        personIIN.put("990507400700", "{\"iin\":\"990507400700\",\"firstName\":\"АРУЖАН\",\"surname\":\"ДУЛАТҚЫЗЫ\",\"patronymic\":null,\"engFirstName\":\"ARUZHAN\",\"engSurname\":\"DULATKYZY\",\"birthDate\":\"1999-05-07T00:00:00\",\"gender\":{\"code\":\"2\",\"nameRu\":\"Женский\",\"nameKz\":\"Әйел\",\"changeDate\":\"2013-05-17T17:29:19+06:00\"},\"nationality\":{\"code\":\"005\",\"nameRu\":\"КАЗАШКА\",\"nameKz\":\"ҚАЗАҚ\",\"changeDate\":\"2008-03-01T13:21:45+06:00\"},\"citizenship\":{\"code\":\"398\",\"nameRu\":\"КАЗАХСТАН\",\"nameKz\":\"ҚАЗАҚСТАН\",\"changeDate\":\"2008-03-01T13:21:44+06:00\"},\"lifeStatus\":{\"code\":\"0\",\"nameRu\":\"Нормальный\",\"nameKz\":\"Қалыпты\",\"changeDate\":\"2008-03-01T13:21:45+06:00\"},\"birthPlace\":{\"country\":{\"code\":\"398\",\"nameRu\":\"КАЗАХСТАН\",\"nameKz\":\"ҚАЗАҚСТАН\",\"changeDate\":\"2008-03-01T13:21:44+06:00\"},\"district\":{\"code\":\"1919\",\"nameRu\":\"ЖАМБЫЛСКАЯ\",\"nameKz\":\"ЖАМБЫЛ\",\"changeDate\":\"2008-03-01T13:21:45+06:00\"},\"region\":{\"code\":\"1919401\",\"nameRu\":\"ТАРАЗ\",\"nameKz\":\"ТАРАЗ\",\"changeDate\":\"2008-03-01T13:21:45+06:00\"},\"city\":\"-\"},\"regAddress\":{\"country\":{\"code\":\"398\",\"nameRu\":\"КАЗАХСТАН\",\"nameKz\":\"ҚАЗАҚСТАН\",\"changeDate\":\"2008-03-01T13:21:44+06:00\"},\"district\":{\"code\":\"1919\",\"nameRu\":\"ЖАМБЫЛСКАЯ\",\"nameKz\":\"ЖАМБЫЛ\",\"changeDate\":\"2008-03-01T13:21:45+06:00\"},\"region\":{\"code\":\"1919401\",\"nameRu\":\"ТАРАЗ\",\"nameKz\":\"ТАРАЗ\",\"changeDate\":\"2008-03-01T13:21:45+06:00\"},\"street\":\"УЛИЦА Каныша Сатбаева\",\"building\":\"13\",\"flat\":\"24\",\"beginDate\":\"2007-02-28T00:00:00\",\"status\":{\"code\":\"1\",\"nameRu\":\"Зарегистрирован\",\"nameKz\":\"Тіркелді\",\"changeDate\":\"2013-11-29T22:36:46+06:00\"},\"invalidity\":{\"code\":\"0\",\"nameRu\":\"Зарегистрирован\",\"nameKz\":\"Тіркелді\",\"changeDate\":\"2013-11-29T22:36:46+06:00\"},\"arCode\":\"1201400013223454\"},\"documents\":{\"listOfDocuments\":[{\"type\":{\"code\":\"001\",\"nameRu\":\"ПАСПОРТ РК\",\"nameKz\":\"ҚР ПАСПОРТЫ\",\"changeDate\":\"2008-03-01T13:21:45+06:00\"},\"number\":\"N14168384\",\"beginDate\":\"2022-02-03T00:00:00\",\"endDate\":\"2032-02-02T00:00:00\",\"issueOrganization\":{\"code\":\"002\",\"nameRu\":\"МИНИСТЕРСТВО ВНУТРЕННИХ ДЕЛ РК\",\"nameKz\":\"ҚР ІШКІ ІСТЕР МИНИСТРЛІГІ\",\"changeDate\":\"2008-03-01T13:21:45+06:00\"},\"status\":{\"code\":\"00\",\"nameRu\":\"ДОКУМЕНТ ДЕЙСТВИТЕЛЕН\",\"nameKz\":\"ҚҰЖАТ ЖАРАМДЫ\",\"changeDate\":\"2008-03-01T13:21:45+06:00\"},\"firstName\":\"АРУЖАН\",\"surname\":\"ДУЛАТҚЫЗЫ\",\"patronymic\":null,\"birthDate\":\"1999-05-07T00:00:00\"},{\"type\":{\"code\":\"002\",\"nameRu\":\"УДОСТОВЕРЕНИЕ РК\",\"nameKz\":\"ҚР ЖЕКЕ КУӘЛІГІ\",\"changeDate\":\"2008-03-01T13:21:45+06:00\"},\"number\":\"038031305\",\"beginDate\":\"2015-06-08T00:00:00\",\"endDate\":\"2025-06-07T00:00:00\",\"issueOrganization\":{\"code\":\"002\",\"nameRu\":\"МИНИСТЕРСТВО ВНУТРЕННИХ ДЕЛ РК\",\"nameKz\":\"ҚР ІШКІ ІСТЕР МИНИСТРЛІГІ\",\"changeDate\":\"2008-03-01T13:21:45+06:00\"},\"status\":{\"code\":\"00\",\"nameRu\":\"ДОКУМЕНТ ДЕЙСТВИТЕЛЕН\",\"nameKz\":\"ҚҰЖАТ ЖАРАМДЫ\",\"changeDate\":\"2008-03-01T13:21:45+06:00\"},\"firstName\":\"АРУЖАН\",\"surname\":\"ДУЛАТҚЫЗЫ\",\"patronymic\":null,\"birthDate\":\"1999-05-07T00:00:00\"}]}}");
        personIIN.put("941118401123", "{\"iin\":\"941118401123\",\"firstName\":\"САЛТАНАТ\",\"surname\":\"АБДУЛЛАХАН\",\"patronymic\":\"АСЫЛХАНКЫЗЫ\",\"engFirstName\":\"SALTANAT\",\"engSurname\":\"ABDULLAKHAN\",\"birthDate\":\"1994-11-18T00:00:00\",\"gender\":{\"code\":\"2\",\"nameRu\":\"Женский\",\"nameKz\":\"Әйел\",\"changeDate\":\"2013-05-17T17:29:19+06:00\"},\"nationality\":{\"code\":\"005\",\"nameRu\":\"КАЗАШКА\",\"nameKz\":\"ҚАЗАҚ\",\"changeDate\":\"2008-03-01T13:21:45+06:00\"},\"citizenship\":{\"code\":\"398\",\"nameRu\":\"КАЗАХСТАН\",\"nameKz\":\"ҚАЗАҚСТАН\",\"changeDate\":\"2008-03-01T13:21:44+06:00\"},\"lifeStatus\":{\"code\":\"0\",\"nameRu\":\"Нормальный\",\"nameKz\":\"Қалыпты\",\"changeDate\":\"2008-03-01T13:21:45+06:00\"},\"birthPlace\":{\"country\":{\"code\":\"398\",\"nameRu\":\"КАЗАХСТАН\",\"nameKz\":\"ҚАЗАҚСТАН\",\"changeDate\":\"2008-03-01T13:21:44+06:00\"},\"district\":{\"code\":\"1933\",\"nameRu\":\"КЫЗЫЛОРДИНСКАЯ\",\"nameKz\":\"ҚЫЗЫЛОРДА\",\"changeDate\":\"2013-10-08T15:30:33+06:00\"},\"region\":{\"code\":\"1933238\",\"nameRu\":\"ЖАНАКОРГАНСКИЙ Р-Н\",\"nameKz\":\"ЖАҢАҚОРҒАН АУДАНЫ\",\"changeDate\":\"2008-03-01T13:21:45+06:00\"},\"city\":\"-\"},\"regAddress\":{\"country\":{\"code\":\"398\",\"nameRu\":\"КАЗАХСТАН\",\"nameKz\":\"ҚАЗАҚСТАН\",\"changeDate\":\"2008-03-01T13:21:44+06:00\"},\"district\":{\"code\":\"1910\",\"nameRu\":\"АЛМАТЫ\",\"nameKz\":\"АЛМАТЫ\",\"changeDate\":\"2008-03-01T13:21:45+06:00\"},\"region\":{\"code\":\"1910274\",\"nameRu\":\"АЛМАЛИНСКИЙ\",\"nameKz\":\"АЛМАЛЫ\",\"changeDate\":\"2008-03-01T13:21:45+06:00\"},\"street\":\"УЛИЦА Тургут Озала\",\"building\":\"128\",\"flat\":null,\"beginDate\":\"2011-06-13T00:00:00\",\"status\":{\"code\":\"1\",\"nameRu\":\"Зарегистрирован\",\"nameKz\":\"Тіркелді\",\"changeDate\":\"2013-11-29T22:36:46+06:00\"},\"invalidity\":{\"code\":\"0\",\"nameRu\":\"Зарегистрирован\",\"nameKz\":\"Тіркелді\",\"changeDate\":\"2013-11-29T22:36:46+06:00\"},\"arCode\":\"0201300121037302\"},\"documents\":{\"listOfDocuments\":[{\"type\":{\"code\":\"001\",\"nameRu\":\"ПАСПОРТ РК\",\"nameKz\":\"ҚР ПАСПОРТЫ\",\"changeDate\":\"2008-03-01T13:21:45+06:00\"},\"number\":\"N13682698\",\"beginDate\":\"2021-05-05T00:00:00\",\"endDate\":\"2031-05-04T00:00:00\",\"issueOrganization\":{\"code\":\"002\",\"nameRu\":\"МИНИСТЕРСТВО ВНУТРЕННИХ ДЕЛ РК\",\"nameKz\":\"ҚР ІШКІ ІСТЕР МИНИСТРЛІГІ\",\"changeDate\":\"2008-03-01T13:21:45+06:00\"},\"status\":{\"code\":\"00\",\"nameRu\":\"ДОКУМЕНТ ДЕЙСТВИТЕЛЕН\",\"nameKz\":\"ҚҰЖАТ ЖАРАМДЫ\",\"changeDate\":\"2008-03-01T13:21:45+06:00\"},\"firstName\":\"САЛТАНАТ\",\"surname\":\"АБДУЛЛАХАН\",\"patronymic\":\"АСЫЛХАНКЫЗЫ\",\"birthDate\":\"1994-11-18T00:00:00\"},{\"type\":{\"code\":\"002\",\"nameRu\":\"УДОСТОВЕРЕНИЕ РК\",\"nameKz\":\"ҚР ЖЕКЕ КУӘЛІГІ\",\"changeDate\":\"2008-03-01T13:21:45+06:00\"},\"number\":\"037393017\",\"beginDate\":\"2015-01-05T00:00:00\",\"endDate\":\"2025-01-04T00:00:00\",\"issueOrganization\":{\"code\":\"002\",\"nameRu\":\"МИНИСТЕРСТВО ВНУТРЕННИХ ДЕЛ РК\",\"nameKz\":\"ҚР ІШКІ ІСТЕР МИНИСТРЛІГІ\",\"changeDate\":\"2008-03-01T13:21:45+06:00\"},\"status\":{\"code\":\"00\",\"nameRu\":\"ДОКУМЕНТ ДЕЙСТВИТЕЛЕН\",\"nameKz\":\"ҚҰЖАТ ЖАРАМДЫ\",\"changeDate\":\"2008-03-01T13:21:45+06:00\"},\"firstName\":\"САЛТАНАТ\",\"surname\":\"АБДУЛЛАХАН\",\"patronymic\":\"АСЫЛХАНКЫЗЫ\",\"birthDate\":\"1994-11-18T00:00:00\"},{\"type\":{\"code\":\"001\",\"nameRu\":\"ПАСПОРТ РК\",\"nameKz\":\"ҚР ПАСПОРТЫ\",\"changeDate\":\"2008-03-01T13:21:45+06:00\"},\"number\":\"N07553284\",\"beginDate\":\"2011-06-29T00:00:00\",\"endDate\":\"2021-06-28T00:00:00\",\"issueOrganization\":{\"code\":\"001\",\"nameRu\":\"МИНИСТЕРСТВО ЮСТИЦИИ РК\",\"nameKz\":\"ҚР ӘДІЛЕТ МИНИСТРЛІГІ\",\"changeDate\":\"2008-03-01T13:21:45+06:00\"},\"status\":{\"code\":\"08\",\"nameRu\":\"УТРАТА ПАСПОРТА, УД. ЛИЧНОСТИ \",\"nameKz\":\"ПАСПОРТТЫҢ,ЖЕКЕ КУӘЛІКТІҢ ЖОҒАЛЫНУЫ\",\"changeDate\":\"2008-03-01T13:21:45+06:00\"},\"firstName\":\"САЛТАНАТ\",\"surname\":\"АБДУЛЛАХАН\",\"patronymic\":\"АСЫЛХАНКЫЗЫ\",\"birthDate\":\"1994-11-18T00:00:00\"},{\"type\":{\"code\":\"002\",\"nameRu\":\"УДОСТОВЕРЕНИЕ РК\",\"nameKz\":\"ҚР ЖЕКЕ КУӘЛІГІ\",\"changeDate\":\"2008-03-01T13:21:45+06:00\"},\"number\":\"031791127\",\"beginDate\":\"2011-06-29T00:00:00\",\"endDate\":\"2021-06-28T00:00:00\",\"issueOrganization\":{\"code\":\"001\",\"nameRu\":\"МИНИСТЕРСТВО ЮСТИЦИИ РК\",\"nameKz\":\"ҚР ӘДІЛЕТ МИНИСТРЛІГІ\",\"changeDate\":\"2008-03-01T13:21:45+06:00\"},\"status\":{\"code\":\"08\",\"nameRu\":\"УТРАТА ПАСПОРТА, УД. ЛИЧНОСТИ \",\"nameKz\":\"ПАСПОРТТЫҢ,ЖЕКЕ КУӘЛІКТІҢ ЖОҒАЛЫНУЫ\",\"changeDate\":\"2008-03-01T13:21:45+06:00\"},\"firstName\":\"САЛТАНАТ\",\"surname\":\"АБДУЛЛАХАН\",\"patronymic\":\"АСЫЛХАНКЫЗЫ\",\"birthDate\":\"1994-11-18T00:00:00\"}]}}");
        personIIN.put("970320300328", "{\"iin\":\"970320300328\",\"firstName\":\"БАТЫРХАН\",\"surname\":\"ТУРГАНБАЕВ\",\"patronymic\":\"РУСЛАНУЛЫ\",\"engFirstName\":\"BATYRKHAN\",\"engSurname\":\"TURGANBAYEV\",\"birthDate\":\"1997-03-20T00:00:00\",\"gender\":{\"code\":\"1\",\"nameRu\":\"Мужской\",\"nameKz\":\"Ер\",\"changeDate\":\"2008-03-01T13:21:45+06:00\"},\"nationality\":{\"code\":\"005\",\"nameRu\":\"КАЗАХ\",\"nameKz\":\"ҚАЗАҚ\",\"changeDate\":\"2008-03-01T13:21:45+06:00\"},\"citizenship\":{\"code\":\"398\",\"nameRu\":\"КАЗАХСТАН\",\"nameKz\":\"ҚАЗАҚСТАН\",\"changeDate\":\"2008-03-01T13:21:44+06:00\"},\"lifeStatus\":{\"code\":\"0\",\"nameRu\":\"Нормальный\",\"nameKz\":\"Қалыпты\",\"changeDate\":\"2008-03-01T13:21:45+06:00\"},\"birthPlace\":{\"country\":{\"code\":\"398\",\"nameRu\":\"КАЗАХСТАН\",\"nameKz\":\"ҚАЗАҚСТАН\",\"changeDate\":\"2008-03-01T13:21:44+06:00\"},\"district\":{\"code\":\"1907\",\"nameRu\":\"АЛМАТИНСКАЯ\",\"nameKz\":\"АЛМАТЫ\",\"changeDate\":\"2008-03-01T13:21:45+06:00\"},\"region\":{\"code\":\"1907407\",\"nameRu\":\"ТАЛГАР\",\"nameKz\":\"ТАЛҒАР\",\"changeDate\":\"2008-03-01T13:21:45+06:00\"},\"city\":\"-\"},\"regAddress\":{\"country\":{\"code\":\"398\",\"nameRu\":\"КАЗАХСТАН\",\"nameKz\":\"ҚАЗАҚСТАН\",\"changeDate\":\"2008-03-01T13:21:44+06:00\"},\"district\":{\"code\":\"1910\",\"nameRu\":\"АЛМАТЫ\",\"nameKz\":\"АЛМАТЫ\",\"changeDate\":\"2008-03-01T13:21:45+06:00\"},\"region\":{\"code\":\"1910278\",\"nameRu\":\"МЕДЕУСКИЙ\",\"nameKz\":\"МЕДЕУ\",\"changeDate\":\"2008-03-01T13:21:45+06:00\"},\"street\":\"МИКРОРАЙОН Думан, УЛИЦА Бишкек\",\"building\":\"45\",\"flat\":null,\"beginDate\":\"2011-11-17T00:00:00\",\"status\":{\"code\":\"1\",\"nameRu\":\"Зарегистрирован\",\"nameKz\":\"Тіркелді\",\"changeDate\":\"2013-11-29T22:36:46+06:00\"},\"invalidity\":{\"code\":\"0\",\"nameRu\":\"Зарегистрирован\",\"nameKz\":\"Тіркелді\",\"changeDate\":\"2013-11-29T22:36:46+06:00\"},\"arCode\":\"0201300118490502\"},\"documents\":{\"listOfDocuments\":[{\"type\":{\"code\":\"002\",\"nameRu\":\"УДОСТОВЕРЕНИЕ РК\",\"nameKz\":\"ҚР ЖЕКЕ КУӘЛІГІ\",\"changeDate\":\"2008-03-01T13:21:45+06:00\"},\"number\":\"052843839\",\"beginDate\":\"2023-03-06T00:00:00\",\"endDate\":\"2033-03-05T00:00:00\",\"issueOrganization\":{\"code\":\"002\",\"nameRu\":\"МИНИСТЕРСТВО ВНУТРЕННИХ ДЕЛ РК\",\"nameKz\":\"ҚР ІШКІ ІСТЕР МИНИСТРЛІГІ\",\"changeDate\":\"2008-03-01T13:21:45+06:00\"},\"status\":{\"code\":\"00\",\"nameRu\":\"ДОКУМЕНТ ДЕЙСТВИТЕЛЕН\",\"nameKz\":\"ҚҰЖАТ ЖАРАМДЫ\",\"changeDate\":\"2008-03-01T13:21:45+06:00\"},\"firstName\":\"БАТЫРХАН\",\"surname\":\"ТУРГАНБАЕВ\",\"patronymic\":\"РУСЛАНУЛЫ\",\"birthDate\":\"1997-03-20T00:00:00\"},{\"type\":{\"code\":\"001\",\"nameRu\":\"ПАСПОРТ РК\",\"nameKz\":\"ҚР ПАСПОРТЫ\",\"changeDate\":\"2008-03-01T13:21:45+06:00\"},\"number\":\"N08645529\",\"beginDate\":\"2013-04-01T00:00:00\",\"endDate\":\"2023-03-31T00:00:00\",\"issueOrganization\":{\"code\":\"002\",\"nameRu\":\"МИНИСТЕРСТВО ВНУТРЕННИХ ДЕЛ РК\",\"nameKz\":\"ҚР ІШКІ ІСТЕР МИНИСТРЛІГІ\",\"changeDate\":\"2008-03-01T13:21:45+06:00\"},\"status\":{\"code\":\"10\",\"nameRu\":\"ПРОСРОЧЕННЫЕ ДОКУМЕНТЫ \",\"nameKz\":\"ЖАРАМДЫЛЫҚ МЕРЗІМІ ӨТІП КЕТКЕН ҚҰЖАТТАР\",\"changeDate\":\"2008-03-01T13:21:45+06:00\"},\"firstName\":\"БАТЫРХАН\",\"surname\":\"ТУРГАНБАЕВ\",\"patronymic\":\"РУСЛАНУЛЫ\",\"birthDate\":\"1997-03-20T00:00:00\"},{\"type\":{\"code\":\"002\",\"nameRu\":\"УДОСТОВЕРЕНИЕ РК\",\"nameKz\":\"ҚР ЖЕКЕ КУӘЛІГІ\",\"changeDate\":\"2008-03-01T13:21:45+06:00\"},\"number\":\"034529403\",\"beginDate\":\"2013-04-01T00:00:00\",\"endDate\":\"2023-03-31T00:00:00\",\"issueOrganization\":{\"code\":\"002\",\"nameRu\":\"МИНИСТЕРСТВО ВНУТРЕННИХ ДЕЛ РК\",\"nameKz\":\"ҚР ІШКІ ІСТЕР МИНИСТРЛІГІ\",\"changeDate\":\"2008-03-01T13:21:45+06:00\"},\"status\":{\"code\":\"10\",\"nameRu\":\"ПРОСРОЧЕННЫЕ ДОКУМЕНТЫ \",\"nameKz\":\"ЖАРАМДЫЛЫҚ МЕРЗІМІ ӨТІП КЕТКЕН ҚҰЖАТТАР\",\"changeDate\":\"2008-03-01T13:21:45+06:00\"},\"firstName\":\"БАТЫРХАН\",\"surname\":\"ТУРГАНБАЕВ\",\"patronymic\":\"РУСЛАНУЛЫ\",\"birthDate\":\"1997-03-20T00:00:00\"}]}}");

        return personIIN.get(iin);
    }



}
