package by.resliv.citymanagement.controller;

import by.resliv.citymanagement.entity.City;
import org.springframework.http.ResponseEntity;

public interface CityControllerInterface extends ControllerInterface<City> {
    ResponseEntity<City> read(String value);
}
