/**
 * 
 */
package in.techm.assignment.guestbook.model;

import java.io.Serializable;

/**
 * @author Nilesh
 *
 */
public class UserCredential implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4768423954286319112L;
	
	private Long id;
	private Long userId;
	private String loginId;
	private String password;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserCredential [id=").append(id).append(", userId=").append(userId).append(", loginId=")
				.append(loginId).append(", password=").append(password).append("]");
		return builder.toString();
	}
}
