package Repositories;

import Model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RentRepositoryImplTest {

    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static RentRepositoryImpl rr;
    private static ClientRepositoryImpl cr;
    private static ItemRepositoryImpl ir;

    @BeforeAll
    static void beforeAll() {
        emf = Persistence.createEntityManagerFactory("POSTGRES_RENT_PU");
        em = emf.createEntityManager();
        rr = new RentRepositoryImpl(em);
        cr = new ClientRepositoryImpl(em);
        ir = new ItemRepositoryImpl(em);
    }

    @Test
    void addRent() {
        ClientType normal = new Normal();
        Address address = new Address("Poznan", "Grunwaldzka", "21");
        Music m = new Music("test", "test", "test", 20, "title", "album", "duration");
        Client c = new Client("Konrad", "Maciaszek", "01234", 71, normal, address);
        Rent r = new Rent(c, m);
        rr.addRent(r);
        assertEquals(r, rr.getRentById(r.getId()));
    }

    @Test
    void deleteRent() {
        ClientType normal = new Normal();
        Address address = new Address("Poznan", "Grunwaldzka", "21");
        Client c = new Client("Imie", "Nazwisko", "123", 20, normal, address);
        Music m = new Music("test", "test", "test", 20, "title", "album", "duration");
        Rent r = new Rent(c, m);
        rr.addRent(r);
        rr.deleteRent(r);
        assertNull(rr.getRentById(r.getId()));
    }
}