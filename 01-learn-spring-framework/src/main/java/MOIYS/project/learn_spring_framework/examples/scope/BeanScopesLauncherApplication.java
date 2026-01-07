package MOIYS.project.learn_spring_framework.examples.scope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class BeanScopesLauncherApplication {

    public static void main(String[] args) {

        try (var context =
                     new AnnotationConfigApplicationContext(
                             BeanScopesLauncherApplication.class)) {

            System.out.println("Prototype: ");
            System.out.println(context.getBean(PrototypeBean.class));
            System.out.println(context.getBean(PrototypeBean.class));
            System.out.println(context.getBean(PrototypeBean.class));

            System.out.println("\n Singleton: ");
            System.out.println(context.getBean(SingletonBean.class));
            System.out.println(context.getBean(SingletonBean.class));
            System.out.println(context.getBean(SingletonBean.class));

            System.out.println("\nPrototype by Singleton:");
            System.out.println(context.getBean(SingletonBean.class).logic());
            System.out.println(context.getBean(SingletonBean.class).logic());
            System.out.println(context.getBean(SingletonBean.class).logic());
        }
    }
}