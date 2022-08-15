package bootcamp.five.agency.newys.examplepackage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AnotherDummyController {

  @Value("${dummy.hello.url}")
  private String helloUrl;

  // how to provide a default
  //@Value("${dummy.hello.url:http://localhost:8080}")
  //private String helloUrl;

  private final RestTemplate restTemplate;

  public AnotherDummyController(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @GetMapping("/call-dummy")
  private String callDummyController() {
    return restTemplate.getForObject("http://localhost:8080/hello", String.class);

    // much better!
    //String path = "/hello";
    //return restTemplate.getForObject(helloUrl + path, String.class);
  }
}
