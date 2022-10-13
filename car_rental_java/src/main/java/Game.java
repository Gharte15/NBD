public class Game extends Item {
    protected String platform;
    protected ageCategory category;

    public Game(String creator, String releaseDate, String genre, double basePrice, String title, int id, String platform, ageCategory category) {
        super(creator, releaseDate, genre, basePrice, title, id);
        this.platform = platform;
        this.category = category;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public ageCategory getCategory() {
        return category;
    }

    public void setCategory(ageCategory category) {
        this.category = category;
    }

    @Override
    public String getItemInfo() {
        String result = super.getItemInfo();
        result += "\nPlatforma: " + this.getPlatform();
        return result;
    }

    @Override
    public boolean isOnlyForAdults() {
        return this.getCategory() == ageCategory.B;
    }
}
