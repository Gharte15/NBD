package Repositories;

import Model.Address;
import Model.Client;
import Model.ClientType;
import Model.Normal;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientRepositoryImplTest {
    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static ClientRepositoryImpl cr;

    @BeforeAll
    static void beforeAll() {
        emf = Persistence.createEntityManagerFactory("POSTGRES_RENT_PU");
        em = emf.createEntityManager();
        cr = new ClientRepositoryImpl(em);
    }

    @Test
    void addClient() {
        ClientType normal = new Normal();
        Address address = new Address("Poznan", "Grunwaldzka", "21");
        Client c = new Client("Imie", "Nazwisko", "123", 20, normal, address);
        cr.addClient(c);
        assertEquals(c, cr.getClientById(c.getId()));
    }

    @Test
    void deleteClient() {
        ClientType normal = new Normal();
        Address address = new Address("Poznan", "Grunwaldzka", "21");
        Client c = new Client("Imie", "Nazwisko", "123", 20, normal, address);
        cr.addClient(c);
        cr.deleteClient(c);
        assertNull(cr.getClientById(c.getId()));
    }
}