package bootcamp.five.agency.newys.examplepackage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyController {

  // take note of the import here!
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @GetMapping(value = "/info-debug")
  public String infoDebug() {
    logger.info("I'm writing info here!");

    logger.debug("I'm also writing something for the debug!");

    return logger.isDebugEnabled() ? "info+debug" : "info";
  }

  @GetMapping("/warning")
  public String warning() {
    logger.warn("I'm warning here!");

    return "warning";
  }

  @GetMapping("/error")
  public String error() {

    try {
      throwException();
    } catch (RuntimeException e) {
      logger.error("Custom message here", e);

      // OR:
      //logger.error("Custom message here {}", e.getMessage());
      // what you'll use depends on the semantics!
    }

    return "error";
  }

  @GetMapping("/hello")
  public String sayHello() {
    return "Hello from dummy!";
  }

  private void throwException() {
    throw new RuntimeException("Throwing an exception");
  }
}
