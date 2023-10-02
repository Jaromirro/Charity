package pl.coderslab.charity.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class DonationDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Donation> findAll() {
        return entityManager.createQuery("SELECT a FROM Donation a")
                .getResultList();
    }
    public void save(Donation donation) {
        entityManager.persist(donation);
    }
}
