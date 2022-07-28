import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializerAndDeserializerTest {
	public static void main(String[] args) {
		MySerializerAndDeserializer sd = new MySerializerAndDeserializer("example1.txt");
		NetflixAccount nf = new NetflixAccount("example@gmail.com", "Sarvesh","123@2123sar" );
		sd.serialize(nf);
		Object obj = sd.deserialize(nf);
		System.out.println(obj);
	}
}

class MySerializerAndDeserializer{
	private ObjectOutputStream oos;
	private FileOutputStream fos;
	private ObjectInputStream ois;
	private FileInputStream fis;
	public MySerializerAndDeserializer(String fileName) {
		try {
			fos = new FileOutputStream("C:/Users/SHE19/Downloads/" + fileName);
			fis = new FileInputStream("C:/Users/SHE19/Downloads/" + fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
			
	}
	void serialize(Object obj) {
		try {
			oos = new ObjectOutputStream(fos);
			oos.writeObject(obj);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Serialization Done succesfully...");
	}
	Object  deserialize(Object toGet) {
		Object obj = null;
		try {
			ois = new ObjectInputStream(fis);
			obj = ois.readObject();
			if(obj.getClass() != toGet.getClass()) throw new ClassNotFoundException();
			System.out.println("Deserialization Done succesfully...");
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		return obj;
	}
}