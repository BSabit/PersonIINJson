package ru.batyrkhanov.PersonIDJson.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.batyrkhanov.PersonIDJson.Model.Example;
import ru.batyrkhanov.PersonIDJson.Model.GenericClass;
import ru.batyrkhanov.PersonIDJson.Model.ListOfDocument;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


@RestController
@RequestMapping("/people")
public class PersonController {

    @PostMapping
    public ListOfDocument personIIN(@RequestBody Example example) {
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
}
