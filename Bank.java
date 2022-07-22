//import java.util.*;
//import java.io.*;

public class Bank {
	public static void main(String[] args) {
		System.out.println("Banking started");
		BankAccount baObj1 = new BankAccount();
		BankAccount baObj2 = new BankAccount();
		
		baObj1.setBankAccount(101,"sarvesh",0);
		baObj2.setBankAccount(102,"amol",0);
		baObj1.printBankAccount();
		baObj2.printBankAccount();
	}
}

class BankAccount{
	int accountNumber;
	String accountHolderName;
	double balance;
	
	void setBankAccount(int accNumber,String acName,double currBalance) {
		accountNumber = accNumber;
		accountHolderName = acName;
		balance = currBalance;
	}
	
	double calculateSimpleInterest(float rateOfInterest,int period) {
		double simpleInterest = (balance * rateOfInterest * period) / 100;
		return simpleInterest;
	}
	
	void deposit(float amtToDeposit) {
		balance += amtToDeposit;
	} 
	void withdraw(float amtToWithdraw) {
		balance  -= amtToWithdraw;
	}
	
	void printBankAccount() {
		System.out.println("Bank Account: ");
		System.out.println("Acc number: " + accountNumber);
		System.out.println("Acc name: " + accountHolderName);
		System.out.println("Acc balance: " + balance);
		System.out.println("---------------------");
	}
}
