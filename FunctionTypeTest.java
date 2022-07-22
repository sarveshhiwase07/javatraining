public class FunctionTypeTest {
	public static void main(String[] args) {
		ServerAPI apiConnection = new ServerAPI();
		
		apiConnection.setData(12345, "Sarvesh");
		System.out.println( apiConnection.getData());
		System.out.println("------------------------");
		apiConnection.updateUserName("Amol");
		System.out.println( apiConnection.getData());
		System.out.println("------------------------");
		apiConnection.deleteData();
		System.out.println( apiConnection.getData());
	}
}

class ServerAPI{
	int userID;
	String name;
	//4
	String getData() {
		System.out.println("Getting user's name from the server");
		System.out.println("------------------------");
		return name;
	}
	//3
	String updateUserName(String name) {
		this.name = name;
		System.out.println("Updated user's name on the server");
		System.out.println("------------------------");
		return this.name;
	}
	//2
	void setData(int userID, String name) {
		this.userID = userID;
		this.name = name;
		System.out.println("Successfully set data on the server");
		System.out.println("------------------------");
	}
	//1
	void deleteData() {
		this.name = "";
		this.userID = -1;
		System.out.println("Succesfully deleted data on the server");
		System.out.println("------------------------");
	}
}