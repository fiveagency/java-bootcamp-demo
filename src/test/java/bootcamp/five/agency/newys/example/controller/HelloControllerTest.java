package bootcamp.five.agency.newys.example.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloControllerTest {

    // Unit test without including Spring context
    @Test
    public void testHello() {
        HelloController helloController = new HelloController();    // instantiate controller

        final String universe = "universe";
        final String expectedResponse = "Hello universe!";
        String response = helloController.hello(universe); // call hello method
        assertEquals(expectedResponse, response);
    }
}
