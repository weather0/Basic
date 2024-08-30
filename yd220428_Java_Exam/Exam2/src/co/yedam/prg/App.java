package co.yedam.prg;

public class App {
	public static void main(String[] args) {
		TossCard toss = new TossCard("5432-4567-9534-3657", "20251203", "253", "신빛용");
		toss.showCardInfo();

		DGBCard dgb = new DGBCard("5432-4567-9534-3657", "20251203", "253", "신빛용");
		dgb.showCardInfo();

	}

}
