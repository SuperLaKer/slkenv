package aa.slkenv.dataBase;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotatedTypeMetadata;


public class OnMissingBean implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        AnnotationAttributes missBean = AnnotationAttributes
                .fromMap(metadata.getAnnotationAttributes(MissBean.class.getName()));
        assert missBean != null;
        Class<?> clazz = missBean.getClass("value");
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        assert beanFactory != null;
        try {
            Object bean = beanFactory.getBean(clazz);
            System.out.println("存在bean: "+bean.getClass().getSimpleName());
            return false;
        } catch (BeansException e) {
            System.out.println("不存在bean: "+clazz.getSimpleName());
            return true;
        }
    }
}
