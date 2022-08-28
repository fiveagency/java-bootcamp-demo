package bootcamp.five.agency.newys.example.model;

public class ProductAvailability {

    private final int initialQuantity;
    private int quantity;

    public ProductAvailability(int initialQuantity) {
        this.initialQuantity =  initialQuantity;
    }

    public int getInitialQuantity() {
        return initialQuantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int newQuantity) {
        this.quantity = newQuantity;
    }
}
