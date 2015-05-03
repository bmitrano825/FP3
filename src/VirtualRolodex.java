import ca.odell.glazedlists.BasicEventList;
import ca.odell.glazedlists.EventList;
import ca.odell.glazedlists.swing.DefaultEventListModel;
import ca.odell.glazedlists.swing.EventListModel;
import ca.odell.glazedlists.swing.GlazedListsSwing;

import javax.swing.*;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Mini-Projects
 * Created by brendanmitrano on 4/2/15.
 */
public class VirtualRolodex extends JPanel {
    private JPanel mainPanel;
    private JTextField txtState;
    private JTextField txtZip;
    public JButton saveButton;
    private JButton deleteButton;
    public JList lstContacts;
    private JTextField txtFirstName;
    private JTextField txtLastName;
    private JTextField txtCompany;
    private JTextField txtAddress;
    private JTextField txtPhoneNumber;
    private JTextField txtFaxNumber;
    private JTextField txtCity;
    private JTextField txtEmail;
    public JButton clearButton;
    private JButton closeButton;
    private JScrollPane contactsHolder;
    private JTextArea txtNotes;
    private EventList issuesEventList = new BasicEventList();

    public VirtualRolodex() {
        saveButton.setEnabled(false);
        lstContacts.setSelectedIndex(0);
        deleteButton.setEnabled(false);


        /**
         * Deletes a contact from the database and list
         */
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Contacts contacts = new Contacts();


                try {
                    ContactsDB database = new ContactsDB();


                    contacts.deleteContact(lstContacts.getSelectedIndex());
                    database.eraseFromDatabase(lstContacts.getSelectedIndex() + 1);

                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        /**
         * Edits the contact and saves it to the database
         */
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Contacts contacts = new Contacts();
                Contact contact = new Contact(txtFirstName.getText(), txtLastName.getText(),
                        txtCompany.getText(), txtPhoneNumber.getText(), txtFaxNumber.getText(),
                        txtEmail.getText(), txtAddress.getText(), txtCity.getText(), txtState.getText(),
                        txtZip.getText(), txtNotes.getText());
                try {
                    ContactsDB database = new ContactsDB();
                    database.writeToDatabase(contact);
                    contacts.editContact(contact);
                    saveButton.setEnabled(false);

                    txtFirstName.setText("");
                    txtLastName.setText("");
                    txtCompany.setText("");
                    txtPhoneNumber.setText("");
                    txtFaxNumber.setText("");
                    txtEmail.setText("");
                    txtAddress.setText("");
                    txtCity.setText("");
                    txtState.setText("");
                    txtZip.setText("");
                    txtNotes.setText("");

                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        lstContacts.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    ContactsDB database = new ContactsDB();

                    System.out.println("selection changed" + " " + lstContacts.getSelectedValue() + " " + lstContacts.getSelectedIndex());

                    if (lstContacts.getSelectedIndex() == 0) {
                        deleteButton.setEnabled(false);
                    } else
                        deleteButton.setEnabled(true);

                    if (lstContacts.getSelectedIndex() != 0) {
                        database.contactInfo.clear();
                        database.loadDatabase(lstContacts.getSelectedIndex());
                        Contact contact = database.contactInfo.get(0);

                        txtFirstName.setText(contact.firstName);
                        txtLastName.setText(contact.lastName);
                        txtCompany.setText(contact.company);
                        txtPhoneNumber.setText(contact.phoneNumber);
                        txtFaxNumber.setText(contact.faxNumber);
                        txtEmail.setText(contact.emailAddress);
                        txtAddress.setText(contact.streetAddress);
                        txtCity.setText(contact.city);
                        txtState.setText(contact.state);
                        txtZip.setText(contact.zipCode);
                        txtNotes.setText(contact.notes);
                    } else {
                        txtFirstName.setText("");
                        txtLastName.setText("");
                        txtCompany.setText("");
                        txtPhoneNumber.setText("");
                        txtFaxNumber.setText("");
                        txtEmail.setText("");
                        txtAddress.setText("");
                        txtCity.setText("");
                        txtState.setText("");
                        txtZip.setText("");
                        txtNotes.setText("");
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

                if (lstContacts.getSelectedIndex() != 0) {
                    clearButton.setVisible(false);
                } else
                    clearButton.setVisible(true);
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtFirstName.setText("");
                txtLastName.setText("");
                txtCompany.setText("");
                txtPhoneNumber.setText("");
                txtFaxNumber.setText("");
                txtEmail.setText("");
                txtAddress.setText("");
                txtCity.setText("");
                txtState.setText("");
                txtZip.setText("");
                txtNotes.setText("");
            }
        });
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ContactsDB database = new ContactsDB();
                    database.closeConnection();
                    System.exit(0);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        txtFirstName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                saveButton.setEnabled(true);
            }
        });
        txtLastName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                saveButton.setEnabled(true);
            }
        });
        txtCompany.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                saveButton.setEnabled(true);
            }
        });
        txtPhoneNumber.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                saveButton.setEnabled(true);
            }
        });
        txtFaxNumber.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                saveButton.setEnabled(true);
            }
        });
        txtEmail.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                saveButton.setEnabled(true);
            }
        });
        txtAddress.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                saveButton.setEnabled(true);
            }
        });
        txtCity.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                saveButton.setEnabled(true);
            }
        });
        txtState.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                saveButton.setEnabled(true);
            }
        });
        txtZip.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                saveButton.setEnabled(true);
            }
        });
        txtNotes.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                saveButton.setEnabled(true);
            }
        });




    }


    public static void main(String[] args) throws SQLException {
        ContactsDB contactsDB = new ContactsDB();
        JFrame frame = new JFrame("VirtualRolodex");
        frame.setContentPane(new VirtualRolodex().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        contactsDB.createContactsTable();
        contactsDB.loadContactsList();


        System.out.println("Press [V] to view all contacts.");
        System.out.println("Press [A] to add a contact.");
        System.out.println("Press [L] to view a list of contacts by company name.");
    }

    public void fillList(EventList<String> contactsList) {
        issuesEventList.clear();
        issuesEventList.addAll(contactsList);
        DefaultEventListModel issuesListModel = new DefaultEventListModel(issuesEventList);
        lstContacts = new JList(issuesListModel);

        for (int i = 0; i < contactsList.size(); i++) {
            System.out.println(issuesEventList.get(i));
        }
    }
}

