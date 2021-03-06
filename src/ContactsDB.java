import ca.odell.glazedlists.BasicEventList;
import ca.odell.glazedlists.EventList;

import java.awt.image.DataBufferShort;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.*;
import java.sql.*;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.*;
import java.util.List;

/**
 * Mini-Projects
 * Created by brendanmitrano on 4/2/15.
 */
public class ContactsDB extends VirtualRolodex {
    private final static String DB_NAME = "contacts.db";
    private final static String JDBC = "jdbc:sqlite";
    private final static String DB_URL = JDBC + ":" + DB_NAME;
    private Connection dbConnection;
    ArrayList<String> contactList = new ArrayList<String>();
    ArrayList<Contact> contactInfo = new ArrayList<Contact>();


    /**
     * Sets up the connection to the database.
     *
     * @throws Exception if a connection cannot be made to the database.
     */
    public ContactsDB() throws SQLException {
        // Try connecting to the database.
        try {
            dbConnection = DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            System.err.println("Couldn't connect to the DB in ContactsDB.");
            throw e;
        }
    }

    /**
     * Closes the database connection.
     *
     * @throws SQLException
     */
    public void closeConnection() throws SQLException {
        try {
            dbConnection.close();
        } catch (SQLException e) {
            System.err.println("Couldn't close connection to DB in UsersDB.");
            throw e;
        }
    }

    ;

    /**
     * Creates the Contacts table in the database if it doesn't already exist.
     *
     * @throws SQLException
     */
    public void createContactsTable() throws SQLException {
        Statement statement = dbConnection.createStatement();
        String createTableStatement = "create table if not exists contacts(" +
                "firstName text,  lastName text, companyName text, " +
                "phoneNumber text, faxNumber text, email text, address text, " +
                "city text, state text, zip text, notes text);";

        try {
            statement.executeUpdate(createTableStatement);

        } catch (SQLException e) {
            System.err.println("Trouble creating contacts table " +
                    "ContactsDB.createContactsTable.");
            throw e;
        } finally {
            statement.close();
        }
    }

    /**
     * Returns a list of all users in the database.
     *
     * @return A list of all users in the database.
     * @throws SQLException
     */
    public ArrayList<Contact> getContactList() throws SQLException {
        ArrayList<Contact> contactsList = new ArrayList<Contact>();
        Statement statement = dbConnection.createStatement();
        String query = "select * from contacts";
        ResultSet results;

        try {
            results = statement.executeQuery(query);
            try {
                while (results.next()) {
                    Contact contact = new Contact(
                            results.getString("firstName"),
                            results.getString("lastName"),
                            results.getString("companyName"),
                            results.getString("phoneNumber"),
                            results.getString("faxNumber"),
                            results.getString("email"),
                            results.getString("address"),
                            results.getString("city"),
                            results.getString("state"),
                            results.getString("zip"),
                            results.getString("notes")
                    );
                    contactsList.add(contact);
                }
            } catch (SQLException e) {
                System.err.println("Trouble accessing iterating through " +
                        "results in ContactsDB.getAllContacts.");
                throw e;
            } finally {
                results.close();
            }
        } catch (SQLException e) {
            System.err.println("Trouble accessing getting results in " +
                    "ContactsDB.getAllContacts.");
            throw e;
        } finally {
            statement.close();
        }

        return contactsList;
    }

