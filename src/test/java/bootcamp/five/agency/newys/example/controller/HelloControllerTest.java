package bootcamp.five.agency.newys.example.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Unit test without including Spring context
public class HelloControllerTest {

    @Test
    public void testHello() {
        HelloController helloController = new HelloController();    // instantiate controller

        final String universe = "Universe";
        final String expectedResponse = "Hello Universe!";
        String response = helloController.hello(universe); // call hello method
        assertEquals(expectedResponse, response);
    }
}
