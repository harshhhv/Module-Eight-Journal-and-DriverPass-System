import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    @Test
    void testAddContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main Street");
        service.addContact(contact);
    }

    @Test
    void testAddDuplicateContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main Street");
        service.addContact(contact);

        assertThrows(IllegalArgumentException.class, () -> service.addContact(contact));
    }

    @Test
    void testDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main Street");
        service.addContact(contact);
        service.deleteContact("1");
    }

    @Test
    void testUpdateContactFields() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main Street");
        service.addContact(contact);

        service.updateFirstName("1", "Jane");
        service.updateLastName("1", "Smith");
        service.updatePhone("1", "0987654321");
        service.updateAddress("1", "456 New Street");

        assertEquals("Jane", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("0987654321", contact.getPhone());
        assertEquals("456 New Street", contact.getAddress());
    }
}
