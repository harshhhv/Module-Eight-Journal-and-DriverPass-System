import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    void testValidContactCreation() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main Street");
        assertEquals("12345", contact.getContactId());
    }

    @Test
    void testInvalidContactId() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact(null, "John", "Doe", "1234567890", "123 Main Street"));
    }

    @Test
    void testInvalidFirstName() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", null, "Doe", "1234567890", "123 Main Street"));
    }

    @Test
    void testInvalidLastName() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", "John", null, "1234567890", "123 Main Street"));
    }

    @Test
    void testInvalidPhone() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", "John", "Doe", "12345", "123 Main Street"));
    }

    @Test
    void testInvalidAddress() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", "John", "Doe", "1234567890",
                        "This address is way too long and exceeds thirty characters"));
    }
}
