/**
 * 
 */
package in.techm.assignment.guestbook.security.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import in.techm.assignment.guestbook.model.GuestbookUser;

/**
 * @author Nilesh
 *
 */
public class UserDao {
	
	private JdbcTemplate guestAppJdbcTemplate;

	public void setGuestAppJdbcTemplate(JdbcTemplate guestAppJdbcTemplate) {
		this.guestAppJdbcTemplate = guestAppJdbcTemplate;
	}

	public GuestbookUser fetchUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
