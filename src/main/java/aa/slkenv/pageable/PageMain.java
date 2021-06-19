package aa.slkenv.pageable;

import aa.slkenv.dataBase.MissBean;
import aa.slkenv.dataBase.ShowSql;
import aa.slkenv.dataBase.anno.EnableSpringDataSource;
import aa.slkenv.pageable.domain.GoodsBase;
import aa.slkenv.pageable.mappers.GoodsBaseMapper;
import aa.slkenv.pageable.parameter.Page;
import aa.slkenv.pageable.parameter.PagePlugin;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.sql.DataSource;
import java.util.List;

@EnableSpringDataSource
@ComponentScan("aa.slkenv.pageable")
@MapperScan("aa.slkenv.pageable.mappers")
public class PageMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PageMain.class);
        GoodsBaseMapper goodsMapper = ac.getBean(GoodsBaseMapper.class);
        List<GoodsBase> goods = goodsMapper.selectListPageable(Page.PageBuilderContinuousAndIncreasingId(10, 5));
        System.out.println(goods);
    }


    @Bean("sqlSessionFactory")
    @MissBean(SqlSessionFactory.class)
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        SqlSessionFactory sqlSessionFactory = factoryBean.getObject();
        assert sqlSessionFactory != null;
        Configuration configuration = sqlSessionFactory.getConfiguration();
        configuration.addInterceptor(new ShowSql());
        configuration.addInterceptor(new PagePlugin());
        return sqlSessionFactory;
    }
}
