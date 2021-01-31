///**
// * 
// */
//package in.techm.assignment.guestbook.security.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import in.techm.assignment.guestbook.security.service.UserService;
//
///**
// * @author Nilesh
// *
// */
////@Configuration
////@EnableWebSecurity
//public class GuestbookWebSecurityConfig extends WebSecurityConfigurerAdapter {
//	
//	private UserService userService;
//	private PasswordEncoder passwordEncoder;
//	
//	public GuestbookWebSecurityConfig(UserService userService, PasswordEncoder passwordEncoder) {
//		this.userService = userService;
//		this.passwordEncoder = passwordEncoder;
//	}
//	
//	@Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) 
//      throws Exception {
//        http.csrf().disable()
//          .authorizeRequests()
//          .antMatchers("/admin/**").hasRole("ROLE_ADMIN")
//          .antMatchers("/login").permitAll()
//          .anyRequest()
//          .authenticated()
//          .and()
//          .httpBasic();
//    }
//}
