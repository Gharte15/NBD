package Repositories;

import Model.Item;
import jakarta.persistence.EntityManager;

public class ItemRepository {
    private EntityManager em;

    public ItemRepository(EntityManager em) {
        this.em = em;
    }

    public Item getItemById(Long id) {
        return em.find(Item.class, id);
    }

    public Item addItem(Item i) {
        if (i.getId() == null) {
            em.persist(i);
        } else {
            em.merge(i);
        }
        return i;
    }

    public void deleteItem(Item i) {
        if (em.contains(i)) {
            em.remove(i);
        } else {
            em.merge(i);
        }
    }
}