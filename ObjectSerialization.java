import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectSerialization {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NetflixAccount nf;
		ObjectOutputStream oos;
		try {
			nf = new NetflixAccount("example@gmail.com", "Sarvesh","123@2123sar" );
			FileOutputStream fr = new FileOutputStream("C:/Users/SHE19/Downloads/example1.txt");
			oos = new ObjectOutputStream(fr);
			oos.writeObject(nf);
			System.out.println("Done succesfully...");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class NetflixAccount implements Serializable{
	private String email;
	private String accountHolderName;
	private transient String password;
	public NetflixAccount(String email, String accountHolderName, String password) {
		super();
		this.email = email;
		this.accountHolderName = accountHolderName;
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "NetflixAccount [email=" + email + ", accountHolderName=" + accountHolderName + ", password=" + password
				+ "]";
	}
}