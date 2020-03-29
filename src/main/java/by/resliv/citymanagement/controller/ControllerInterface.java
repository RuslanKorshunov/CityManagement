package by.resliv.citymanagement.controller;

import org.springframework.http.ResponseEntity;

public interface ControllerInterface<T> {
    String PRODUCES = "application/json";
    String CONSUMES = PRODUCES;

    ResponseEntity<T> create(T t);

    ResponseEntity<T> update(T t, long id);

    ResponseEntity<T> delete(long id);
}
