public class ItemManager {
    private ItemRepository itemRepository;

    public Item getItem(int id) {
        return itemRepository.findById(id);
    }

    public Item registerMusic(String creator, String releaseDate, String genre, double basePrice, String title,
                              int id, String album, String duration) {
        Item i = getItem(id);

        if (i != null) {
            return i;
        } else {
            i = new Music(creator, releaseDate, genre, basePrice, title, id, album, duration);
            itemRepository.addItem(i);
            return i;
        }
    }

    public Item registerFilm(String creator, String releaseDate, String genre, double basePrice, String title, int id, String duration, ageCategory category) {
        Item i = getItem(id);

        if (i != null) {
            return i;
        } else {
            i = new Film(creator, releaseDate, genre, basePrice, title, id, duration, category);
            itemRepository.addItem(i);
            return i;
        }
    }

    public Item registerGame(String creator, String releaseDate, String genre, double basePrice, String title, int id, String platform, ageCategory category) {
        Item i = getItem(id);

        if (i != null) {
            return i;
        } else {
            i = new Game(creator, releaseDate, genre, basePrice, title, id, platform, category);
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
