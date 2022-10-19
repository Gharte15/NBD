package Model;

import jakarta.persistence.*;
import org.dom4j.tree.AbstractEntity;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
// @DiscriminatorColumn(name = "type")
@Access(AccessType.FIELD)
public abstract class Item extends AbstractEntity {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String creator;
    private String releaseDate;
    private String genre;
    private double basePrice;
    private String title;
    private boolean archive = false;
    private boolean rented = false;

    public Item(String creator, String releaseDate, String genre, double basePrice, String title) {
        this.creator = creator;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.basePrice = basePrice;
        this.title = title;
    }

    public Item() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long itemID) {
        this.id = itemID;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isArchive() {
        return archive;
    }

    public void setArchive(boolean archive) {
        this.archive = archive;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    public String getItemInfo() {
        String result = "";
        result += "Przedmiot:\n";
        result += "ID: " + this.getId() + "\n";
        result += "Tytul: " + this.getTitle() + "\n";
        result += "Cena bazowa: " + this.getBasePrice() + "\n";
        result += "Gatunek: " + this.getGenre() + "\n";

        return result;
    }
    public double getActualRentalPrice() {
        return basePrice;
    }
    public abstract boolean isOnlyForAdults();

}
