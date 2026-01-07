package MOIYS.project.learn_spring_framework.examples.cdi;

import jakarta.inject.Inject;
import jakarta.inject.Named;

//@Component
@Named
public class BusinessService {

    private DataService dataService;

    //@Autowired
    @Inject
    public void setDataService(DataService dataService) {
        System.out.println("Setter Injection");
        this.dataService = dataService;
    }

    public DataService getDataService() {
        return dataService;
    }
}
