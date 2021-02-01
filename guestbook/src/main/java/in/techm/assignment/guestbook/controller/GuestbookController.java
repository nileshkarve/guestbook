/**
 * 
 */
package in.techm.assignment.guestbook.controller;

import java.util.Date;
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
import in.techm.assignment.guestbook.model.utils.APPROVER_ACTION;
import in.techm.assignment.guestbook.model.utils.EntryStatus;

/**
 * @author Nilesh
 *
 */
@CrossOrigin(origins = "*")
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
	
	@PostMapping("/deleteEntry")
	public void deleteEntry(@RequestBody BookEntry entry) {
		LOG.info("Deleting book entry with id : {}", entry.getId());
		guestBookManager.deleteEntry(entry.getId());
		LOG.info("Deleted book entry with id {}", entry.getId());
	}
	
//	@PutMapping(name = "/approveEntry", path = {"/{id}/{approverId}"})
//	public void approveEntry(@PathVariable("id") Long id, @PathVariable("approverId") Long approverId) {
//		LOG.info("Approving book entry with id : {}", id);
//		guestBookManager.updateEntry(id, approverId, new Date(), APPROVER_ACTION.APPROVE, EntryStatus.APPROVED);
//		LOG.info("Aproved book entry with id {}", id);
//	}
	
	@PostMapping("/approveEntry")
	public void approveEntry(@RequestBody BookEntry entry) {
		LOG.info("Approving book entry with id : {}", entry.getId());
		guestBookManager.updateEntry(entry.getId(), entry.getApprovedBy(), new Date(), APPROVER_ACTION.APPROVE, EntryStatus.APPROVED);
		LOG.info("Aproved book entry with id {}", entry.getId());
	}

	public void setGuestBookManager(GuestBookManager guestBookManager) {
		this.guestBookManager = guestBookManager;
	}

}
