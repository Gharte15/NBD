package Repositories;

import Model.Client;

public interface ClientRepository {
    Client getClientById(Long id);
    Client getClientByPersonalId(String personalId);
    Client addClient(Client c);
    void deleteClient(Client c);
}
