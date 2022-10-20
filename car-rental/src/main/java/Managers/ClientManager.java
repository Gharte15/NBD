package Managers;

import Model.Address;
import Model.Client;
import Model.ClientType;
import Repositories.ClientRepositoryImpl;

public class ClientManager {
    private ClientRepositoryImpl cr;

    public ClientManager(ClientRepositoryImpl cr) {
        this.cr = cr;
    }

    public Client getClient(String personalId) {
        return cr.getClientByPersonalId(personalId);
    }

   public Client registerClient(String firstName, String lastName, int age, String personalID, Address address, ClientType clientType) {
        Client c = getClient(personalID);

        if (c == null) {
            c = new Client(firstName, lastName, personalID, age, clientType, address);
            this.cr.addClient(c);
        }
        return c;
    }

    public void unregisterClient(Client c) {
        if (getClient(c.getPersonalID()) != null) {
            c.setArchive(true);
        }
    }
}
