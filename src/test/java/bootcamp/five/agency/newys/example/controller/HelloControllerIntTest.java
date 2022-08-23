package bootcamp.five.agency.newys.example.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@WebMvcTest(HelloController.class)
public class HelloControllerIntTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHello() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/hello").param("name", "Universe");
        MvcResult result = mockMvc.perform(request).andReturn();
        final String expectedResponse = "Hello Universe!";
        assertNotNull(result);
        assertNotNull(result.getResponse());
        assertEquals(expectedResponse, result.getResponse().getContentAsString());
    }
}
