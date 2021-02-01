/**
 * 
 */
package in.techm.assignment.guestbook.security.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import in.techm.assignment.guestbook.model.GuestbookUser;
import in.techm.assignment.guestbook.model.UserCredential;
import in.techm.assignment.guestbook.model.utils.GuestbookUserType;

/**
 * @author Nilesh
 *
 */
public class GuestbookUserMapper implements RowMapper<GuestbookUser> {

	@Override
	public GuestbookUser mapRow(ResultSet rs, int rowNum) throws SQLException {
		GuestbookUser user = new GuestbookUser();
		user.setId(rs.getLong("id"));
		user.setName(rs.getString("name"));
		user.setEmail(rs.getString("email"));
		user.setType(GuestbookUserType.valueOf(rs.getString("type")));
		
		UserCredential credential = new UserCredential();
		credential.setId(rs.getLong("creadentialId"));
		credential.setLoginId(rs.getString("loginId"));
		credential.setUserId(rs.getLong("userId"));
		credential.setPassword(rs.getString("password"));
		user.setCredential(credential);
		
		return user;
	}

}
