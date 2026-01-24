package MOIYS.project.learn_jpa_and_hibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import MOIYS.project.learn_jpa_and_hibernate.course.springdatajpa.CourseSpringDataJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

      // jdbc
//    @Autowired
//    private CourseJdbcRepository repository;

//    // jpa
//    @Autowired
//    private CourseJpaRepository repository;

    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1, "Learn AWS jpa!", "MOIYS"));
        repository.save(new Course(2, "Learn Azure jpa!", "MOIYS"));
        repository.save(new Course(3, "Learn DevOps jpa!", "MOIYS"));

        repository.deleteById(1L);

        System.out.println(repository.findById(2L));
        System.out.println(repository.findById(3L));

        System.out.println(repository.findAll());
        System.out.println(repository.count());

        System.out.println(repository.findByAuthor("MOIYS"));

        System.out.println(repository.findByName("Learn Azure jpa!"));
    }
}
