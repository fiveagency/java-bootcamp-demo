package bootcamp.five.agency.newys.example.service;

import bootcamp.five.agency.newys.example.model.ProductAvailability;
import org.springframework.stereotype.Service;

@Service
public class ProductAvailabilityService {

  public void setNewQuantity(ProductAvailability productAvailability, int newQuantity) {
    if (newQuantity < 0) {
      throw new IllegalArgumentException("The quantity cannot be less then 0.");
    }

    if(newQuantity > productAvailability.getInitialQuantity()) {
      throw new IllegalArgumentException("The quantity cannot be more then initial quantity.");
    }

    productAvailability.setQuantity(newQuantity);
  }
}
