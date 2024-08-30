package PacJY1;

public class Change1 {
	public static void main(String[] args) {
		int price = 7500;
		int vat = (int)(price/10);
		int money = 10000;
		int change = money - price;
		System.out.println("물건가격 " + price
				+ " 현금 " + money
				+ " 부가세 " + vat
				+ " 잔돈 " + change);
		
	}

}
