import java.util.ArrayList;
import java.util.function.Predicate;

public class RentRepository {
    private ArrayList<Rent> rents = new ArrayList<Rent>();

    public Rent getRent(int r) {
        if (r < rents.size()) {
            return rents.get(r);
        } else {
            return null;
        }
    }

    public void addRent(Rent r) {
        if (r != null) {
            rents.add(r);
        }
    }

    public void removeRent(Rent r) {
        if (r != null) {
            rents.remove(r);
        }
    }

    public int getSize() {
        return rents.size();
    }

    public String report() {
        String result = "";

        for (Rent r : rents) {
            result += "\n" + r.getRentInfo();
        }

        return result;
    }

    public ArrayList<Rent> findBy(Predicate<Rent> predicate) {
        ArrayList<Rent> found = new ArrayList<>();
        for (Rent r : rents) {
            if (predicate.test(r)) {
                found.add(r);
            }
        }
        return found;
    }

    public ArrayList<Rent> findAll() {
        return rents;
    }
}
