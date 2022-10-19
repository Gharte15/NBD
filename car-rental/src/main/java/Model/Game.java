package Model;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@Access(AccessType.FIELD)
@DiscriminatorValue("game")
public class Game extends Item {
    private String platform;
    private AgeCategory category;

    public Game(String creator, String releaseDate, String genre, double basePrice, String title, String platform, AgeCategory category) {
        super(creator, releaseDate, genre, basePrice, title);
        this.platform = platform;
        this.category = category;
    }

    public Game() {
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public AgeCategory getCategory() {
        return category;
    }

    public void setCategory(AgeCategory category) {
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
        return this.getCategory() == AgeCategory.B;
    }
}
