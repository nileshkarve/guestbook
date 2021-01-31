/**
 * 
 */
package in.techm.assignment.guestbook.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import in.techm.assignment.guestbook.model.BookEntry;
import in.techm.assignment.guestbook.model.GuestbookUser;
import in.techm.assignment.guestbook.model.utils.APPROVER_ACTION;
import in.techm.assignment.guestbook.model.utils.EntryStatus;
import in.techm.assignment.guestbook.model.utils.GuestbookUserType;

/**
 * @author Nilesh
 *
 */
public class BookEntryMapper implements RowMapper<BookEntry> {

	@Override
	public BookEntry mapRow(ResultSet rs, int rowNum) throws SQLException {
		BookEntry entry = new BookEntry();
		entry.setId(rs.getLong("id"));
		entry.setText(rs.getString("text"));
		entry.setImage(rs.getBytes("image"));
		entry.setApprovedAt(rs.getDate("approvedAt"));
		entry.setApprovedBy(rs.getLong("approvedBy"));
		entry.setApproverAction(APPROVER_ACTION.valueOf(rs.getString("approverAction")));
		entry.setCreatedAt(rs.getDate("createdAt"));
		entry.setCreatedBy(rs.getLong("createdBy"));
		entry.setStatus(EntryStatus.valueOf(rs.getString("status")));
		entry.setUpdatedAt(rs.getDate("updatedAt"));
		
		GuestbookUser creator = new GuestbookUser();
		creator.setId(rs.getLong("creatorId"));
		creator.setName(rs.getString("creatorName"));
		creator.setEmail(rs.getString("creatorEmail"));
		creator.setType(GuestbookUserType.valueOf(rs.getString("creatorType")));
		entry.setCreatedByUser(creator);
		
		GuestbookUser approver = new GuestbookUser();
		approver.setId(rs.getLong("approverId"));
		approver.setName(rs.getString("approverName"));
		approver.setEmail(rs.getString("approverEmail"));
		approver.setType(GuestbookUserType.valueOf(rs.getString("approverType")));
		entry.setApprovedByUser(approver);
		
		return entry;
	}

}
