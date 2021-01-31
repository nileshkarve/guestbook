/**
 * 
 */
package in.techm.assignment.guestbook.dao;

import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import in.techm.assignment.guestbook.dao.mapper.BookEntryMapper;
import in.techm.assignment.guestbook.model.BookEntry;
import in.techm.assignment.guestbook.model.utils.EntryStatus;

/**
 * @author Nilesh
 *
 */
public class GuestBookDao {
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<BookEntry> getEntries() {
		StringBuilder queryBuilder = new StringBuilder("SELECT ");
		queryBuilder.append("entry.id AS id,");
		queryBuilder.append("entry.entry_text AS text,");
		queryBuilder.append("entry.entry_img AS image,");
		queryBuilder.append("entry.created_by AS createdBy,");
		queryBuilder.append("entry.created_at AS createdAt,");
		queryBuilder.append("entry.updated_at AS updatedAt,");
		queryBuilder.append("entry.approved_by AS approvedBy,");
		queryBuilder.append("entry.approved_at AS approvedAt,");
		queryBuilder.append("entry.approver_action AS approverAction,");
		queryBuilder.append("entry.status AS status,");
		queryBuilder.append("creator.id AS creatorId,");
		queryBuilder.append("creator.name AS creatorName,");
		queryBuilder.append("creator.email AS creatorEmail,");
		queryBuilder.append("creator.type AS creatorType,");
		queryBuilder.append("approver.type AS approverType,");
		queryBuilder.append("approver.id AS approverId,");
		queryBuilder.append("approver.name AS approverName,");
		queryBuilder.append("approver.email AS approverEmail ");
		queryBuilder.append("FROM book_entry entry JOIN guestbook_user creator ");
		queryBuilder.append("ON(entry.created_by = creator.id) ");
		queryBuilder.append("JOIN guestbook_user approver ");
		queryBuilder.append("ON(entry.created_by = approver.id)");
		return jdbcTemplate.query(queryBuilder.toString(), new BookEntryMapper());
	}

	public void addEntry(BookEntry entry) {
		String query = "INSERT INTO book_entry(entry_text, entry_img, created_by, created_at, status)VALUES(?,?,?,?,?)";
		Object[] args = {entry.getText(), entry.getImage(), entry.getCreatedBy(), new Date(), EntryStatus.NEW};
		jdbcTemplate.update(query, args);
	}

	public void deleteEntry(Long id) {
		String query = "DELETE FROM book_entry WHERE id = ?";
		Object[] args = {id};
		jdbcTemplate.update(query, args);
	}

	public void updateEntry(BookEntry entry) {
		// TODO Auto-generated method stub
		
	}

}
