// package Managers;
//
// import Model.*;
// import Repositories.RentRepository;
//
// import java.util.function.Predicate;
// import java.time.LocalDateTime;
// import java.util.ArrayList;
//
// public class RentManager {
//     private RentRepository archiveRents;
//     private RentRepository currentRents;
//
//     public RentManager() {
//         this.archiveRents = new RentRepository();
//         this.currentRents = new RentRepository();
//     }
//
//     public ArrayList<Rent> getAllClientRents(Client c) {
//         return currentRents.findBy(rent -> (rent.getClient() == c));
//     }
//
//     public Rent getItemRent(Item item) {
//         for (int i = 0; i < currentRents.getSize(); i++) {
//             Rent r = currentRents.getRent(i);
//             if (r.getItem() == item) {
//                 return r;
//             }
//         }
//         return null;
//     }
//
//     public RentRepository getArchiveRents() {
//         return archiveRents;
//     }
//
//     public void returnItem(Item item) {
//         Rent rent = getItemRent(item);
//         if (rent != null) {
//             rent.endRent(LocalDateTime.now());
//             currentRents.removeRent(rent);
//             archiveRents.addRent(rent);
//             changeClientType(rent.getClient());
//         }
//     }
//
//     public double checkClientRentBalance(Client c) {
//         double clientBalance = 0;
//
//         Predicate<Rent> f = r -> (r.getClient() == c);
//         ArrayList<Rent> clientArchiveRents = archiveRents.findBy(f);
//
//         for (int i = 0; i < clientArchiveRents.size(); i++) {
//             clientBalance += clientArchiveRents.get(i).getRentCost();
//         }
//
//         return clientBalance;
//     }
//
//     public Rent rentItem(Client c, Item i, LocalDateTime beginTime) {
//         int currentClientsRentsNumber = getAllClientRents(c).size();
//         int id;
//
//         if (currentRents.getSize() == 0) id = 1;
//         else id = currentRents.getRent(currentRents.getSize() - 1).getId() + 1;
//
//         if (!c.isArchive() && currentClientsRentsNumber < c.getMaxItems() && getItemRent(i) == null) {
//             if (i.isOnlyForAdults() && !c.isAdult()) {
//                 return null;
//             }
//             Rent rent = new Rent(c, i, id);
//             currentRents.addRent(rent);
//             return rent;
//         }
//
//         return null;
//     }
//
//     public void changeClientType(Client c) {
//         double balance = checkClientRentBalance(c);
//
//         if (balance >= 0 && balance < 200) {
//             ClientType normal = new Normal();
//             c.setClientType(normal);
//         } else if (balance >= 200) {
//             ClientType premium = new Premium();
//             c.setClientType(premium);
//         }
//     }
//
//     public ArrayList<Rent> findRents(Predicate<Rent> predicate) {
//         return currentRents.findBy(predicate);
//     }
//
//     public ArrayList<Rent> findAllRents() {
//         return currentRents.findAll();
//     }
// }
