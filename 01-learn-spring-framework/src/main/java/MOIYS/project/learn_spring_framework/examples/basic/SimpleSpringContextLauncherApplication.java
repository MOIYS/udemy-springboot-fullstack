package MOIYS.project.learn_spring_framework.examples.basic;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class SimpleSpringContextLauncherApplication {

    public static void main(String[] args) {
        
        try (var context =
                     new AnnotationConfigApplicationContext
                             (SimpleSpringContextLauncherApplication.class)) {

            /*
             * 1. internalConfigurationAnnotationProcessor:
             * - `@Configuration`이 붙은 클래스를 찾아, 설정 파일로 인식하게 하는 Bean
             * 2. internalAutowiredAnnotationProcessor:
             * - `@Autowired`를 보고 의존성을 자동으로 주입해주는 Bean
             * 3. internalCommonAnnotationProcessor:
             * - 자바 표준 어노테이션을 처리하는 Bean
             * 4. internalEventListener...(2개):
             * - 스프링 이벤트 기능 처리 Bean
             */
            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);

        }
    }
}