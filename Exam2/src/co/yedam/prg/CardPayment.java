package co.yedam.prg;

public class CardPayment implements Payment {
	double cardRatio;

	public CardPayment(Double cardRatio) {
		super();
		this.cardRatio = cardRatio;
	}

	@Override
	public int online(int price) {
		return (int) (price - price * (cardRatio + ONLINE_PAYMENT_RATIO));
	}

	@Override
	public int offline(int price) {
		return (int) (price - price * (cardRatio + OFFLINE_PAYMENT_RATIO));
	}

	@Override
	public void showInfo() {
		double cardOn = cardRatio + ONLINE_PAYMENT_RATIO;
		double cardOff = cardRatio + OFFLINE_PAYMENT_RATIO;
		System.out.println("*** 카드로 결제 시 할인정보" + "\n온라인 결제 시 총 할인율 :" + cardOn + "\n오프라인 결제 시 총 할인율 :" + cardOff);

	}

}
