import Model.*;
import Repositories.ClientRepositoryImpl;
import Repositories.ItemRepositoryImpl;
import Repositories.RentRepositoryImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POSTGRES_RENT_PU");
        EntityManager em = emf.createEntityManager();
        RentRepositoryImpl rr = new RentRepositoryImpl(em);
        ClientRepositoryImpl cr = new ClientRepositoryImpl(em);
        ItemRepositoryImpl ir = new ItemRepositoryImpl(em);

        ClientType normal = new Normal();
        Address address = new Address("Poznan", "Grunwaldzka", "21");
        Music m = new Music("test", "test", "test", 20, "title", "album", "duration");
        Client c = new Client("Konrad", "Maciaszek", "01234", 71, normal, address);
        Rent r = new Rent(c, m);
        rr.addRent(r);
    }
}
