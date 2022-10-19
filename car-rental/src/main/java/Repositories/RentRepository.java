package Repositories;

import Model.Rent;

public interface RentRepository {
    Rent getRentById(Long id);
    Rent addRent(Rent r);
    void deleteRent(Rent r);
}
