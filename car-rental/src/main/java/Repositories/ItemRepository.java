package Repositories;

import Model.Item;

public interface ItemRepository {
    Item getItemById(Long id);
    Item addItem(Item i);
    void deleteItem(Item i);
}
