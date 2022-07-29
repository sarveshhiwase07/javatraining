import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListTest {
	public static void main(String[] args) {
		PhoneContact contact1 = new PhoneContact("Amol","Aurangabad", "813465646", "amol@gmail.com");
		PhoneContact contact2 = new PhoneContact("Guru","Heaven", "813465646", "amol@gmail.com");
		PhoneContact contact3 = new PhoneContact("Dhamma","Aurangabad", "813465646", "amol@gmail.com");
		PhoneContact contact4 = new PhoneContact("Mayur","Aurangabad", "813465646", "amol@gmail.com");
		
		
		LinkedList<PhoneContact> phoneContactList = new LinkedList<PhoneContact>();
		
		phoneContactList.add(contact1);
		Iterator<PhoneContact> it = phoneContactList.iterator();
		//for-each loop
		for(PhoneContact p: phoneContactList) {
			System.out.println(p);
		}
		
		//iterator based loop
		while(it.hasNext()) {
			PhoneContact p = it.next();
			System.out.println(p);
		}
		
	}
}

class Contact
{
	String contactName;
	String contactAddress;
	public Contact(String contactName, String contactAddress) {
		super();
		this.contactName = contactName;
		this.contactAddress = contactAddress;
	}
	
	@Override
	public String toString() {
		return "Contact [contactName=" + contactName + ", contactAddress=" + contactAddress + "]";
	}
}
	

class PhoneContact extends Contact{
	String contactNumber;
	String emailAddress;
	
	public PhoneContact(String contactName, String contactAddress, String contactNumber, String emailAddress) {
		super(contactName, contactAddress);
		this.contactNumber = contactNumber;
		this.emailAddress = emailAddress;
	}

	@Override
	public String toString() {
		return "PhoneContact [contactName=" + contactName + ", contactAddress=" + contactAddress + ", contactNumber="
				+ contactNumber + ", emailAddress=" + emailAddress + "]";
	}
}