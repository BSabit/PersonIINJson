package ru.batyrkhanov.PersonIDJson.Controller;

import jakarta.transaction.Status;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.batyrkhanov.PersonIDJson.Model.Example;
import ru.batyrkhanov.PersonIDJson.Model.GenericClass;
import ru.batyrkhanov.PersonIDJson.Model.ListOfDocument;


import java.util.List;


@RestController
@RequestMapping("/people")
public class PersonController {

    @PostMapping
    public GenericClass personIIN(@RequestBody Example example) {
        List<ListOfDocument> listDoc = example.getDocuments().getListOfDocuments();
        for (ListOfDocument d : listDoc) {
            if (d.getType().getNameRu().equals("УДОСТОВЕРЕНИЕ РК")) {
                if (d.getStatus().getNameRu().equals("ДОКУМЕНТ ДЕЙСТВИТЕЛЕН")) {
                    return d.getType();
                }}}

        for(ListOfDocument d : listDoc) {
            if (d.getType().getNameRu().equals("ПАСПОРТ РК")) {
                if (d.getStatus().getNameRu().equals("ДОКУМЕНТ ДЕЙСТВИТЕЛЕН")) {
                    return d.getType();
                }
            }
        }
        return new GenericClass();
    }
}
