/**
 * 
 */
package in.techm.assignment.guestbook.security.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.techm.assignment.guestbook.model.GuestbookUser;

/**
 * @author Nilesh
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {
	
//	@GetMapping(produces = "application/json")
	@RequestMapping({ "/validateLogin" })
	public GuestbookUser validateLogin() {
		GuestbookUser user = new GuestbookUser();
		user.setId(1L);
		user.setName("Nilesh");
		return user;
	}

}
