package yutnori;


public class Win {
	public String check() {
		int aCount = 0;
		int bCount = 0;
		for (int i = 0; i < Player.horseA.length; i++) {
			if (Player.horseA[i] == 32) {
				aCount++;
			}
			if (aCount == 4) {
				return Player.nameA;
			}
		}
		for (int i = 0; i < Player.horseB.length; i++) {
			if (Player.horseB[i] == 32) {
				bCount++;
			}
			if (bCount == 4) {
				return Player.nameB;
			}
		}
		return null;
	}
	
}	
	

