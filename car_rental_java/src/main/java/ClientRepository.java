import java.util.function.Predicate;
import java.util.ArrayList;

public class ClientRepository {
    private ArrayList<Client> clients = new ArrayList<Client>();

    public Client getClient(int i) {
        if (i < clients.size()) {
            return clients.get(i);
        } else {
            return null;
        }
    }

    public void addClient(Client c) {
        if (c != null) {
            clients.add(c);
        }
    }

    public void removeClient(Client c) {
        if (c != null) {
            clients.remove(c);
        }
    }

    public int getSize() {
        return clients.size();
    }

    public ArrayList<Client> findBy(Predicate<Client> clientPredicate) {
        ArrayList<Client> found = new ArrayList<>();
        for (Client c : clients) {
            if (clientPredicate.test(c)) {
                found.add(c);
            }
        }
        return found;
    }

    public Client findByPersonalId(String personalID) {
        for (Client c : clients) {
            if (c.getPersonalID() == personalID) {
                return c;
            }
        }
        return null;
    }

    public ArrayList<Client> findAll() {
        return clients;
    }
}
