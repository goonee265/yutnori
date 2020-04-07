package yutnori;


import java.util.Random;

public class ThrowYut extends Thread {
	static int numberYut;
	static String nameYut;
	MapDisplay display = new MapDisplay();	
	
	//빽도 카운트 해주기 위한 변수
	static int countBackA= 0;
	static int countBackB= 0;
	
	public void rolling(int kkk) {
		
		display.disOut();	// 
		System.out.println("[" + Player.currentTurn + "] " + Player.currentName + "님의 차례입니다.");
		System.out.println("Enter를 눌러 윷을 던집니다. (남은 횟수: " + kkk + " )");
		
		String aa = Player.scanner.nextLine(); 

		try {
			sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Random random = new Random();
		int i = random.nextInt(7);
		switch (i) {
		
		case 1:
			nameYut = "도";
			break;

		case 2:
			nameYut = "개";
			break;

		case 3:
			nameYut = "걸";
			break;

		case 4:
			nameYut = "윷";
			break;

		case 5:
			nameYut = "모";
			break;
			
		case 6:
			nameYut = "낙";
			i = 0;
			break;

		default:
			nameYut = "뺵도";
			i = -1;
			break;
		}

		////////// 테스트용 비밀코드(추후 삭제)////////////////////////////////////

		switch (aa) {
		case "11":
			nameYut = "도";
			i = 1;
			break;

		case "22":
			nameYut = "개";
			i = 2;
			break;

		case "33":
			nameYut = "걸";
			i = 3;
			break;

		case "44":
			nameYut = "윷";
			i = 4;
			break;

		case "55":
			nameYut = "모";
			i = 5;
			break;
		
		case "66":
			nameYut = "낙";
			i = 0;
			break;	

		case "00":
			nameYut = "빽도";
			i = -1;
			break;
		} 
		/////////////////////////////////////////////////////////////////
		numberYut = i;
		if(numberYut ==0 ) {
		}		
		else {
			System.out.println("<" + nameYut + "> " +  numberYut + "칸 이동합니다."); 
			System.out.println();}
		
		//// 뺵도 연속 세번 체크해주기
		if(ThrowYut.numberYut == -1 && Player.currentTurn=='A') {
			countBackA++;}
		if(ThrowYut.numberYut == -1 && Player.currentTurn=='B') {
			countBackB++;	}
	}
}