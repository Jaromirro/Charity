package pl.coderslab.charity.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Donation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class CategoryDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Category> findAll() {
        return entityManager.createQuery("SELECT a FROM Category a")
                .getResultList();
    }


}
