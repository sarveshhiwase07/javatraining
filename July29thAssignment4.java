import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;

public class July29thAssignment4 {
	public static void main(String[] args) {
		Book b1 = new Book("Java", "1234", "James Gosling", "First", 457, 700);
		Book b2 = new Book("C++", "5678", "Djourne Bstaruap", "Fifteen", 668, 650);
		Book b3 = new Book("Python", "9101", "Snake Lover", "Eighteen", 789, 900);
		
		HashSet<Book> hs = new HashSet<Book>();
		hs.add(b1);
		hs.add(b2);
		hs.add(b3);
		
		MySerializerAndDeserializer ms = new MySerializerAndDeserializer("example1.txt");
		ms.serialize(hs);
		HashSet<Book> newHS = (HashSet<Book>) ms.deserialize(hs);
		for(Book b: newHS) {
			System.out.println(b);
		}
	}
}

/*
 * Custom class based serialiser and deserialiser which can take any objects
 */
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

class Book implements Serializable{
	String title;
	String ISBN;
	String author;
	String edition;
	int pagesCount;
	float price;
	
	public Book(String title, String iSBN, String author, String edition, int pagesCount, float price) {
		super();
		this.title = title;
		ISBN = iSBN;
		this.author = author;
		this.edition = edition;
		this.pagesCount = pagesCount;
		this.price = price;
	}
	
	//Overrided Hashcode method based on all the fields on book
	@Override
	public int hashCode() {
		return Objects.hash(ISBN, author, edition, pagesCount, price, title);
	}
	
	//Overrided equals method based on all the fields on book
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(ISBN, other.ISBN) && Objects.equals(author, other.author)
				&& Objects.equals(edition, other.edition) && pagesCount == other.pagesCount
				&& Float.floatToIntBits(price) == Float.floatToIntBits(other.price)
				&& Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", ISBN=" + ISBN + ", author=" + author + ", edition=" + edition
				+ ", pagesCount=" + pagesCount + ", price=" + price + "]";
	}
}