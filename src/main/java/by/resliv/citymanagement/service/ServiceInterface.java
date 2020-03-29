package by.resliv.citymanagement.service;

import by.resliv.citymanagement.exception.ServiceException;

public interface ServiceInterface<T> {
    T create(T t) throws ServiceException;

    T update(T t) throws ServiceException;

    T delete(long id) throws ServiceException;
}
