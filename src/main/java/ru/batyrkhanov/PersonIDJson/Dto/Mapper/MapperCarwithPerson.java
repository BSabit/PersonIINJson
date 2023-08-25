package ru.batyrkhanov.PersonIDJson.Dto.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.batyrkhanov.PersonIDJson.Dto.CarwithPersonDto;
import ru.batyrkhanov.PersonIDJson.Model.Car;
import ru.batyrkhanov.PersonIDJson.Model.Person;

@Mapper
public interface MapperCarwithPerson {

    MapperCarwithPerson INSTANCE = Mappers.getMapper(MapperCarwithPerson.class);



    @Mapping(target = "color", source = "car.color")
    @Mapping(target = "model", source = "car.model")
    @Mapping(target = "year", source = "car.year")
    @Mapping(target = "name", source = "person.name")
    @Mapping(target = "surName", source = "person.surName")
    @Mapping(target = "age", source = "person.age")
    CarwithPersonDto toDto(Car car, Person person);
}
