package aa.slkenv.dataBase.impl;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author lla
 *
 * 颜色(30-37)、背景颜色(40-47)、样式(0147)
 *
 *
 */
public class DruidDataSource {

    static {
        String msg = "EnableDruidDataSource: 依赖druid、DataSource";
        System.out.println("\033[33;1;1m" + msg + "\033[0m");
    }

    @Bean
    public static DataSource getDataSource() throws Exception {
        InputStream is = DruidDataSource.class.getClassLoader().getResourceAsStream("druid.properties");
        Properties properties = new Properties();
        properties.load(is);
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
        // 4.获取连接池对象
        return dataSource;
    }
}
