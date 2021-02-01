/**
 * 
 */
package in.techm.assignment.guestbook.security.service;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import in.techm.assignment.guestbook.model.GuestbookUser;
import in.techm.assignment.guestbook.security.dao.UserDao;

/**
 * @author Nilesh
 *
 */
@Component("userService")
public class UserService implements UserDetailsService {
	
	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		GuestbookUser guestbookUser = userDao.fetchUser(username);
		LOG.debug("User detailes found in database with user name {} : {}", username, guestbookUser);
		if(null == guestbookUser) {
			throw new BadCredentialsException("Unable to find user");
		}
		Set<GrantedAuthority> authorities = new HashSet<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_"+guestbookUser.getType()));
		User user = new User(guestbookUser.getCredential().getLoginId(), guestbookUser.getCredential().getPassword(), authorities);
		return user;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
