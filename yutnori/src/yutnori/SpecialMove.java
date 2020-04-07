package yutnori;

public class SpecialMove {
	public void route(int i, int before, int after) { 
		// 이동하려는 말의 출발전 현재 위치를 받음
		if (before == 0) {
			Player.currentHorse[i] += 1;	
		} 

		//6번에서 빽도시 선택지 출력 안하고 바로 5번으로 이동, 그 외 나머지는 대각선 이동
		else if (before == 6) {
			Player.angle[0][i] = 1;
			if(ThrowYut.numberYut == -1) Player.currentHorse[i] = 5;
			else if(ThrowYut.numberYut == 3) {
				Player.currentHorse[i] = 28;
				after = 28; //?
			}
			else Player.currentHorse[i] += 14;
		}
		
		//11번에서 빽도시 선택지 출력 안하고 바로 10번으로 이동, 그 외 나머지는 대각선 이동
		if (before == 11) {
			if(ThrowYut.numberYut == -1) Player.currentHorse[i] = 10;
			else Player.currentHorse[i] += 14;
		}
		
		if (before == 16) {
			Player.angle[1][i] = 1;
			if(ThrowYut.numberYut == -1 && Player.angle[0][i] == 1) Player.currentHorse[i] +=10;
		}
		
		if (before == 28) { 
			if(ThrowYut.numberYut == -1 && Player.angle[0][i] == 1) Player.currentHorse[i] -=5; 
		
		}   
		
		if (before == 31) {
			if(ThrowYut.numberYut == -1 && Player.angle[1][i] == 1 ||
					(Player.angle[0][i]==0 && Player.angle[1][i] == 0)) 
				Player.currentHorse[i] -=10;
		}
		
		//21, 22, 24, 25번에 위치했을때 나오는 윷패에 따라 16번이 있는 라인에 가게됐을때 지정값 -10 처리
		if (before == 21 && ThrowYut.numberYut == 5) {
			Player.currentHorse[i] -= 10;
		}
		if (before == 22 && ThrowYut.numberYut >= 4) {
			Player.currentHorse[i] -= 10;
		}
		if (before == 24 && ThrowYut.numberYut >= 2) {
			Player.currentHorse[i] -= 10;
		}
		if (before == 25) {
			Player.currentHorse[i] -= 10;
		}
		
		//빽도오류
		if (before == 26 && ThrowYut.numberYut == -1) { 
			Player.currentHorse[i] -= 14;
		}
		if (before == 21 && ThrowYut.numberYut == -1) { 
			Player.currentHorse[i] -= 14;
		}
		
		//이벤트발생
		if (before == 25 && ThrowYut.numberYut == -1) {
				Player.currentHorse[i] -= 7;  
				System.out.println();
				System.out.println("!!!이벤트발생!!!"); }
		
	    if (Player.currentHorse[i] == 15) {
	          Player.currentHorse[i] = 20;
	          System.out.println();
	          System.out.println("!!!이벤트발생!!!");   }
		
		//
		if (before == 16 && ThrowYut.numberYut == 5) {
			Player.currentHorse[i] = 31;
		}
		if (before == 17 && ThrowYut.numberYut >= 4) {
			Player.currentHorse[i] = 31;
		}
		if (before == 18 && ThrowYut.numberYut >= 3) {
			Player.currentHorse[i] = 31;
		}
		if (before == 19 && ThrowYut.numberYut >= 2) {
			Player.currentHorse[i] = 31;
		}
		if (before == 20 && ThrowYut.numberYut >= 1) {
			Player.currentHorse[i] = 31;
		}

		/////////////////////////////////////
		/*if (before == 26 && ThrowYut.numberYut == 5) {
			Player.currentHorse[i] = 31;
		}*/
		if (before == 27 && ThrowYut.numberYut >= 4) {
			Player.currentHorse[i] = 31;
		}
		/*if (before == 28 && ThrowYut.numberYut >= 3) {
			Player.currentHorse[i] = 31;
		}*/
		if (before == 29 && ThrowYut.numberYut >= 2) {
			Player.currentHorse[i] = 31;
		}
		if (before == 30 && ThrowYut.numberYut >= 1) {
			Player.currentHorse[i] = 31;
		}
		if (before == 2 && ThrowYut.numberYut == -1) {
			Player.currentHorse[i] = 31;
		}
		//////////////////////////////////////
	
		
		// 종료지점 오류
		if (before !=20 && before != 19 && before != 18 && after == 23) { 
			Player.currentHorse[i] = 28;
		}
		
		
		if (before == 17 && ThrowYut.numberYut == 5) {
			Player.currentHorse[i] = 32;
			}
			if (before == 18 && ThrowYut.numberYut >= 4) {
			Player.currentHorse[i] = 32;
			}
			if (before == 19 && ThrowYut.numberYut >= 3) {
			Player.currentHorse[i] = 32;
			}
			if (before == 20 && ThrowYut.numberYut >= 2) {
			Player.currentHorse[i] = 32;
			}
			if (before == 27 && ThrowYut.numberYut == 5) {
				Player.currentHorse[i] = 32;
			}
			if (before == 28 && ThrowYut.numberYut >= 4) {
				Player.currentHorse[i] = 32;
			}
			if (before == 29 && ThrowYut.numberYut >= 3) {
				Player.currentHorse[i] = 32;
			}
			if (before == 30 && ThrowYut.numberYut >= 2) {
				Player.currentHorse[i] = 32;
			}
			if (before == 31 && ThrowYut.numberYut >= 1) {
				Player.currentHorse[i] = 32;
			}
			
	// 업힌 말들도 같이 이동
		for (int j = 0; j < Player.currentHorse.length; j++) { 
			if (before != 0 && before != 32 && Player.currentHorse[j] == before) {
				Player.currentHorse[j] = Player.currentHorse[i];
			}
		}
	}
}