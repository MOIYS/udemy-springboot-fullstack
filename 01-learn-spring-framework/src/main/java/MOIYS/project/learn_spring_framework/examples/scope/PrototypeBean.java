package MOIYS.project.learn_spring_framework.examples.scope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")  // 혹은 @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PrototypeBean {

    private int count = 0;

    public void addCount() {
        this.count++;
    }

    public int getCount() {
        return this.count;
    }
}