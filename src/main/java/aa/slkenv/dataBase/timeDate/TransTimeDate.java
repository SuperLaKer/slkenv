package aa.slkenv.dataBase.timeDate;

import aa.slkenv.dataBase.anno.EnableSpringDataSource;
import aa.slkenv.dataBase.timeDate.config.Beans;
import aa.slkenv.dataBase.timeDate.web.entity.TimeDate;
import aa.slkenv.dataBase.timeDate.web.mapper.TimeDateMapper;
import aa.slkenv.dataBase.timeDate.web.repositories.TimeDateRepository;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Configuration
@EnableSpringDataSource
@Import(Beans.class)
@MapperScan("aa.slkenv.dataBase.timeDate.web.mapper")
@EnableJpaRepositories
public class TransTimeDate {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TransTimeDate.class);
        System.out.println(ac.getBeanDefinitionNames()[0]);

        // userMapper(ac);
        // jpa1(ac);
        TimeDateRepository timeDateRepository = ac.getBean(TimeDateRepository.class);
        List<TimeDate> all = timeDateRepository.findByTheTimestampIsBefore(new Timestamp(System.currentTimeMillis()));
        System.out.println(all);
    }

    private static void jpa1(AnnotationConfigApplicationContext ac) {
        TimeDateRepository timeDateRepository = ac.getBean(TimeDateRepository.class);
        List<TimeDate> all = timeDateRepository.findAll();
        System.out.println(all);
    }

    private static void userMapper(AnnotationConfigApplicationContext ac) {
        TimeDateMapper timeDateMapper = ac.getBean(TimeDateMapper.class);
        // List<TimeDate> timeDates = timeDateMapper.findAll();
        List<aa.slkenv.dataBase.timeDate.web.domain.TimeDate> timeDates = timeDateMapper.findByDateTime(new Date(System.currentTimeMillis()-1000*3600*5));
        System.out.println(timeDates);
    }
}
