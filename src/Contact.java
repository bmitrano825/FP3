/**
 * Mini-Projects
 * Created by brendan mitrano on 4/2/15.
 */
public class Contact extends VirtualRolodex{
    public String firstName;
    public String lastName;
    public String company;
    public String phoneNumber;
    public String faxNumber;
    public String emailAddress;
    public String streetAddress;
    public String city;
    public String state;
    public String zipCode;
    public String notes;

    /**
     * The main class.
     *
     */
    public Contact(String firstName, String lastName, String company,
                   String phoneNumber, String faxNumber, String emailAddress, String streetAddress,
                   String city, String state, String zipCode, String notes)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.phoneNumber = phoneNumber;
        this.faxNumber = faxNumber;
        this.emailAddress = emailAddress;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.notes = notes;
    }

    /**
     * Gets the contacts first name.
     * @return The contacts first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the contacts first name.
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the contacts last name.
     * @return The contacts last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the contacts last name.
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the contacts company.
     * @return The contacts company
     */
    public String getCompany() {
        return company;
    }

    /**
     * Sets the contacts company name.
     * @param company
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * Gets the contacts phone number.
     * @return The contacts phone number.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the contacts phone number.
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the contacts phone number.
     * @return The contacts phone number.
     */
    public String getFaxNumber() {
        return faxNumber;
    }

    /**
     * Sets the contacts fax number.
     * @param faxNumber
     */
    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    /**
     * Gets a contacts email address.
     * @return The contacts email address
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Sets the Contacts email address.
     * @param emailAddress
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    /**
     * Gets the contacts street address.
     * @return The contacts street address.
     */
    public String getStreetAddress() {
        return streetAddress;
    }

    /**
     * Sets the contacts street address.
     * @param streetAddress
     */
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    /**
     * Gets the contacts city name.
     * @return The contacts city name.
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the contacts city name.
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the contacts state name.
     * @return The contacts state name.
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the contacts state name.
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets the contacts zip code.
     * @return The contacts zip code.
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Sets the contacts zip code.
     * @param zipCode
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * Gets the contacts tags
     * @return The contacts tags.
     */
    public String getNotes() {
        return notes;
    }

    /**
     * Sets the contacts tags.
     * @param tags
     */
    public void setNotes(String tags) {
        this.notes = notes;
    }
}
