/**
 * 
 */
package in.techm.assignment.guestbook.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import in.techm.assignment.guestbook.model.utils.APPROVER_ACTION;
import in.techm.assignment.guestbook.model.utils.EntryStatus;

/**
 * @author Nilesh
 *
 */
public class BookEntry implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4973916523927230039L;
	
	private Long id;
	private String text;
	private byte[] image;
	private Long createdBy;
	private Date createdAt;
	private Long approvedBy;
	private Date approvedAt;
	private Date updatedAt;
	private APPROVER_ACTION approverAction;
	private EntryStatus status;
	private GuestbookUser createdByUser;
	private GuestbookUser approvedByUser;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public Long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Long getApprovedBy() {
		return approvedBy;
	}
	public void setApprovedBy(Long approvedBy) {
		this.approvedBy = approvedBy;
	}
	public Date getApprovedAt() {
		return approvedAt;
	}
	public void setApprovedAt(Date approvedAt) {
		this.approvedAt = approvedAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public APPROVER_ACTION getApproverAction() {
		return approverAction;
	}
	public void setApproverAction(APPROVER_ACTION approverAction) {
		this.approverAction = approverAction;
	}
	public EntryStatus getStatus() {
		return status;
	}
	public void setStatus(EntryStatus status) {
		this.status = status;
	}
	public GuestbookUser getCreatedByUser() {
		return createdByUser;
	}
	public void setCreatedByUser(GuestbookUser createdByUser) {
		this.createdByUser = createdByUser;
	}
	public GuestbookUser getApprovedByUser() {
		return approvedByUser;
	}
	public void setApprovedByUser(GuestbookUser approvedByUser) {
		this.approvedByUser = approvedByUser;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BookEntry [id=").append(id).append(", text=").append(text).append(", image=")
				.append(Arrays.toString(image)).append(", createdBy=").append(createdBy).append(", createdAt=")
				.append(createdAt).append(", approvedBy=").append(approvedBy).append(", approvedAt=").append(approvedAt)
				.append(", updatedAt=").append(updatedAt).append(", approverAction=").append(approverAction)
				.append(", status=").append(status).append(", createdByUser=").append(createdByUser)
				.append(", approvedByUser=").append(approvedByUser).append("]");
		return builder.toString();
	}
}