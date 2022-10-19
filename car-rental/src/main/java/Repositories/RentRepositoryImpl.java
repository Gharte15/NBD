package Repositories;

import Model.Rent;
import jakarta.persistence.EntityManager;

public class RentRepositoryImpl {
    private EntityManager em;

    public RentRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    public Rent getRentById(Long id) {
        return em.find(Rent.class, id);
    }

    public Rent addRent(Rent r) {
        if (r.getId() == null) {
            em.persist(r);
        } else {
            em.merge(r);
        }
        return r;
    }
}
