/**
 * Contact
 * This manages the data structure for an individual contact. This skeleton includes a readContact
 * method to keep all the details of how many fields are in a contact in one place, and does not 
 * currently therefore need constructors or set Methods which could be added if needed. Only one 
 * get Method is currently needed for the last name.
 * EToolis
 */
import java.io.PrintStream;
import java.util.Scanner;

public class Contact implements Comparable<Contact>, java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String streetAddress;
	private String emailAddress;
	private String phoneNumber;
	private String notes;

	private static final String FIRST_NAME_PROMPT = "First Name: ";
	private static final String LAST_NAME_PROMPT = "Last Name: ";
	private static final String STREET_ADDRESS_PROMPT = "Street Address: ";
	private static final String EMAIL_ADDRESS_PROMPT = "Email Address: ";
	private static final String PHONE_NUMBER_PROMPT = "Phone Number: ";
	private static final String NOTES_PROMPT = "Notes: ";

	/**
	 * Read a contact from in using the prompt strings, printed to out,
	 * populating all the private variables. Doing the read inside this class
	 * will make the program more malleable and easier to extend, keeps prompts
	 * and everything else in one place. @eToolis
	 */
	public boolean readContact(PrintStream output, Scanner input) {
		output.print(FIRST_NAME_PROMPT);
		firstName = input.nextLine();
		output.print(LAST_NAME_PROMPT);
		lastName = input.nextLine();
		if (lastName.equals(""))
			return false;
		output.print(STREET_ADDRESS_PROMPT);
		streetAddress = input.nextLine();
		output.print(EMAIL_ADDRESS_PROMPT);
		emailAddress = input.nextLine();
		output.print(PHONE_NUMBER_PROMPT);
		phoneNumber = input.nextLine();
		output.print(NOTES_PROMPT);
		notes = input.nextLine();
		output.println();
		return true;
		
	}

	/**
	 * Returns a string for displaying the contact for when you want to either
	 * print or display an individual contact. @cVasquez
	 */
	public String toString() {
		
		return "Name:            " + firstName + " " + lastName + "\n" + STREET_ADDRESS_PROMPT + " "
				 + streetAddress + "\n" + EMAIL_ADDRESS_PROMPT + "  " + emailAddress + "\n" + 
				PHONE_NUMBER_PROMPT +"   " + phoneNumber + "\n" + 
				NOTES_PROMPT +"          " + notes + " \n";
	
	}

	/**
	 * getLastName, basic method so that other methods so that they can get a Contact's
	 * lastName easily use it to get the last name easily @cVasquez
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * getFirstName, same as getLastName - simply to be used in other methods so they can get
	 * the a Contact's firstName easily @cVasquez
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * compareTo method - used to sort the Contact List, this method is used in printContactList
	 * This method also makes sure that the sorting ignores capitalization of names, just sorts them 
	 * alphabetically @sKyoung
	 */
	public int compareTo(Contact newContact) { 
		
		if (lastName.compareToIgnoreCase(newContact.getLastName()) == 0) { 
			return firstName.compareToIgnoreCase(newContact.getFirstName());
		}   else {
			return lastName.compareToIgnoreCase(newContact.getLastName());
		}
	}

	/**
	 * Test if two objects match, if they match, regardless of capitalization return true.
	 * If they do not match return false. Used in method - searchAndPrintByName.  @sKyoung
	 */
	public boolean matches(String name) {
		return (this.lastName.equalsIgnoreCase(name));
	}
}
