import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

class AccordingPrice implements Comparator<Book> {
    public int compare(Book b1, Book b2)
    {
        return b1.price - b2.price;
    }
}

public class MapTest {
	public static void main(String[] args) {
		TreeMap<Book,Integer> tm = new TreeMap<Book,Integer>(new AccordingPrice());
		Book b1 = new Book(20,"sarvesh");
		Book b2 = new Book(30,"amol");
		tm.put(b1, 50);
		tm.put(b2, 20);
		
		HashMap<Book,Integer> hm = new HashMap<Book, Integer>();
		
		hm.put(b1, 50);
		hm.put(b2, 20);
		 for(Map.Entry<Book,Integer> m: tm.entrySet()){  
			   System.out.println(m.getKey()+" "+m.getValue());  
		 }  
		 System.out.println("------------------");
		 for(Map.Entry<Book,Integer> m: hm.entrySet()){  
			   System.out.println(m.getKey()+" "+m.getValue());  
		 }  
	}
}

class Book{
	int price;
	String bookName;
	
	
	public Book(int price, String bookName) {
		super();
		this.price = price;
		this.bookName = bookName;
	}

	@Override
	public String toString() {
		return "Book [price=" + price + ", bookName=" + bookName + "]";
	}

	
}