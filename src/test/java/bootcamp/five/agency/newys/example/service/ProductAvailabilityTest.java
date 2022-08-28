package bootcamp.five.agency.newys.example.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import bootcamp.five.agency.newys.example.model.ProductAvailability;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Unit test without including Spring contextB
public class ProductAvailabilityTest {

    private ProductAvailabilityService productAvailabilityService;

    @BeforeAll
    public static void setupForAll() {
        // common setup, run once before all test cases
    }

    @BeforeEach
    public void setup() {
        // setup, executed before each test case

        productAvailabilityService = new ProductAvailabilityService();
    }

    @AfterEach
    public void cleanup() {
        // do after each test case
    }

    @AfterAll
    public static void cleanupAll() {
        // do once after all test cases
    }
    @Test
    public void testSetQuantity_success() {

        // Initialize object to use in test
        ProductAvailability productAvailability = new ProductAvailability(100);
        int newQuantity = 70;

        productAvailabilityService.setNewQuantity(productAvailability, newQuantity);
        assertEquals(newQuantity, productAvailability.getQuantity());
    }

    @Test
    public void testSetQuantity_quantityLessThen0() {

        // Initialize object to use in test
        ProductAvailability productAvailability = new ProductAvailability(100);

        assertThrows(IllegalArgumentException.class, () -> productAvailabilityService.setNewQuantity(productAvailability, -6));
    }

    @Test
    public void testSetQuantity_quantityMoreThenInitial() {

        // Initialize object to use in test
        ProductAvailability productAvailability = new ProductAvailability(100);
        assertThrows(IllegalArgumentException.class, () -> productAvailabilityService.setNewQuantity(productAvailability, 130));
    }

    @Test
    public void testSetQuantity_quantityMoreThenInitial_validValueSet() {

        // Initialize object to use in test
        ProductAvailability productAvailability = new ProductAvailability(100);
        productAvailabilityService.setNewQuantity(productAvailability, 85);

        assertThrows(IllegalArgumentException.class, () -> productAvailabilityService.setNewQuantity(productAvailability, 130));

        assertEquals(85, productAvailability.getQuantity());
    }
}
