public class Music extends Item {
    private String album;
    private String duration;

    public Music(String creator, String releaseDate, String genre, double basePrice, String title, int id, String album, String duration) {
        super(creator, releaseDate, genre, basePrice, title, id);
        this.album = album;
        this.duration = duration;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String getItemInfo() {
        String result = super.getItemInfo();
        result += "\nAlbum: " + this.getAlbum();
        result += "\nCzas trwania: " + this.getDuration();
        return result;
    }

    @Override
    public boolean isOnlyForAdults() {
        return false;
    }
}
