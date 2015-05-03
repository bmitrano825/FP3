import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Mini-Projects
 * Created by brendanmitrano on 4/15/15.
 */
public class Contacts extends VirtualRolodex{
    /**
     * Creates a new contact and adds it to the database.
     */
    public void createContact() throws SQLException {
//        ContactsDB database = new ContactsDB();
    }

    /**
     * Deletes a contact from the listbox and the database.
     */
    public void deleteContact(int index) throws SQLException {
        ContactsDB database = new ContactsDB();
        database.eraseFromDatabase(index);
    }

    /**
     * Edits a contact on the list and in the database.
     */
    public void editContact(Contact contact) throws SQLException {

        ContactsDB contactsDB = new ContactsDB();

        try{
            contactsDB.updateExistingContact(contact);
        }
        catch(SQLException e){

        }
    }
}
