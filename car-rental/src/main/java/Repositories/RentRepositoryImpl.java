package Repositories;

import Model.Client;
import Model.Rent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;

public class RentRepositoryImpl {
    private EntityManager em;

    public RentRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    public Rent getRentById(Long id) {
        return em.find(Rent.class, id);
    }

    public Rent addRent(Rent r) {
        em.getTransaction().begin();
        if (r.getId() == null) {
            em.persist(r);
        } else {
            em.merge(r);
        }
        em.getTransaction().commit();
        return r;

    }

    public void deleteRent(Rent r) {
        em.getTransaction().begin();
        if (em.contains(r)) {
            em.remove(r);
        } else {
            em.merge(r);
        }
        r.getItem().setRented(false);
        em.getTransaction().commit();
    }
}
