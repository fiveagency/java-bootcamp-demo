package bootcamp.five.agency.newys.examplepackage;

import org.springframework.stereotype.Service;

@Service
public class DummyService {

  private final ExternalLibraryService externalLibraryService;

  // what is usually done:
  public DummyService() {
    // do we also have to instantiate database manager somehow here !?
    externalLibraryService = new ExternalLibraryService(null);
  }

  // Inversion of Control through Dependency Injection:
//  public DummyService(ExternalLibraryService externalLibraryService) {
//    this.externalLibraryService = externalLibraryService;
//  }


}
