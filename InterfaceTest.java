public class InterfaceTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student1 s = new Student1();
		
		Developer d = new Developer();
		
		int time = 100;
		if(time > 100)
			LifeBalanceService.maintainBalance(s, d);
		else
			LifeBalanceService.maintainBalance(d, s);
	}
}

class LifeBalanceService{
	public static void maintainBalance(Studying s,Playing p) {
		s.study();
		p.playGame();
	}
}

interface Playing{
	void playGame();
}

interface Studying{
	void study();
}

class Student1 implements Studying,Playing{
	@Override
	public void study() {
		// TODO Auto-generated method stub
		System.out.println("Student: studying");
	}

	@Override
	public void playGame() {
		// TODO Auto-generated method stub
		System.out.println("Student: playing games");
	}
}

class Developer implements Studying,Playing {

	@Override
	public void study() {
		// TODO Auto-generated method stub
		System.out.println("Developer: studying");
	}

	@Override
	public void playGame() {
		// TODO Auto-generated method stub
		System.out.println("Developer: playing games");
	}
}