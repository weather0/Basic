package co.yedam.prg;

public class Card {
	String cardNo;
	String validDate;
	String cvc;

	public Card(String cardNo, String validDate, String cvc) {
		super();
		this.cardNo = cardNo;
		this.validDate = validDate;
		this.cvc = cvc;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getValidDate() {
		return validDate;
	}

	public void setValidDate(String validDate) {
		this.validDate = validDate;
	}

	public String getCvc() {
		return cvc;
	}

	public void setCvc(String cvc) {
		this.cvc = cvc;
	}

	public void showCardInfo() {
		System.out.println("카드정보 ( Card NO : " + cardNo + ", 유효기간 : " + validDate + ", CVC: " + cvc + ")");
	}

}
