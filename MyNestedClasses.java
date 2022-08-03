import java.util.ArrayList;

public class MyNestedClasses {
	public static void main(String[] args) {
		Computer mypc = new Computer("Sarvesh's PC", 55375.57f);
	
		mypc.printPC();
		mypc.addSoftware("3DS SOLIDWORKS",1024 * 2048, "3D Visualisation");
		mypc.addSoftware("3DS CATIA",1024 * 968, "3D Design");
	
		mypc.printPC();
	}
}


class Computer{
	private String PCName;
	private float price;
	ArrayList<Software> softwares = new ArrayList<Software>();
	Hardware hardware;
	
	public Computer(String pCName, float price) {
		super();
		PCName = pCName;
		this.price = price;
		Software vscode = new Software("VS-Code",1024*546*1.f,"IDE");
		Software eclipse = new Software("Eclipse",1024*1245*1.f,"IDE");
		Software paint = new Software("VS-Code",1024*147*1.f,"painting");
		Software zoom = new Software("VS-Code",1024*57*1.f,"Video Chat");
		hardware = new Hardware("Intel-I9-12thGen","NVIDIA RTX 3090Ti","Asus XTE MOTHERBOARD");
		
		
		softwares.add(vscode);
		softwares.add(eclipse);
		softwares.add(paint);
		softwares.add(zoom);
	}
	
	public void addSoftware(String applicationName, float applicationSize, String applicationType) {
		if(hardware.isSupported(applicationSize)) {
			Software s = new Software(applicationName,applicationSize,applicationType);
			softwares.add(s);
		} else {
			System.out.println("Not possible to run this software so can't be added...");
		}
		
	}
	
	public void printPC() {
		System.out.println("+--------------------------------+");
		System.out.println("PC Name: " + PCName);
		System.out.println("PC Price: " + price);
		printSoftwares();
		System.out.println(hardware);
		System.out.println("+--------------------------------+");
	}

	public void printSoftwares() {
		System.out.println("+--------------------------------+");
		for(Software soft: softwares) {
			System.out.println(soft);
		}
		System.out.println("+--------------------------------+");
	}
	

	private class Software{
		private String applicationName;
		private float applicationSize;
		private String applicationType;
		
		public Software(String applicationName, float applicationSize, String applicationType) {
			super();
			this.applicationName = applicationName;
			this.applicationSize = applicationSize;
			this.applicationType = applicationType;
		}
		
		
		
		public String getApplicationName() {
			return applicationName;
		}
		public void setApplicationName(String applicationName) {
			this.applicationName = applicationName;
		}
		public float getApplicationSize() {
			return applicationSize;
		}
		public void setApplicationSize(float applicationSize) {
			this.applicationSize = applicationSize;
		}
		public String getApplicationType() {
			return applicationType;
		}
		public void setApplicationType(String applicationType) {
			this.applicationType = applicationType;
		}

		@Override
		public String toString() {
			return "Software [applicationName=" + applicationName + ", applicationSize=" + applicationSize
					+ ", applicationType=" + applicationType + "]";
		}
		
		
	}
	
	private class Hardware{
		private String CPU,GPU,motherboard;

		public Hardware(String cPU, String gPU, String motherboard) {
			super();
			CPU = cPU;
			GPU = gPU;
			this.motherboard = motherboard;
		}

		public String getCPU() {
			return CPU;
		}

		public void setCPU(String cPU) {
			CPU = cPU;
		}

		public String getGPU() {
			return GPU;
		}

		public boolean isSupported(float applicationSize) {
			if(applicationSize >= 1024 * 1024) return false;
			return true;
		}
		
		public void setGPU(String gPU) {
			GPU = gPU;
		}

		public String getMotherboard() {
			return motherboard;
		}

		public void setMotherboard(String motherboard) {
			this.motherboard = motherboard;
		}

		@Override
		public String toString() {
			return "Hardware [CPU=" + CPU + ", GPU=" + GPU + ", motherboard=" + motherboard + "]";
		}
		
		
	}
}
