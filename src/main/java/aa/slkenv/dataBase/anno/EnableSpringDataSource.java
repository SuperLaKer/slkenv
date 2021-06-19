package aa.slkenv.dataBase.anno;


import aa.slkenv.dataBase.impl.SpringDataSourceAware;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author lla
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(SpringDataSourceAware.class)  // 相当于注解处理类
public @interface EnableSpringDataSource {
    String driverClassName() default "com.mysql.cj.jdbc.Driver";
    String username() default "root";
    String password() default "roottt";
    // dataBaseName会被dbName() replace
    String url() default "jdbc:mysql://localhost:3306/dataBaseName?serverTimezone=UTC&characterEncoding=utf-8";
    String dataBaseName() default "sfnotes";
}
