import java.util.HashSet;
import java.util.Objects;

public class July29thAssignment1 {
	public static void main(String[] args) {
		Book b1 = new Book("Java", "1234", "James Gosling", "First", 457, 700);
		Book b2 = new Book("C++", "5678", "Djourne Bstaruap", "Fifteen", 668, 650);
		Book b3 = new Book("Python", "9101", "Snake Lover", "Eighteen", 789, 900);
//		Book b4 = new Book("Python", "9101", "Snake Lover", "Eighteen", 789, 900);
		
		HashSet<Book> hs = new HashSet<Book>();
		hs.add(b1);
		hs.add(b2);
		hs.add(b3);
		
		for(Book b: hs) {
			System.out.println(b);
		}
	}
}

class Book{
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