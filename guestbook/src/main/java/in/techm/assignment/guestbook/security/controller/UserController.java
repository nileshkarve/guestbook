/**
 * 
 */
package in.techm.assignment.guestbook.security.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.techm.assignment.guestbook.model.GuestbookUser;
import in.techm.assignment.guestbook.security.dao.UserDao;

/**
 * @author Nilesh
 *
 */
@CrossOrigin(origins = "*")
@RestController
public class UserController {
	
	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserDao userDao;
	
	@PostMapping({ "/validateLogin" })
	public GuestbookUser validateLogin(@RequestBody GuestbookUser user) {
		LOG.debug("Fetching user with name : {}", user.getName());
		return userDao.fetchUser(user.getName());
	}
}
