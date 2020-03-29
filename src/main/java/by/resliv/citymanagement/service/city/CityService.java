package by.resliv.citymanagement.service.city;

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
    private CityDaoInterface dao;

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
}
