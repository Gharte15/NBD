package Model;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@Access(AccessType.FIELD)
@DiscriminatorValue("film")
public class Film extends Item {
    private String duration;
    private AgeCategory category;

    public Film(String creator, String releaseDate, String genre, double basePrice, String title, String duration, AgeCategory category) {
        super(creator, releaseDate, genre, basePrice, title);
        this.duration = duration;
        this.category = category;
    }

    public Film() {
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public AgeCategory getCategory() {
        return category;
    }

    public void setCategory(AgeCategory category) {
        this.category = category;
    }

    public String getItemInfo() {
        String result = super.getItemInfo();
        result += "Czas trwania: " + this.getDuration() + "\n";
        return result;
    }

    @Override
    public boolean isOnlyForAdults() {
        return this.getCategory() == AgeCategory.B;
    }
}
