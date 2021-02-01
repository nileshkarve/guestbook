/**
 * 
 */
package in.techm.assignment.guestbook.security.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import in.techm.assignment.guestbook.model.GuestbookUser;
import in.techm.assignment.guestbook.security.mapper.GuestbookUserMapper;

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
		StringBuilder queryBuilder = new StringBuilder("SELECT ");
		queryBuilder.append("gbuser.id AS id,");
		queryBuilder.append("gbuser.name AS name,");
		queryBuilder.append("gbuser.email AS email,");
		queryBuilder.append("gbuser.type AS type,");
		
		queryBuilder.append("credential.id AS creadentialId,");
		queryBuilder.append("credential.user_id AS userId,");
		queryBuilder.append("credential.login_id AS loginId,");
		queryBuilder.append("credential.password AS password ");
		
		queryBuilder.append("FROM guestbook_user gbuser JOIN user_credential credential ");
		queryBuilder.append("ON(gbuser.id = credential.user_id) ");
		queryBuilder.append("WHERE credential.login_id = ?");
		
		Object[] args = {username};
		
		List<GuestbookUser> users = guestAppJdbcTemplate.query(queryBuilder.toString(), args, new GuestbookUserMapper());
		return (null != users && !users.isEmpty()) ? users.get(0) : null;
	}

}
