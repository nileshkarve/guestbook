///**
// * 
// */
//package in.techm.assignment.guestbook.security.service;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import in.techm.assignment.guestbook.security.dao.UserDao;
//
///**
// * @author Nilesh
// *
// */
//public class UserService implements UserDetailsService {
//	
//	private UserDao userDao;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
////		GuestbookUser guestbookUser = userDao.fetchUser(username);
////		if(null == guestbookUser) {
////			throw new BadCredentialsException("Unable to find user");
////		}
//		Set<GrantedAuthority> authorities = new HashSet<>();
//		authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
////		authorities.add(new SimpleGrantedAuthority("ROLE_"+guestbookUser.getType()));
////		User user = new User(guestbookUser.getEmail(), guestbookUser., authorities);
//		User user = new User("nileshkarve", "nileshkarve", authorities);
//		return user;
//	}
//
//	public void setUserDao(UserDao userDao) {
//		this.userDao = userDao;
//	}
//
//}
