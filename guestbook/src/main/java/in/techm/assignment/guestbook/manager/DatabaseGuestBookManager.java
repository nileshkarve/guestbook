/**
 * 
 */
package in.techm.assignment.guestbook.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.techm.assignment.guestbook.dao.GuestBookDao;
import in.techm.assignment.guestbook.model.BookEntry;

/**
 * @author Nilesh
 *
 */
@Component("databaseGuestBookManager")
public class DatabaseGuestBookManager implements GuestBookManager {
	
	@Autowired
	private GuestBookDao guestBookDao;

	@Override
	public List<BookEntry> getEntries() {
		return guestBookDao.getEntries();
	}

	@Override
	public void addEntry(BookEntry entry) {
		guestBookDao.addEntry(entry);
	}

	@Override
	public void deleteEntry(Long id) {
		guestBookDao.deleteEntry(id);
	}

	@Override
	public void updateEntry(BookEntry entry) {
		guestBookDao.updateEntry(entry);
	}

	public void setGuestBookDao(GuestBookDao guestBookDao) {
		this.guestBookDao = guestBookDao;
	}

}
