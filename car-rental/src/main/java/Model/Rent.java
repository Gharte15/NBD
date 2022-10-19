package Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.dom4j.tree.AbstractEntity;
import java.time.Duration;
import java.time.LocalDateTime;

@Access(AccessType.FIELD)
@Entity
public class Rent extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn
    @NotNull
    private Client client;

    @ManyToOne
    @JoinColumn
    @NotNull
    private Item item;

    private double rentCost = 0;
    private LocalDateTime beginTime;
    private LocalDateTime endTime;

    public Rent(Client client, Item item, Long id) {
        this.client = client;
        this.item = item;
        this.id = id;
        this.beginTime = LocalDateTime.now();
        this.item.setRented(true);
    }

    public Rent() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long rentID) {
        this.id = rentID;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public double getRentCost() {
        return rentCost;
    }

    public void setRentCost(double rentCost) {
        this.rentCost = rentCost;
    }

    public LocalDateTime getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(LocalDateTime beginTime) {
        this.beginTime = beginTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getRentInfo() {
        String result = "";
        result += "Start wypozyczenia: " + this.getBeginTime() + "\n";
        result += "Koniec wypozyczenia: " + this.getEndTime() + "\n";
        result += "ID: " + this.getId() + "\n";
        result += "Przedmiot: " + this.getItem().getItemInfo();
        return result;
    }

    public long getRentDays() {
        if (this.endTime == null) {
            return 0;
        } else {
            long rentDays = Duration.between(beginTime, endTime).toDays();
            return rentDays;
        }
    }

    public void endRent(LocalDateTime endTime) {
        if (this.getEndTime() == null) {
            if (endTime.isBefore(beginTime)) {
                this.endTime = this.beginTime;
            }
            if (endTime.isAfter(beginTime)) {
                this.endTime = endTime;
            }
        }

        double itemBasePrice = this.getItem().getBasePrice();
        double discount = this.getClient().calculateDiscount(itemBasePrice);
        double basePriceAfterDiscount = itemBasePrice - discount;

        if (basePriceAfterDiscount < 0) {
            basePriceAfterDiscount = 0;
        } else {
            this.rentCost = this.getRentDays() * basePriceAfterDiscount;
        }
        this.item.setRented(true);
    }
}
