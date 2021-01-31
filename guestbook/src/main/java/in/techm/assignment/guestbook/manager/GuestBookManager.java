/**
 * 
 */
package in.techm.assignment.guestbook.manager;

import java.util.List;

import in.techm.assignment.guestbook.model.BookEntry;

/**
 * @author Nilesh
 *
 */
public interface GuestBookManager {
	
	public List<BookEntry> getEntries();
	
	public void addEntry(BookEntry entry);
	
	public void deleteEntry(Long id);
	
	public void updateEntry(BookEntry entry);

}
