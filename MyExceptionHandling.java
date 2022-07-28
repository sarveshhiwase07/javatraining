import eh.exceptions.IsInternetConnectedException;

public class MyExceptionHandling {
	public static void main(String[] args) {
		Repo mr = new Repo();
		try {
			mr.turnOnInternet();
			mr.makeRepo();
//			int min = 10;
//			int max = 15;
//			for(int i = 1; i <= 100; i++) {
//				//Math.round(Math.random() * min)  // this always lies in 0 to min
//				System.out.println(Math.round(Math.random() * (max - min)) + min);
//			}
			
		} catch(IsInternetConnectedException ex) {
			System.out.println(ex.getMessage());
		}	
	}
}


class Repo{
	boolean internet;
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
		System.out.println("Repository succesfully created...");
	}
}