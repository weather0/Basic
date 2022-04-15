package Pac0415;

public class Account {
	// 계좌번호, 예금주, 잔액
	
	String accNum;
	String accName;
	int balance = 0;
	
	
	
	public Account(String accNum, String accName, int balance) {
		super();
		this.accNum = accNum;
		this.accName = accName;
		this.balance = balance;
		
		
	}



	public String getAccNum() {
		return accNum;
	}



	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}



	public String getAccName() {
		return accName;
	}



	public void setAccName(String accName) {
		this.accName = accName;
	}



	public int getBalance() {
		return balance;
	}



	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
	

	

}
