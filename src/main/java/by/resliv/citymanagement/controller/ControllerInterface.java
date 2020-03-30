package by.resliv.citymanagement.controller;

import by.resliv.citymanagement.entity.City;
import org.springframework.http.ResponseEntity;

public interface ControllerInterface<T> {
    String PRODUCES = "application/json";
    String CONSUMES = PRODUCES;

    ResponseEntity<T> create(T t);

    ResponseEntity<City> read(String value);

    ResponseEntity<T> update(T t, long id);

    ResponseEntity<T> delete(long id);
}
