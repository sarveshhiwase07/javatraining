import eh.exceptions.FileSizeException;
import eh.exceptions.IsInternetConnectedException;

public class MyExceptionHandling {
	public static void main(String[] args) {
		Repo mr = new Repo();
		try {
			mr.turnOnInternet();
			mr.makeRepo();		
		} catch(IsInternetConnectedException ex) {
			System.out.println(ex.getMessage());
		}	
	}
}


class Repo{
	boolean internet;
	int fileSize;
	void turnOnInternet() {
		if(internet != true) {
			internet = true;
		}
		System.out.println("Internet succesfully turned on...");
	}
	void makeRepo() throws IsInternetConnectedException {
		if(internet != true) {
			IsInternetConnectedException net = new IsInternetConnectedException("Error: Internet not found");
			throw net;
		}
		try {
			checkFileSize();
		} catch (FileSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Repository succesfully created...");
	}
	
	void checkFileSize() throws FileSizeException{
		fileSize = (int)Math.round(Math.random() * (5000));
		if(fileSize > 2000) {
			FileSizeException fs = new FileSizeException("Error: File Size too large to upload");
			throw  fs;
		}
		System.out.println("File Uploaded Succesfully");
	}
}