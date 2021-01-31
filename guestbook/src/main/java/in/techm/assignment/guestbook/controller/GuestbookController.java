/**
 * 
 */
package in.techm.assignment.guestbook.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.techm.assignment.guestbook.manager.GuestBookManager;
import in.techm.assignment.guestbook.model.BookEntry;

/**
 * @author Nilesh
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class GuestbookController {
	
	private static final Logger LOG = LoggerFactory.getLogger(GuestbookController.class);
	
	@Autowired
	private GuestBookManager guestBookManager;
	
	@GetMapping("/bookEntry")
	public List<BookEntry> getBookEntries() {
		return guestBookManager.getEntries();
	}
	
	@PostMapping("/addEntry")
	public void addEntry(@RequestBody BookEntry entry) {
		LOG.info("Creating book entry : {}", entry);
		guestBookManager.addEntry(entry);
		LOG.info("Book entry added successfully.");
	}
	
	@DeleteMapping(name = "/deleteEntry", path = "/{id}")
	public void deleteEntry(@PathVariable("id") Long id) {
		LOG.info("Deleting book entry with id : {}", id);
		guestBookManager.deleteEntry(id);
		LOG.info("Deleted book entry with id {}", id);
	}

	public void setGuestBookManager(GuestBookManager guestBookManager) {
		this.guestBookManager = guestBookManager;
	}

}
