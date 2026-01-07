package MOIYS.project.learn_spring_framework.examples.postpre;

import org.springframework.stereotype.Component;

@Component
public class SomeDependency {

    public void getReady() {
        System.out.println("Some logic using SomeDependency");
    }
}
