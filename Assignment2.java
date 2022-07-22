import java.util.*;
import java.io.*;

public class Assignment2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cafeteria sky = new Cafeteria();
		Cafeteria water = new Cafeteria();
		Cafeteria agrafort = new Cafeteria();
		Cafeteria redfort = new Cafeteria();
		
		sky.setCafeteria("Sky Cafeteria", 1000, "Dum Aloo, Pulao", 100);
		water.setCafeteria("Water Cafeteria", 200, "Bread Sandwich, Paneer Tikka Masala", 50);
		agrafort.setCafeteria("Agrafort Cafeteria", 500, "Dum Aloo", 30);
		redfort.setCafeteria("Redfort Cafeteria", 300, "Dum Aloo", 18);
		
		sky.printCafe();
		water.printCafe();
		agrafort.printCafe();
		redfort.printCafe();
		
		if(sky.isCurrentlyBusy()) {
			System.out.println(sky.name + " is currently busy with " + sky.currentCrowd);
		}
	}
}

class Cafeteria{
	String menu = "";
	String name;
	int stockOfItems;
	int currentCrowd;
	
	void  buyItem() {
		if(stockOfItems > 0 ) stockOfItems--;
	}
	
	void addItemToMenu(String item) {
		menu += item;
	}
	
	void setCafeteria(String name,int stock,String todayMenu,int crowd) {
		this.name = name;
		menu = todayMenu;
		stockOfItems = stock;
		currentCrowd = crowd;
	}
	
	void printCafe() {
		System.out.println("Cafeteria Details: ");
		System.out.println("Cafe Name: " + name);
		System.out.println("Today's menu - " + menu);
		System.out.println("Cafe current stock - " + stockOfItems);
		System.out.println("----------------");
	}
	
	boolean isCurrentlyBusy() {
		if(currentCrowd > 50) return true;
		return false;
	}
	
}