package co.yedam.prg;

public class SimplePayment implements Payment {
	double simplePaymentRatio;

	public SimplePayment(Double cardRatio) {
		super();
		this.simplePaymentRatio = cardRatio;
	}

	@Override
	public int online(int price) {
		return (int) (price - price * (simplePaymentRatio + ONLINE_PAYMENT_RATIO));
	}

	@Override
	public int offline(int price) {
		return (int) (price - price * (simplePaymentRatio + OFFLINE_PAYMENT_RATIO));
	}

	@Override
	public void showInfo() {
		double simpleOn = simplePaymentRatio + ONLINE_PAYMENT_RATIO;
		double simpleOff = simplePaymentRatio + OFFLINE_PAYMENT_RATIO;
		System.out.println("*** 간편결제 시 할인정보" + "\n온라인 결제 시 총 할인율 :" + simpleOn + "\n오프라인 결제 시 총 할인율 :" + simpleOff);

	}

}
