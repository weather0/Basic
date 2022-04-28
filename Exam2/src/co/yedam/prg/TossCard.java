package co.yedam.prg;

public class TossCard extends Card {

	static final String COMPANY = "Toss";
	String cardStaff;

	public TossCard(String cardNo, String validDate, String cvc, String cardStaff) {
		super(cardNo, validDate, cvc);
		this.cardStaff = cardStaff;
	}

	public void showCardInfo() {
		System.out.println("카드정보 - Card NO, " + cardNo + "\n담당직원 - " + cardStaff + ", " + COMPANY);
	}

}
