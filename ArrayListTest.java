import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PhoneLog log1 = new PhoneLog("You missed a call",LocalDate.now(),"Missed Call","Amol");
		PhoneLog log2 = new PhoneLog("You dialed a call",LocalDate.now(),"Missed Call","Sai");
		PhoneLog log3 = new PhoneLog("You recieved a call",LocalDate.now(),"Missed Call","Guru");
		PhoneLog log4 = new PhoneLog("You got a call",LocalDate.now(),"Missed Call","Master");
		PhoneLog log5 = new PhoneLog("You missed a call",LocalDate.now(),"Missed Call","Hanuman");
		
		
		ArrayList<PhoneLog> phoneLogList = new ArrayList<PhoneLog>();
		
		phoneLogList.add(log1);
		phoneLogList.add(log2);
		phoneLogList.add(log3);
		phoneLogList.add(log4);
		phoneLogList.add(log5);
		
		Iterator<PhoneLog> it = phoneLogList.iterator();
		
//		for(PhoneLog p: phoneLogList) {
//			System.out.println(p);
//		}
		while(it.hasNext()) {
			PhoneLog p = it.next();
			System.out.println(p);
		}
		
	}
}

class Log
{
	String logMessage;
	LocalDate logTime;
	
	public Log(String logMessage, LocalDate logTime) {
		super();
		this.logMessage = logMessage;
		this.logTime = logTime;
	}

	@Override
	public String toString() {
		return "Log [logMessage=" + logMessage + ", logTime=" + logTime + "]";
	}
}

class PhoneLog extends Log{
	String logType;
	String logBy;
	
	public PhoneLog(String logMessage, LocalDate logTime, String logType, String logBy) {
		super(logMessage, logTime);
		this.logType = logType;
		this.logBy = logBy;
	}

	@Override
	public String toString() {
		return "PhoneLog [logMessage=" + logMessage + ", logTime=" + logTime + ", logType=" + logType + ", logBy="
				+ logBy + "]";
	}
}