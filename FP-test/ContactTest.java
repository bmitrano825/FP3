import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContactTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testGetFirstName() throws Exception {
        Contact contact = new Contact("Brendan","Mitrano","Hairmate",
                "9785042391","2521515151","bmitrano@live.com","","","","","");



        assertSame(contact.getFirstName(),"Brendan");

    }

    @Test
    public void testSetFirstName() throws Exception {
        Contact contact = new Contact("Brendan","Mitrano","Hairmate",
                "9785042391","2521515151","bmitrano@live.com","","","","","");

        contact.setFirstName("Jane");

        assertSame(contact.firstName, "Jane");
    }

    @Test
    public void testGetLastName() throws Exception {
        Contact contact = new Contact("Brendan","Mitrano","Hairmate",
                "9785042391","2521515151","bmitrano@live.com","","","","","");

        assertSame(contact.getLastName(),"Mitrano");
    }

    @Test
    public void testSetLastName() throws Exception {
        Contact contact = new Contact("Brendan","Mitrano","Hairmate",
                "9785042391","2521515151","bmitrano@live.com","","","","","");

        contact.setLastName("Jane");

        assertSame(contact.lastName, "Jane");
    }

    @Test
    public void testGetCompany() throws Exception {
        Contact contact = new Contact("Brendan","Mitrano","Hairmate",
                "9785042391","2521515151","bmitrano@live.com","","","","","");

        assertSame(contact.getCompany(),"Hairmate");
    }

    @Test
    public void testSetCompany() throws Exception {
        Contact contact = new Contact("Brendan","Mitrano","Hairmate",
                "9785042391","2521515151","bmitrano@live.com","","","","","");

        contact.setCompany("Jane");

        assertSame(contact.company, "Jane");
    }

    @Test
    public void testGetPhoneNumber() throws Exception {
        Contact contact = new Contact("Brendan","Mitrano","Hairmate",
                "9785042391","2521515151","bmitrano@live.com","","","","","");

        assertSame(contact.getPhoneNumber(),"9785042391");
    }

    @Test
    public void testSetPhoneNumber() throws Exception {
        Contact contact = new Contact("Brendan","Mitrano","Hairmate",
                "9785042391","2521515151","bmitrano@live.com","","","","","");

        contact.setPhoneNumber("Jane");

        assertSame(contact.phoneNumber, "Jane");
    }

    @Test
    public void testGetFaxNumber() throws Exception {
        Contact contact = new Contact("Brendan","Mitrano","Hairmate",
                "9785042391","2521515151","bmitrano@live.com","","","","","");

        assertSame(contact.getFaxNumber(),"2521515151");
    }

    @Test
    public void testSetFaxNumber() throws Exception {
        Contact contact = new Contact("Brendan","Mitrano","Hairmate",
                "9785042391","2521515151","bmitrano@live.com","","","","","");

        contact.setFaxNumber("Jane");

        assertSame(contact.faxNumber, "Jane");
    }

    @Test
    public void testGetEmailAddress() throws Exception {
        Contact contact = new Contact("Brendan","Mitrano","Hairmate",
                "9785042391","2521515151","bmitrano@live.com","","","","","");

        assertSame(contact.getEmailAddress(),"bmitrano@live.com");
    }

    @Test
    public void testSetEmailAddress() throws Exception {
        Contact contact = new Contact("Brendan","Mitrano","Hairmate",
                "9785042391","2521515151","bmitrano@live.com","","","","","");

        contact.setEmailAddress("Jane");

        assertSame(contact.emailAddress, "Jane");
    }

    @Test
    public void testGetStreetAddress() throws Exception {
        Contact contact = new Contact("Brendan","Mitrano","Hairmate",
                "9785042391","2521515151","bmitrano@live.com","4 liberty lane","","","","");

        assertSame(contact.getStreetAddress(),"4 liberty lane");
    }

    @Test
    public void testSetStreetAddress() throws Exception {
        Contact contact = new Contact("Brendan","Mitrano","Hairmate",
                "9785042391","2521515151","bmitrano@live.com","","","","","");

        contact.setStreetAddress("4 liberty lane");

        assertSame(contact.streetAddress, "4 liberty lane");
    }

    @Test
    public void testGetCity() throws Exception {
        Contact contact = new Contact("Brendan","Mitrano","Hairmate",
                "9785042391","2521515151","bmitrano@live.com","","north reading","","","");

        assertSame(contact.getCity(),"north reading");
    }

    @Test
    public void testSetCity() throws Exception {
        Contact contact = new Contact("Brendan","Mitrano","Hairmate",
                "9785042391","2521515151","bmitrano@live.com","","","","","");

        contact.setCity("NR");

        assertSame(contact.city, "NR");
    }

    @Test
    public void testGetState() throws Exception {
        Contact contact = new Contact("Brendan","Mitrano","Hairmate",
                "9785042391","2521515151","bmitrano@live.com","","","MA","","");

        assertSame(contact.getState(),"MA");
    }

    @Test
    public void testSetState() throws Exception {
        Contact contact = new Contact("Brendan","Mitrano","Hairmate",
                "9785042391","2521515151","bmitrano@live.com","","","","","");

        contact.setState("MA");

        assertSame(contact.state, "MA");
    }

    @Test
    public void testGetZipCode() throws Exception {
        Contact contact = new Contact("Brendan","Mitrano","Hairmate",
                "9785042391","2521515151","bmitrano@live.com","","","","01864","");

        assertSame(contact.getZipCode(),"01864");
    }

    @Test
    public void testSetZipCode() throws Exception {
        Contact contact = new Contact("Brendan","Mitrano","Hairmate",
                "9785042391","2521515151","bmitrano@live.com","","","","01864","");

        contact.setZipCode("01864");

        assertSame(contact.zipCode, "01864");
    }

    @Test
    public void testGetTags() throws Exception {
        Contact contact = new Contact("Brendan","Mitrano","Hairmate",
                "9785042391","2521515151","bmitrano@live.com","","","","","Brendan");

        assertSame(contact.getTags(),"Brendan");
    }

    @Test
    public void testSetTags() throws Exception {
        Contact contact = new Contact("Brendan","Mitrano","Hairmate",
                "9785042391","2521515151","bmitrano@live.com","","","","","");

        contact.setTags("Brendan");

        assertSame(contact.tags, "Brendan");
    }
}