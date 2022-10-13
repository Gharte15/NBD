import com.sun.security.jgss.GSSUtil;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ClientManager clientManager = new ClientManager();
        RentManager rentManager = new RentManager();
        ItemManager itemManager = new ItemManager();
        ClientType premium = new Premium();
        Client c = new Client("Mariusz", "Pudzianowski", "2137", 49, premium, null);
        Item f = new Film("TEST", "TEST", "TEST", 20, "TEST", 1, "TEST", ageCategory.A);
        Rent r = rentManager.rentItem(c, f, LocalDateTime.now());
        System.out.println(rentManager.getItemRent(f).getRentInfo());
        System.out.println("--------------------------");
        rentManager.returnItem(f);
        System.out.println(r.getRentInfo());
        System.out.println("--------------------------");
        System.out.println(r.getRentCost());


    }


}
