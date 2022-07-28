import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class MyFileWriter2{
	FileWriter fo;
	public MyFileWriter2(String fileName) {
		System.out.println("Trying to create a file...");
			try {
				fo = new FileWriter("C:/Users/SHE19/Downloads/" + fileName);
				System.out.println("File is created...");
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	void addDataToFile(String data) {
		try {
			fo.write(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	void closeFile(){
		try {
			fo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class MyFileReader2{
	FileReader fin;
	MyFileReader2(String fileName){
		System.out.println("Trying to open the file...");
		try {
			fin = new FileReader("C:/Users/SHE19/Downloads/" + fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("File is open...");
	}
	
	void readFileData() {
		try {
			int b = fin.read();
			while(b != -1) {
				System.out.print((char)b);
				b = fin.read();
			}
			System.out.println();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	void closeFile() {
		try {
			fin.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
//this example uses FileReader and FileWriter objects for file handling
public class FileHandlingTest {

	public static void main(String[] args) {
		String fileNames[] = {"example1.txt","example2.txt","example3.txt"};
		Scanner sc = new Scanner(System.in);
		
		//file writing
		for(String fileName: fileNames) {
			MyFileWriter fr = new MyFileWriter(fileName);
			String userInput = sc.nextLine();
			userInput += " ";
			fr.addDataToFile(userInput);
			System.out.println("+----------------- Line Break -----------------+");
			fr.closeFile();
		}
		sc.close();
		
		//file reading
		for(String fileName: fileNames) {
			MyFileReader fr = new MyFileReader(fileName);
			fr.readFileData();
			System.out.println("+----------------- Line Break -----------------+");
			fr.closeFile();
		}
	}

}

