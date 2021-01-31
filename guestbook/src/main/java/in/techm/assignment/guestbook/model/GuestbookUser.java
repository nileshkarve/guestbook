/**
 * 
 */
package in.techm.assignment.guestbook.model;

import java.io.Serializable;

import in.techm.assignment.guestbook.model.utils.GuestbookUserType;

/**
 * @author Nilesh
 *
 */
public class GuestbookUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7428489580989082341L;
	
	private Long id;
	private String name;
	private String email;
	private GuestbookUserType type;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public GuestbookUserType getType() {
		return this.type;
	}
	
	public void setType(GuestbookUserType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GuestbookUser [id=").append(id).append(", name=").append(name).append(", email=").append(email)
				.append(", type=").append(type).append("]");
		return builder.toString();
	}

}
