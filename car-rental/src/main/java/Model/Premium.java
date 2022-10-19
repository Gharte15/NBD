package Model;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Embeddable;

@Embeddable
@Access(AccessType.FIELD)
public class Premium extends ClientType {
    @Override
    int getMaxItems() {
        return 10;
    }

    @Override
    double applyDiscount(double price) {
        return price * 0.2;
    }

    @Override
    String getTypeInfo() {
        return "Typ klienta: premium\n";
    }
}
