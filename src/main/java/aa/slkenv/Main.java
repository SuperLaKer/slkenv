package aa.slkenv;

import aa.slkenv.dataBase.anno.EnableDruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

/**
 * @author lla
 */
@EnableDruidDataSource
public class Main {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Main.class);
        DataSource bean = ac.getBean(DataSource.class);
        System.out.println(bean);
        SqlSessionFactory bean1 = ac.getBean(SqlSessionFactory.class);
        System.out.println(bean1);
    }
}
