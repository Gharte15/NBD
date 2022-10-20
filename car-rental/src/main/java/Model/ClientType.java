package Model;

import jakarta.persistence.*;

@Access(AccessType.FIELD)
public abstract class ClientType {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    abstract int getMaxItems();
    abstract double applyDiscount(double price);
    abstract String getTypeInfo();

    @Override
    public String toString() {
        return null;
    }
}
