/**
 * 
 */
package in.techm.assignment.guestbook.manager;

import java.util.Date;
import java.util.List;

import in.techm.assignment.guestbook.model.BookEntry;
import in.techm.assignment.guestbook.model.utils.APPROVER_ACTION;
import in.techm.assignment.guestbook.model.utils.EntryStatus;

/**
 * @author Nilesh
 *
 */
public interface GuestBookManager {
	
	public List<BookEntry> getEntries();
	
	public void addEntry(BookEntry entry);
	
	public void deleteEntry(Long id);
	
	public void updateEntry(Long id, Long approverId, Date approvedAt, APPROVER_ACTION action, EntryStatus status);

}
