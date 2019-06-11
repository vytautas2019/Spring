package lt.codeacademy.cvbuilder.contact;

import lt.codeacademy.cvbuilder.person.NotFoundException;
import net.bytebuddy.build.Plugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/contacts")
public class ContactController {

    private final ContactService service;

    @Autowired
    public ContactController(ContactService service) {
        this.service = service;
    }

    @GetMapping
    public List<ContactView> getContacts() {
        return service.getContactViews();
    }

    @PostMapping(path = "/add")
    public void addContact(@RequestBody ContactView contact) {
        service.addContact(contact);
    }

    @PutMapping(path = "/update/{id}")
    public void updateContact(@PathVariable("id") int id, @RequestBody ContactView contact) {
        service.updateContact(id, contact);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteContact(@PathVariable("id") int id) {
        service.deleteContact(id);
    }


    @ExceptionHandler({EmptyResultDataAccessException.class, NotFoundException.class})
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public void handleNotFoundException(){

    }

}
