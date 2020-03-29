package by.resliv.citymanagement.service.city;

import by.resliv.citymanagement.exception.ServiceException;

public interface ServiceInterface<T> {
    T delete(long id) throws ServiceException;
}
