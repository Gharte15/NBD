public abstract class ClientType {
    abstract int getMaxItems();
    abstract double applyDiscount(double price);
    abstract String getTypeInfo();
}
