import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class ObjectDeSerialization {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NetflixAccount nf = null;
		ObjectInputStream ois;
		try {
			FileInputStream fis = new FileInputStream("C:/Users/SHE19/Downloads/example1.txt");
			ois = new ObjectInputStream(fis);
			nf = (NetflixAccount) ois.readObject();
			
			System.out.println("Done succesfully..." + nf);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


