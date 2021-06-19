package aa.slkenv.dataBase.anno;

import aa.slkenv.dataBase.impl.DruidDataSource;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author lla, 2020/12/10:19:09
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(DruidDataSource.class)
public @interface EnableDruidDataSource {
}
