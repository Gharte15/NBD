package Managers;

import Model.*;
import Repositories.RentRepositoryImpl;
import jakarta.persistence.*;

import java.time.LocalDateTime;

public class RentManager {
    private RentRepositoryImpl archiveRents;
    private RentRepositoryImpl currentRents;
    private EntityManager em;

    public RentManager(EntityManager em) {
        this.em = em;
        this.archiveRents = new RentRepositoryImpl(em);
        this.currentRents = new RentRepositoryImpl(em);
    }

    public Rent rentItem(Client c, Item i) {
        if (c.getCurrentRents() < c.getMaxItems()) {
            if (i.isOnlyForAdults() && !c.isAdult()) {
                return null;
            }
            Rent rent = new Rent(c, i);

            if (!i.isRented()) {
                currentRents.addRent(rent);
                c.setCurrentRents(c.getCurrentRents() + 1);
                return rent;
            }
        }
        return null;
    }

    public void returnItem(Item item) {
        Rent rent = getItemRent(item);

        if (rent != null) {
            rent.endRent(LocalDateTime.now());
            currentRents.deleteRent(rent);
            archiveRents.addRent(rent);
        }
    }

    public Rent getItemRent(Item item) {
        TypedQuery<Rent> q = em.createQuery("SELECT r FROM Rent r WHERE r.item = : item", Rent.class);
        em.getTransaction().commit();
        return q.getSingleResult();
    }
}
