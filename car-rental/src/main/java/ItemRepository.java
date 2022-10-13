import java.util.ArrayList;
import java.util.function.Predicate;

public class ItemRepository {
    private ArrayList<Item> items = new ArrayList<Item>();

    public Item getItem(int i) {
        if (i < items.size()) {
            return items.get(i);
        } else {
            return null;
        }
    }

    public void addItem(Item i) {
        if (i != null) {
            items.add(i);
        }
    }

    public void removeItem(Item i) {
        if (i != null) {
            items.remove(i);
        }
    }

    public int getSize() {
        return items.size();
    }

    public Item findById(int ID) {
        for (Item i : items) {
            if (i.getId() == ID) {
                return i;
            }
        }
        return null;
    }

    public String report() {
        String result = "";

        for (Item i : items) {
            result += "\n" + i.getItemInfo();
        }

        return result;
    }

    public ArrayList<Item> findBy(Predicate<Item> itemPredicate) {
        ArrayList<Item> found = new ArrayList<>();
        for (Item i : items) {
            if (itemPredicate.test(i)) {
                found.add(i);
            }
        }
        return found;
    }
}
