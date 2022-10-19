package Repositories;

import Model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.From;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

class DBTest {
    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static ClientRepository cr;

    @BeforeAll
    static void beforeAll() {
        emf = Persistence.createEntityManagerFactory("POSTGRES_RENT_PU");
        em = emf.createEntityManager();
        cr = new ClientRepositoryImpl(em);
    }

    @AfterAll
    static void afterAll() {
        if (emf != null) {
            emf.close();
        }
    }

    @Test
    void testConnectivity() {
        Client client = em.find(Client.class, Long.valueOf(1));
        assertThat(client, is(nullValue()));
    }

    @Test
    void insertAndSelectItem() {
        // Item item = new Music("AUTOR", "20-02-21", "HIP HOP", 15, "TYTUL", "ALBUM", "3:46");
        // EntityTransaction transaction = em.getTransaction();
        // transaction.begin();
        // em.persist(item);
        // transaction.commit();
        //
        // CriteriaBuilder cb = em.getCriteriaBuilder();
        // CriteriaQuery<Item> query = cb.createQuery(Item.class);
        // From<Item, Item> from = query.from(Item.class);
        // query.select(from).where(cb.equal(from.get(Item_.ID), "1"));
        // Item found = em.createQuery(query).getSingleResult();
        // assertThat("1", is(found.getId()));
        // System.out.println(found);
    }
}