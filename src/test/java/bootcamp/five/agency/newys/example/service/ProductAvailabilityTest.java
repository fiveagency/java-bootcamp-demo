package bootcamp.five.agency.newys.example.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductAvailabilityTest {

    @Test
    public void testSetQuantity_success() {

        // Initialize object to use in test
        ProductAvailability productAvailability = new ProductAvailability(100);

        productAvailability.setQuantity(70);
        assertEquals(70, productAvailability.getQuantity());
    }

    @Test
    public void testSetQuantity_quantityLessThen0() {

        // Initialize object to use in test
        ProductAvailability productAvailability = new ProductAvailability(100);

        Executable settingQuantity = () -> productAvailability.setQuantity(-6);
        assertThrows(IllegalArgumentException.class, settingQuantity);


    }

    @Test
    public void testSetQuantity_quantityMoreThenInitial() {

        // Initialize object to use in test
        ProductAvailability productAvailability = new ProductAvailability(100);

        // productAvailability.setQuantity(130);

        Executable settingQuantity = () -> productAvailability.setQuantity(130);
        assertThrows(IllegalArgumentException.class, settingQuantity);


    }

    @Test
    public void testSetQuantity_quantityMoreThenInitial_validValueSet() {

        // Initialize object to use in test
        ProductAvailability productAvailability = new ProductAvailability(100);
        productAvailability.setQuantity(85);

        Executable settingQuantity = () -> productAvailability.setQuantity(130);
        assertThrows(IllegalArgumentException.class, settingQuantity);

        assertEquals(85, productAvailability.getQuantity());
    }
}
