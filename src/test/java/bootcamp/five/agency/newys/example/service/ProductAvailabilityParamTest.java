package bootcamp.five.agency.newys.example.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import bootcamp.five.agency.newys.example.model.ProductAvailability;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ProductAvailabilityParamTest {

    private final ProductAvailabilityService productAvailabilityService = new ProductAvailabilityService();

    @ParameterizedTest
    @CsvSource({
            "100,90,90",
            "100,0,0",
            "100,100,100"
    })
    public void testSetQuantity_success(int initialQuantity, int newQuantity, int expectedValue) {

        // Initialize object to use in test
        ProductAvailability productAvailability = new ProductAvailability(initialQuantity);

        productAvailabilityService.setNewQuantity(productAvailability, newQuantity);
        assertEquals(expectedValue, productAvailability.getQuantity());
    }

    @ParameterizedTest
    @CsvSource({
            "100,-6",
            "100,125"
    })
    public void testSetQuantity_invalidQuantity(final int initialQuantity, final int newQuantity) {

        // Initialize object to use in test
        ProductAvailability productAvailability = new ProductAvailability(initialQuantity);

        Executable settingQuantity = () -> productAvailabilityService.setNewQuantity(productAvailability, newQuantity);
        assertThrows(IllegalArgumentException.class, settingQuantity);
    }
}
