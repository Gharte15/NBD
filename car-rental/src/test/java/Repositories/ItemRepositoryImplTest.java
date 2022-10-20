package Repositories;

import Model.Music;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryImplTest {
    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static ItemRepositoryImpl ir;

    @BeforeAll
    static void beforeAll() {
        emf = Persistence.createEntityManagerFactory("POSTGRES_RENT_PU");
        em = emf.createEntityManager();
        ir = new ItemRepositoryImpl(em);
    }

    @Test
    void addItem() {
        Music m = new Music("test", "test", "test", 20, "title", "album", "duration");
        ir.addItem(m);
        assertEquals(m, ir.getItemById(m.getId()));
    }

    @Test
    void deleteItem() {
        Music m = new Music("test", "test", "test", 20, "title", "album", "duration");
        ir.addItem(m);
        ir.deleteItem(m);
        assertNull(ir.getItemById(m.getId()));
    }
}