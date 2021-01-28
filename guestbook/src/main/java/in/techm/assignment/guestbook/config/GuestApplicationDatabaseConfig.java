/**
 * 
 */
package in.techm.assignment.guestbook.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import liquibase.integration.spring.SpringLiquibase;

/**
 * @author Nilesh
 *
 */
@Configuration
@PropertySource("classpath:config/database.properties")
public class GuestApplicationDatabaseConfig {
	
	@Value("${guest.app.database.driver.class.name}")
	private String guestAppDBDriverClassName;
	@Value("${guest.app.database.url}")
	private String guestAppDBURL;
	@Value("${guest.app.database.user.name}")
	private String guestAppDBUserName;
	@Value("${guest.app.database.password}")
	private String guestAppDBPswrd;
	
	@Bean("guestAppDatasource")
	public DataSource guestAppDatasource() {
		DataSourceBuilder<?> builder = DataSourceBuilder.create();
		builder.driverClassName(guestAppDBDriverClassName);
		builder.url(guestAppDBURL);
		builder.username(guestAppDBUserName);
		builder.password(guestAppDBPswrd);
		return builder.build();
	}
	
	@Bean("guestAppJdbcTemplate")
	public JdbcTemplate guestAppJdbcTemplate(@Qualifier("guestAppDatasource") DataSource guestAppDatasource) {
		JdbcTemplate guestAppJdbcTemplate = new JdbcTemplate(guestAppDatasource);
		return guestAppJdbcTemplate;
	}
	
	@Bean("guestAppLiquibase")
	public SpringLiquibase guestAppLiquibase(@Qualifier("guestAppDatasource") DataSource guestAppDatasource) {
		SpringLiquibase guestAppLiquibase = new SpringLiquibase();
		guestAppLiquibase.setChangeLog("classpath:liquibase/guest-app-changelog.xml");
		guestAppLiquibase.setDataSource(guestAppDatasource);
		return guestAppLiquibase;
	}

}
