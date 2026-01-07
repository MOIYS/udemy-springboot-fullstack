package MOIYS.project.learn_spring_framework.examples.scope;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

@Component
public class SingletonBean {

    private final ObjectProvider<PrototypeBean> prototypeBeanProvider;

    public SingletonBean(ObjectProvider<PrototypeBean> prototypeBeanProvider) {
        this.prototypeBeanProvider = prototypeBeanProvider;
    }

    public int logic() {
        PrototypeBean prototypeBean = prototypeBeanProvider.getObject();

        prototypeBean.addCount();
        return prototypeBean.getCount();
    }

//    private final PrototypeBean prototypeBean;
//
//    public SingletonBean(PrototypeBean prototypeBean) {
//        this.prototypeBean = prototypeBean;
//    }
//
//    public int logic() {
//        prototypeBean.addCount();
//        return prototypeBean.getCount();
//    }
}
