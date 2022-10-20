package Repositories;

import Model.Item;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;

public class ItemRepositoryImpl implements ItemRepository {
    private EntityManager em;

    public ItemRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    public Item getItemById(Long id) {
        return em.find(Item.class, id);
    }

    public Item addItem(Item i) {
        em.getTransaction().begin();
        if (i.getId() == null) {
            em.persist(i);
        } else {
            em.merge(i);
        }
        em.getTransaction().commit();
        return i;
    }

    public void deleteItem(Item i) {
        em.getTransaction().begin();
        if (em.contains(i)) {
            em.remove(i);
        } else {
            em.merge(i);
        }
        em.getTransaction().commit();

    }
}
