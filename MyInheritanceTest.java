import java.time.LocalDate;

public class MyInheritanceTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account ac = new Account("Sarvesh","example@gmail.com","12345678");
		ac.printAccount();
		
		NetflixAccount nfac = new NetflixAccount("Sarvesh","example@gmail.com","12345678", "UPI", LocalDate.of(2022, 6,18), true);
		nfac.printNetflixAccount();
		
		NetflixProfile np = new NetflixProfile("Sarvesh","example@gmail.com","12345678", "UPI", LocalDate.of(2022, 6,18), true,"Action, comedy","Friends, Black Mirror");
		np.printNetflixProfile();
	}
}

class Account{
	private String name;
	private String email;
	private String password;
	
	public Account(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	void printAccount() {
		System.out.println("Username: " + name);
		System.out.println("Email: " + email);
		System.out.println("Password: " + password);
		System.out.println("--------------------------");
	}
}

class NetflixAccount extends Account{
	private String paymentInfo;
	private LocalDate joinedDate;
	private boolean membershipStatus;

	public NetflixAccount(String name, String email, String password, String paymentInfo, LocalDate joinedDate,
			boolean membershipStatus) {
		super(name, email, password);
		this.paymentInfo = paymentInfo;
		this.joinedDate = joinedDate;
		this.membershipStatus = membershipStatus;
	}
	
	void printNetflixAccount() {
		super.printAccount();
		System.out.println("payment Information : " + paymentInfo);
		System.out.println("Joined Date: " + joinedDate);
		System.out.println("MemberShip Status: " + membershipStatus);
		System.out.println("--------------------------");
	}
}

class NetflixProfile extends NetflixAccount{
	private String preferences;
	private String recentlyWatched;
	
	public NetflixProfile(String name, String email, String password, String paymentInfo, LocalDate joinedDate,
			boolean membershipStatus, String preferences, String recentlyWatched) {
		super(name, email, password, paymentInfo, joinedDate, membershipStatus);
		this.preferences = preferences;
		this.recentlyWatched = recentlyWatched;
	}
	
	void printNetflixProfile() {
		super.printNetflixAccount();
		System.out.println("Preferences : " + preferences);
		System.out.println("Recently watched shows: " + recentlyWatched);
		System.out.println("--------------------------");
	}
}

