package yutnori;

public class Hunt {
		public int kill(int i) { // i는 이동한 말의 번호

			if (Player.currentTurn == 'A') {
				int k = 0;
				for (int j = 0; j < Player.horseB.length; j++) {
					if (Player.horseB[j] == Player.currentHorse[i] && Player.horseB[j] != 0 && Player.horseB[j] != 32) {
						Player.horseB[j] = 0; // 이동한 위치에 상대 말이 있을 경우 제거
						Player.angle[0][j] = 0; 
						Player.angle[1][j] = 0; // 꼭지점 지나친 기록 초기화
						k += 1;
					}
				}
				if (k > 0) return 1;
			}
			
			if (Player.currentTurn == 'B') {
				int k = 0;
				for (int j = 0; j < Player.horseA.length; j++) { 
					if (Player.horseA[j] == Player.currentHorse[i] && Player.horseA[j] != 0 && Player.horseA[j] != 32) {
						Player.horseA[j] = 0; // 이동한 위치에 상대 말이 있을 경우 제거
						Player.angle[0][j] = 0; //
						Player.angle[1][j] = 0; // 꼭지점 지나친 기록 초기화
						k += 1;
					}
				}
				if (k > 0) return 1;
			}
			return 0;
		}
	}