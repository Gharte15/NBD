import Entities.Client;
import Repositories.ClientRepository;

public class ClientManager {
    private ClientRepository clientRepository;
    Client getClient(String personalId) {
        return clientRepository.findByPersonalId(personalId);
    }

   public Client registerClient(String firstName, String lastName, int age, String personalID, Address address, ClientType clientType) {
        Client c = getClient(personalID);

        if (c == null) {
            c = new Client(firstName, lastName, personalID, age, clientType, address);
            this.clientRepository.addClient(c);
        }
        return c;
    }

    public boolean isPersonalIDTaken(String ID) {
        for (int i = 0; i < clientRepository.getSize(); i++) {
            if (clientRepository.getClient(i).getPersonalID() == ID) {
                return true;
            }
        }
        return false;
    }

    public void unregisterClient(Client c) {
        if (getClient(c.getPersonalID()) != null) {
            c.setArchive(true);
        }
    }


}
