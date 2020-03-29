package by.resliv.citymanagement.controller;

import by.resliv.citymanagement.entity.City;
import by.resliv.citymanagement.exception.ServiceException;
import by.resliv.citymanagement.service.CityServiceInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/city")
public class CityController implements CityControllerInterface {
    private static final Logger logger;

    static {
        logger = LogManager.getLogger();
    }

    @Autowired
    private CityServiceInterface service;

    @Override
    @PostMapping(value = "/",
            produces = PRODUCES,
            consumes = CONSUMES)
    public ResponseEntity<City> create(@RequestBody City city) {
        HttpStatus status = HttpStatus.CREATED;
        City result;
        try {
            result = service.create(city);
        } catch (ServiceException e) {
            logger.error(e);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            result = new City();
        }
        return new ResponseEntity<>(result, status);
    }

    @Override
    @GetMapping(value = "/{value}",
            produces = PRODUCES,
            consumes = CONSUMES)
    public ResponseEntity<City> read(@PathVariable("value") String value) {
        HttpStatus status = HttpStatus.OK;
        City city;
        try {
            city = service.read(value);
        } catch (ServiceException e) {
            logger.error(e);
            status = HttpStatus.BAD_REQUEST;
            city = new City();
        }
        return new ResponseEntity<>(city, status);
    }

    @Override
    @PutMapping(value = "/{id}",
            produces = PRODUCES,
            consumes = CONSUMES)
    public ResponseEntity<City> update(@RequestBody City city, @PathVariable("id") long id) {
        HttpStatus status = HttpStatus.OK;
        City result;
        try {
            city.setId(id);
            result = service.update(city);
        } catch (ServiceException e) {
            logger.error(e);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            result = city;
        }
        return new ResponseEntity<>(result, status);
    }

    @Override
    @DeleteMapping(value = "/{id}",
            produces = PRODUCES,
            consumes = CONSUMES)
    public ResponseEntity<City> delete(@PathVariable("id") long id) {
        HttpStatus status = HttpStatus.OK;
        City city;
        try {
            city = service.delete(id);
        } catch (ServiceException e) {
            logger.error(e);
            status = HttpStatus.NOT_FOUND;
            city = new City();
        }
        return new ResponseEntity<>(city, status);
    }
}
