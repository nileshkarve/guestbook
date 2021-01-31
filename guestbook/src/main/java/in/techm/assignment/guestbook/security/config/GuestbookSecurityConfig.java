/**
 * 
 */
package in.techm.assignment.guestbook.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Nilesh
 *
 */
@Configuration
@EnableWebSecurity
public class GuestbookSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable().

		authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/**").permitAll().anyRequest().authenticated()
		.and().httpBasic();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("nilesh").password("$2a$10$iwjlN4pQy6O8gC.X6SUWf.oUuJcnMQeFqKqdhUOpv5yxwQCh7wI1G").roles("USER");
	}
	
//	@Bean("userService")
//    public UserService userService(@Qualifier("userDao") UserDao userDao) {
//    	UserService userService = new UserService();
//    	userService.setUserDao(userDao);
//    	return userService;
//    }
//
	@Bean("passwordEncoder")
    public PasswordEncoder passwordEncoder() {
    	return new BCryptPasswordEncoder();
    }
//    
//    @Bean("userDao")
//    public UserDao userDao(@Qualifier("guestAppJdbcTemplate") JdbcTemplate guestAppJdbcTemplate) {
//    	UserDao userDao = new UserDao();
//    	userDao.setGuestAppJdbcTemplate(guestAppJdbcTemplate);
//    	return userDao;
//    }
}
