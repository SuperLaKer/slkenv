package aa.slkenv.dataBase.impl;

import aa.slkenv.dataBase.MissBean;
import aa.slkenv.dataBase.OnMissingBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import javax.sql.DataSource;

/**
 * @author lla, 2020/12/10:18:59
 */
public class MybatisSqlSessionFactoryProvider {
    static {
       String msg = "EnableMybatisSpring: 依赖mybatis, mybatis-spring, dataSource";
        System.out.println("\033[33;1;1m" + msg + "\033[0m");
    }


    @Autowired
    DataSource dataSource;
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean("sqlSessionFactory")
    @MissBean(SqlSessionFactory.class)
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        return factoryBean.getObject();
    }
}
