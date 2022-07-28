import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

class MyFileWriter{
	FileOutputStream fo;
	public MyFileWriter(String fileName) {
		System.out.println("Trying to create a file...");
		try {
			fo = new FileOutputStream("C:/Users/SHE19/Downloads/" + fileName);
			System.out.println("File is created...");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	void addDataToFile(String data) {
		byte byteArray[] = data.getBytes();
		try {
			fo.write(byteArray);
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

class MyFileReader{
	FileInputStream fin;
	MyFileReader(String fileName){
		System.out.println("Trying to open the file...");
		try {
			fin = new FileInputStream("C:/Users/SHE19/Downloads/" + fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("File is open...");
	}
	
	void readFileData() {
		try {
			byte b = (byte) fin.read();
			while(b != -1) {
				System.out.print((char)b);
				b = (byte) fin.read();
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

//this example uses FileInputStream and FileOutputStream objects for file handling
public class MultipleFileHandling {

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

