
public class MyAssociationAssignmentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GithubAccount ga = new GithubAccount("Sarvesh Hiwase", "tp@gmail.com", "12454@#54", "sha256", "https://github.com/sha256");
	
		InternetConnection internet = new InternetConnection(500, "Airtel XStream", "192.168.224.72");
		
		File f = new File("associationAssignment.java", 500, "java");
		
		Repository repo = ga.createRepoAndAddFiles(f, internet, "DS-Training");
		
		if(repo.repoLink != null)
			System.out.println(repo.repoLink);
		else
			System.out.println("Check your internet connection...");
	}
}

class Account{
	String username;
	String email;
	String password;
	public Account(String username, String email, String password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
	}
	
	
}

class GithubAccount extends Account{
	String githubUsername;
	String githubUrl;
	Repository repo;
	
	
	public GithubAccount(String username, String email, String password, String githubUsername, String githubUrl) {
		super(username, email, password);
		this.githubUsername = githubUsername;
		this.githubUrl = githubUrl;
	}

	//returns a github url for the repository
	Repository createRepoAndAddFiles(File fileToAdd,InternetConnection internet,String name) {
		Repository repo = new Repository("public","DS-Training",1,fileToAdd);
		repo.generateLink(githubUrl,internet);
		return repo;
	}
}

class Repository{
	String type;
	String repoName;
	int filesCount;
	String repoLink;
	File file;
	
	public Repository(String type, String repoName, int filesCount, File files) {
		super();
		this.type = type;
		this.repoName = repoName;
		this.filesCount = filesCount;
		this.file = files;
	}
	
	void generateLink(String profileLink,InternetConnection i) {
		if(i.speed >= 1000) {
			this.repoLink =  profileLink + "/" + repoName;
		} 
	}
}

class File{
	String fileName;
	double fileSize;
	String extension;
	
	public File(String fileName, double fileSize, String extension) {
		super();
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.extension = extension;
	}
}

class InternetConnection{
	double speed;
	String serviceProvider;
	String ipAddress;
	
	public InternetConnection(double speed, String serviceProvider, String ipAddress) {
		super();
		this.speed = speed;
		this.serviceProvider = serviceProvider;
		this.ipAddress = ipAddress;
	}
}