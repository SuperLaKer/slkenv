package aa.slkenv.dataBase;


import org.springframework.context.annotation.Conditional;

@Conditional(OnMissingBean.class)
public @interface MissBean {
    Class<?> value();
}
