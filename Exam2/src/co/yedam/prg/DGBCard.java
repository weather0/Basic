package co.yedam.prg;

public class DGBCard extends Card {
	static final String COMPANY = "대구은행";
	String cardStaff;

	public DGBCard(String cardNo, String validDate, String cvc, String cardStaff) {
		super(cardNo, validDate, cvc);
		this.cardStaff = cardStaff;
	}

	public void showCardInfo() {
		System.out.println("카드정보 ( Card NO : " + cardNo + ", 유효기간 : " + validDate + ", CVC: " + cvc + " )" + "\n담당직원 - "
				+ cardStaff + ", " + COMPANY);
	}

}
