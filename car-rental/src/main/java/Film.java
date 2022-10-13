public class Film extends Item {
    private String duration;
    private ageCategory category;

    public Film(String creator, String releaseDate, String genre, double basePrice, String title, int id, String duration, ageCategory category) {
        super(creator, releaseDate, genre, basePrice, title, id);
        this.duration = duration;
        this.category = category;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public ageCategory getCategory() {
        return category;
    }

    public void setCategory(ageCategory category) {
        this.category = category;
    }

    public String getItemInfo() {
        String result = super.getItemInfo();
        result += "Czas trwania: " + this.getDuration() + "\n";
        return result;
    }

    @Override
    public boolean isOnlyForAdults() {
        return this.getCategory() == ageCategory.B;
    }
}
