import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChemicalElement hydrogen = new ChemicalElement("Hydrogen", 1, 1.0078f, "H");
		ChemicalElement helium = new ChemicalElement("Helium", 2, 4.0026f, "He");
		ChemicalElement lithium = new ChemicalElement("Lithium", 3, 6.9410f, "Li");
		ChemicalElement beryllium = new ChemicalElement("Beryllium", 4, 9.0122f, "Be");
		
		TreeSet<ChemicalElement> ts = new TreeSet<ChemicalElement>();
		ts.add(hydrogen);
		ts.add(beryllium);
		ts.add(helium);
		ts.add(lithium);
		ts.add(lithium);
		
		Iterator<ChemicalElement> it = ts.iterator();
		
		while(it.hasNext()) {
			ChemicalElement ce = it.next();
			System.out.println(ce);
		}
	}
}
//add book no. book author book number book edition, no. of pages, bookPrice

//Innovate comparator interface with your uniquely designed object

//Innovate example treemap

class ChemicalElement implements Comparable<ChemicalElement>{
	String atomicName;
	int atomicNumber;
	float atomicWeight;
	String atomicFormula;
	
	@Override
	public String toString() {
		return "ChemicalElement [atomicName=" + atomicName + ", atomicNumber=" + atomicNumber + ", atomicWeight="
				+ atomicWeight + ", atomicFormula=" + atomicFormula + "]";
	}

	public ChemicalElement(String atomicName, int atomicNumber, float atomicWeight, String atomicFormula) {
		super();
		this.atomicName = atomicName;
		this.atomicNumber = atomicNumber;
		this.atomicWeight = atomicWeight;
		this.atomicFormula = atomicFormula;
	}

	@Override
	public int compareTo(ChemicalElement o) {
		if(atomicWeight > o.atomicWeight) return -1;
		if(atomicWeight < o.atomicWeight) return 1;
		return 0;
	}
}
