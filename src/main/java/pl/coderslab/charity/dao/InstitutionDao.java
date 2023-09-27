package pl.coderslab.charity.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.charity.entity.Institution;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class InstitutionDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Institution> findAll() {
        return entityManager.createQuery("SELECT a FROM Institution a")
                .getResultList();
    }
}
