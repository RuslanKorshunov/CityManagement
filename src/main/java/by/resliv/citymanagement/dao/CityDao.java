package by.resliv.citymanagement.dao;

import by.resliv.citymanagement.entity.City;
import by.resliv.citymanagement.exception.DaoException;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;

@Repository
public class CityDao implements CityDaoInterface {
    private static final String NAME;
    private static final String ID;
    private static final String INFORMATION;

    static {
        NAME = "name";
        ID = "id";
        INFORMATION = "information";
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public City read(String name) throws DaoException {
        return read(NAME, name);
    }

    @Override
    public City read(long id) throws DaoException {
        return read(ID, id);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,
            rollbackFor = DaoException.class)
    @Modifying
    public City update(City city) throws DaoException {
        try {
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaUpdate<City> update = builder.createCriteriaUpdate(City.class);
            Root<City> root = update.from(City.class);
            update.set(NAME, city.getName());
            update.set(INFORMATION, city.getInformation());
            update.where(builder.equal(root.get(ID), city.getId()));
            int result = entityManager.createQuery(update).executeUpdate();
            if (result == 0) {
                throw new DaoException("city " + city.getName() + " wasn't updated.");
            }
        } catch (Exception e) {
            throw new DaoException(e);
        }
        return city;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,
            rollbackFor = DaoException.class)
    @Modifying
    public City delete(long id) throws DaoException {
        City city = read(ID, id);
        try {
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaDelete<City> delete = builder.createCriteriaDelete(City.class);
            Root<City> root = delete.from(City.class);
            delete.where(builder.equal(root.get(ID), id));
            int result = entityManager.createQuery(delete).executeUpdate();
            if (result == 0) {
                throw new DaoException("city " + city.getName() + " wasn't deleted.");
            }
        } catch (Exception e) {
            throw new DaoException(e);
        }
        return city;
    }

    private City read(String parameter, Object value) throws DaoException {
        City city;
        try {
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<City> query = builder.createQuery(City.class);
            Root<City> root = query.from(City.class);
            query.select(root);
            query.where(builder.equal(root.get(parameter), value));
            city = entityManager.createQuery(query).getSingleResult();
        } catch (Exception e) {
            throw new DaoException(e);
        }
        return city;
    }
}
