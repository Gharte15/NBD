package Repositories;

import Model.Client;
import jakarta.persistence.EntityManager;

public class ClientRepository {
    private EntityManager em;

    public ClientRepository(EntityManager em) {
        this.em = em;
    }

    public Client getClientById(Long id) {
        return em.find(Client.class, id);
    }

    public Client addClient(Client c) {
        if (c.getId() == null) {
            em.persist(c);
        } else {
            em.merge(c);
        }
        return c;
    }

    public void deleteClient(Client c) {
        if (em.contains(c)) {
            em.remove(c);
        } else {
            em.merge(c);
        }
    }
}
