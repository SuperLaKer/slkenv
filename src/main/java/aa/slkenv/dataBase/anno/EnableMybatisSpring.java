package aa.slkenv.dataBase.anno;

import aa.slkenv.dataBase.impl.MybatisSqlSessionFactoryProvider;

import org.springframework.context.annotation.Import;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author lla, 2020/12/10:18:58
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(MybatisSqlSessionFactoryProvider.class)
public @interface EnableMybatisSpring {
}
