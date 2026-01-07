package MOIYS.project.learn_spring_framework.examples.realworld;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

// @Component
@Repository
@Primary
public class MySqlDataService implements DataService {

    @Override
    public int[] retrieveData() {
        return new int[] {1, 2, 3, 4, 5};
    }
}