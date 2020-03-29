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
    private Validator validator;
    @Autowired
    private CityDaoInterface dao;

    @Override
    public City read(String name) throws ServiceException {
        name = name.trim();
        if (!validator.validate(name)) {
            throw new ServiceException("name " + name + " has invalid value.");
        }
        City city;
        try {
            city = dao.readByName(name);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return city;
    }
}
