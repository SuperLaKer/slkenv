package aa.slkenv.dataBase.impl;

import aa.slkenv.dataBase.anno.EnableSpringDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Map;


/**
 * @author lla
 * 直接使用@ImportSpringDataSource注解导入
 */
public class SpringDataSourceAware implements ImportAware {

	static {
		String msg = "EnableSpringDataSource: 依赖spring-jdbc, datasource";
		System.out.println("\033[33;1;1m" + msg + "\033[0m");
	}

	private String url;
	private String username;
	private String password;
	private String dataBaseName;
	private String driverClassName;

	@Override
	public void setImportMetadata(AnnotationMetadata importMetadata) {
		Map<String, Object> objectMap = importMetadata.getAnnotationAttributes(EnableSpringDataSource.class.getName());
		AnnotationAttributes annotationAttributes = AnnotationAttributes.fromMap(objectMap);
		if (annotationAttributes == null) {
			throw new RuntimeException("可能没有使用EnableSpringDataSource注解...");
		}
		// 这些属性在EnableSpringDataSource注解中有默认值
		this.username = annotationAttributes.getString("username");
		this.password = annotationAttributes.getString("password");
		this.dataBaseName = annotationAttributes.getString("dataBaseName");
		this.driverClassName = annotationAttributes.getString("driverClassName");
		this.url = annotationAttributes.getString("url");
	}

	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(this.url.replace("dataBaseName", this.dataBaseName));
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}
}
