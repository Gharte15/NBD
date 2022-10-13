public class Normal extends ClientType {
    @Override
    int getMaxItems() {
        return 2;
    }

    @Override
    double applyDiscount(double price) {
        return 0;
    }

    @Override
    String getTypeInfo() {
        return "Typ klienta: zwykly\n";
    }
}
