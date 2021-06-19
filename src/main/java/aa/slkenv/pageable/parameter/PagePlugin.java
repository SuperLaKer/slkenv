package aa.slkenv.pageable.parameter;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Connection;
import java.util.Map;
import java.util.Properties;

@Intercepts(@Signature(
        // type = StatementHandler.class,
        type = StatementHandler.class,
        method = "prepare",
        args = {Connection.class, Integer.class}
))
public class PagePlugin implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // Invocation：封装了type,method,args。就是对拦截对象的方法的封装
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        Map parameterObject = (Map<String, Object>) statementHandler.getParameterHandler().getParameterObject();
        assert invocation.getMethod().getName().equals("prepare");
        MetaObject metaObject = MetaObject.forObject(
                statementHandler, SystemMetaObject.DEFAULT_OBJECT_FACTORY,
                SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY, new DefaultReflectorFactory()
        );
        Page page = (Page) parameterObject.get("page");
        if (page != null) {
            String value = (String) metaObject.getValue("boundSql.sql");
            String[] strings = value.split(" ");
            String databaseName = strings[strings.length - 1];

            String sql = createSql(page, value);
            metaObject.setValue("boundSql.sql", sql);


//            Integer pageNum = page.getPageNum();
//            Integer size = page.getSize();
//            // Integer starterId = page.getStarterId();
//
//            Integer starterId = 0;
//            int id = (pageNum - 1) * size + starterId - 1;
//            // >  num * size + 起始id - 1  limit size;
//            value = value + " where id > " + id + " limit " + size;
//            // 重新设置sql
//            metaObject.setValue("boundSql.sql", value);
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        System.out.println(properties);
    }



    private String createSql(Page page, String sqlHead) {

        Integer currentId = page.getCurrentId();
        Integer pageNum = page.getPageNum();
        Integer size = page.getSize();

        String[] strings = sqlHead.split(" ");
        String databaseName = strings[strings.length - 1];

        // 连续
        if (pageNum != null && currentId == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(sqlHead)
                    .append(" inner join (select id from ")
                    .append(databaseName)
                    .append(" limit 10, 5) as ids_derived on ").append(databaseName).append(".id = ids_derived.id");

            return new String(stringBuilder);
        }

        // 不连续
        if (currentId != null && pageNum == null) {
            return "连续";
        }

        return null;
    }

}
