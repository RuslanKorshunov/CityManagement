package by.resliv.citymanagement.dao;

import by.resliv.citymanagement.entity.City;
import by.resliv.citymanagement.exception.DaoException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class CityDao implements CityDaoInterface {
    private static final String NAME;

    static {
        NAME = "name";
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public City read(String name) throws DaoException {
        City city;
        try {
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<City> query = builder.createQuery(City.class);
            Root<City> root = query.from(City.class);
            query.select(root);
            query.where(builder.equal(root.get(NAME), name));
            city = entityManager.createQuery(query).getSingleResult();
        } catch (Exception e) {
            throw new DaoException(e);
        }
        return city;
    }
}
