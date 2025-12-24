package MOIYS.project.learn_spring_framework.helloworld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {
    public static void main(String[] args) {

        // 1. Spring Context 실행
        // HelloWorldConfiguration의 설정을 읽어서, 컨테이너 실행
        try (var context =
                     new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)) {

            // 2. Spring Framework가 관리하도록 할 것들 설정(HelloWorldConfiguration)
            // HelloWorldConfiguration - @Configuration
            // name - @Bean

            // 3. Spring이 관리하고 있는 Bean 검색
            System.out.println(context.getBean("name"));

            System.out.println(context.getBean("age"));

            System.out.println(context.getBean("person"));

            System.out.println(context.getBean("person2MethodCall"));

            System.out.println(context.getBean("person3Parameters"));

            System.out.println(context.getBean("address2"));

            System.out.println(context.getBean(HelloWorldConfiguration.Person.class));

            System.out.println(context.getBean(HelloWorldConfiguration.Address.class));

            System.out.println(context.getBean("person5Qualifier"));

//        Arrays.stream(context.getBeanDefinitionNames())
//                .forEach(System.out::println);
        }
    }
}