    /**
     * Inserts a new user into the database.
     *
     * @param contact The contact to add.
     * @throws SQLException
     */
    public void writeToDatabase(Contact contact) throws SQLException {
            String insertStatement = "insert into contacts values(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement statement =
                    dbConnection.prepareStatement(insertStatement);

            try {
                statement.setString(1, contact.firstName);
                statement.setString(2, contact.lastName);
                statement.setString(3, contact.company);
                statement.setString(4, contact.phoneNumber);
                statement.setString(5, contact.faxNumber);
                statement.setString(6, contact.emailAddress);
                statement.setString(7, contact.streetAddress);
                statement.setString(8, contact.city);
                statement.setString(9, contact.state);
                statement.setString(10, contact.zipCode);
                statement.setString(11, contact.notes);

                statement.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Trouble inserting user into table in " +
                        "ContactsDB.writeToDatabase; Contact: " + contact.firstName + contact.lastName);
                throw e;
            } finally {
                statement.close();
            }
    }

    /**
     * Updates the existing contacts information.
     *
     * @param contact
     * @throws SQLException
     */
    public void updateExistingContact(Contact contact) throws SQLException {
        Statement statement = dbConnection.createStatement();
        eraseFromDatabase(lstContacts.getSelectedIndex());
//        writeToDatabase(contact);

//        try {
//            statement.executeUpdate("UPDATE contacts SET " +
//                    "firstName= '" + contact.firstName + "', "+
//                    "lastName= '" + contact.lastName + "', " +
//                    "companyName= '" + contact.company+"', " +
//                    "phoneNumber= '" + contact.phoneNumber+"', " +
//                    "faxNumber= '" + contact.faxNumber+"', " +
//                    "email= '" + contact.emailAddress+"', " +
//                    "address= '" + contact.streetAddress+"', " +
//                    "city= '" + contact.city+"', " +
//                    "state= '" + contact.state+"', " +
//                    "zip= '" + contact.zipCode+"', " +
//                    "notes= '" + contact.notes + " WHERE rowid=" + lstContacts.getSelectedIndex() +";");
//
//            loadContactsList();
//        } catch (SQLException e) {
//
//        }


    }

    /**
     * Loads the contact from the database based on their id which
     * is assigned automatically.
     */
    public ArrayList<Contact> loadDatabase(int index) throws SQLException {
        ResultSet results;

        Statement statement = dbConnection.createStatement();
        if (index > 0) {
            String query = "SELECT * FROM contacts WHERE rowid=" + index + ";";

            try {
                results = statement.executeQuery(query);
                try {
                    while (results.next()) {
                        Contact contact = new Contact(
                                results.getString("firstName"),
                                results.getString("lastName"),
                                results.getString("companyName"),
                                results.getString("phoneNumber"),
                                results.getString("faxNumber"),
                                results.getString("email"),
                                results.getString("address"),
                                results.getString("city"),
                                results.getString("state"),
                                results.getString("zip"),
                                results.getString("notes")
                        );

                        contactInfo.add(contact);
                    }
                } catch (SQLException e) {
                    System.err.println("Trouble accessing iterating through " +
                            "results in UsersDB.getAllUsers.");
                    throw e;
                } finally {
                    results.close();
                }
            } catch (SQLException e) {
                System.err.println("Trouble accessing getting results in " +
                        "UsersDB.getAllUsers.");
                throw e;
            } finally {
                statement.close();
            }

        }
        return contactInfo;
    }

    /**
     * Loads the contact list array with contact info.
     *
     * @return The list of contacts.
     * @throws SQLException
     */
    public void loadContactsList() throws SQLException {
        ResultSet results;
        resortContacts();
        Statement statement = dbConnection.createStatement();
        String query = "SELECT companyName,firstName,lastName FROM contacts;";

        contactList.clear();
        try {
            results = statement.executeQuery(query);
            try {
                while (results.next()) {
                    String company = results.getString("companyName");
                    String first = results.getString("firstName");
                    String last = results.getString("lastName");
                    contactList.add(company + ": " + last + ", " + first);
                }

                contactList.add(0,"New Contact");
                fillList(contactList);


            } catch (SQLException e) {
                System.err.println("Trouble accessing iterating through " +
                        "results in UsersDB.getAllUsers.");
                throw e;
            } finally {
                results.close();
            }
        } catch (SQLException e) {
            System.err.println("Trouble accessing getting results in " +
                    "ContactsDB.loadContactsList()");
            throw e;
        } finally {
            statement.close();
        }
    }

    /**
     * Erases the contact from the database based on their
     * id which is assigned automatically.
     */
    public void eraseFromDatabase(int index) throws SQLException {
        Statement statement = dbConnection.createStatement();
        String deleteContact = "DELETE FROM contacts WHERE rowid=" + index + ";";

        try {
            statement.executeUpdate(deleteContact);
            loadContactsList();
            resortContacts();
        } catch (SQLException e) {
            System.err.println("Trouble deleting from database " +
                    "ContactsDB.eraseFromDatabase.");
            throw e;
        } finally {
            statement.close();
        }

    }

    /**
     * Re-sorts the contact list after an item is deleted or added.
     *
     * @throws SQLException
     */
    public void resortContacts() throws SQLException {
        Statement statement = dbConnection.createStatement();
        String sortContents = "SELECT * FROM contacts ORDER BY companyName ASC;";
        String vacuumContents = "VACUUM contacts;";

        try {
            statement.executeUpdate(sortContents);
            statement.executeUpdate(vacuumContents);
        } catch (SQLException e) {
            System.err.println("Trouble deleting from database " +
                    "ContactsDB.eraseFromDatabase.");
            throw e;
        }
    }
}
