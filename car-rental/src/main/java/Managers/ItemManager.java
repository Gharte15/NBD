package Managers;

import Model.*;
import Repositories.ItemRepository;

public class ItemManager {
    private ItemRepository itemRepository;

    public Item getItem(Long id) {
        return itemRepository.getItemById(id);
    }

    public Item registerMusic(String creator, String releaseDate, String genre, double basePrice, String title,
                               String album, String duration, long id) {
        Item i = getItem(id);

        if (i != null) {
            return i;
        } else {
            i = new Music(creator, releaseDate, genre, basePrice, title, album, duration);
            itemRepository.addItem(i);
            return i;
        }
    }

    public Item registerFilm(String creator, String releaseDate, String genre, double basePrice, String title, long id, String duration, AgeCategory category) {
        Item i = getItem(id);

        if (i != null) {
            return i;
        } else {
            i = new Film(creator, releaseDate, genre, basePrice, title, duration, category);
            itemRepository.addItem(i);
            return i;
        }
    }

    public Item registerGame(String creator, String releaseDate, String genre, double basePrice, String title, long id, String platform, AgeCategory category) {
        Item i = getItem(id);

        if (i != null) {
            return i;
        } else {
            i = new Game(creator, releaseDate, genre, basePrice, title, platform, category);
            itemRepository.addItem(i);
            return i;
        }
    }

    public void unregisterItem(Item i) {
        if (getItem(i.getId()) != null) {
            i.setArchive(true);
        }
    }
}
