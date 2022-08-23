package bootcamp.five.agency.newys.example.service;

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

    // A custom setQuantity method.
    public void setQuantity(int newQuantity) {
        if(newQuantity < 0) {
            throw new IllegalArgumentException("The quantity cannot be less then 0.");
        } else if(newQuantity > initialQuantity) {
            throw new IllegalArgumentException("The quantity cannot be more then initial quantity.");
        } else {
            this.quantity = newQuantity;
        }
    }
}
