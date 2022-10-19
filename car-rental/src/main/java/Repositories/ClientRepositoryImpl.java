package Repositories;

import Model.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class ClientRepositoryImpl implements ClientRepository {
    private EntityManager em;

    public ClientRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    public Client getClientById(Long id) {
        return em.find(Client.class, id);
    }

    public Client getClientByPersonalId(String personalId) {
        TypedQuery<Client> q = em.createQuery("SELECT c FROM Client c WHERE c.personalID = : personalId", Client.class);
        q.setParameter("personalId", personalId);
        return q.getSingleResult();
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
