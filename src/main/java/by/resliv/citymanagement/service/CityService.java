package by.resliv.citymanagement.service;

import by.resliv.citymanagement.dao.CityDaoInterface;
import by.resliv.citymanagement.entity.City;
import by.resliv.citymanagement.exception.DaoException;
import by.resliv.citymanagement.exception.ServiceException;
import by.resliv.citymanagement.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CityService implements CityServiceInterface {
    @Autowired
    @Qualifier("nameValidator")
    private Validator nameValidator;
    @Autowired
    @Qualifier("numberValidator")
    private Validator numberValidator;
    @Autowired
    @Qualifier("informationValidator")
    private Validator informationValidator;
    @Autowired
    private CityDaoInterface dao;

    @Override
    public City create(City city) throws ServiceException {
        City result;
        try {
            City copy = validate(city);
            result = dao.create(copy);
        } catch (DaoException | CloneNotSupportedException e) {
            throw new ServiceException(e);
        }
        return result;
    }

    @Override
    public City read(String value) throws ServiceException {
        value = value.trim();
        City city;
        try {
            if (numberValidator.validate(value)) {
                long id = Long.valueOf(value);
                city = dao.read(id);
            } else {
                if (!nameValidator.validate(value)) {
                    throw new ServiceException("value " + value + " has invalid value.");
                }
                city = dao.read(value);
            }
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return city;
    }

    @Override
    public City update(City city) throws ServiceException {
        City result;
        try {
            City copy = validate(city);
            result = dao.update(copy);
        } catch (DaoException | CloneNotSupportedException e) {
            throw new ServiceException(e);
        }
        return result;
    }

    @Override
    public City delete(long id) throws ServiceException {
        City city;
        try {
            city = dao.delete(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return city;
    }

    private City validate(City city) throws ServiceException, CloneNotSupportedException {
        String name = city.getName().trim();
        if (!nameValidator.validate(name)) {
            throw new ServiceException("name " + name + " has invalid value.");
        }
        String information = city.getInformation().trim();
        if (!informationValidator.validate(information)) {
            throw new ServiceException("information " + information.substring(1, 20) + " has invalid value.");
        }
        City result = city.clone();
        result.setName(name);
        result.setInformation(information);
        return result;
    }
}
