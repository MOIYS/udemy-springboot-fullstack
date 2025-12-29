package MOIYS.project.learn_spring_framework.examples.realworld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class RealWorldSpringContextLauncherApplication {

    public static void main(String[] args) {

        try (var context =
                     new AnnotationConfigApplicationContext
                             (RealWorldSpringContextLauncherApplication.class)) {

            System.out.println(context.getBean(BusinessCalculationService.class).findMax());
        }
    }
}
