package yutnori;

import java.util.Random;
import java.util.Scanner;

public class Player extends Thread {
	// 플레이어 이름
	static String nameA; 
	static String nameB;
	
	// 말 배열
	static int horseA[]; 
	static int horseB[];
	
	//현재 플레이어 이름과 말
	static String currentName;
	static int[] currentHorse; 
	
	//플레이어 턴
	static char currentTurn; 
	
	static Scanner scanner = new Scanner(System.in);
	static int[][] angle;

	//초기값 설정
	Player() {
		nameA = null;
		nameB = null;
		horseA = new int[4];
		horseB = new int[4];
		currentTurn = ' ';
		horseA[0] = 0;
		horseA[1] = 0;
		horseA[2] = 0;
		horseA[3] = 0;
		horseB[0] = 0;
		horseB[1] = 0;
		horseB[2] = 0;
		horseB[3] = 0;
		angle = new int[2][4];
	}
	//Scanner 활용 → 플레이어 이름 입력
	public void inputName() {
		System.out.println("**플레이어명은 영문자로 작성해주세요.**\n");
		System.out.println("플레이어 A의 이름을 입력하세요. ");
		nameA = scanner.nextLine();
		System.out.println("플레이어 B의 이름을 입력하세요. ");
		nameB = scanner.nextLine();
		System.out.println("");
	}
	// 현재 순서 결정
	public void setCurrent(int i) { 
		if (i == 0) {
			currentTurn = 'A';
			currentName = nameA;
			currentHorse = horseA;
		} else {
			currentTurn = 'B';
			currentName = nameB;
			currentHorse = horseB;
		}
	}
	//Random 활용 → 플레이어 순서 결정
	public void startRandom() {
		System.out.println("게임 순서를 결정합니다.");

		Random random = new Random();
		int i = random.nextInt(2); // 0은 A, 1은 B 랜덤 숫자 받음
		setCurrent(i); // 순서 결정 메소드
		try {
			sleep(2000);  //2초 일시정지
		} catch (InterruptedException e) { 
			e.printStackTrace();
		}
		System.out.println("[" + currentTurn + "] " + currentName + "님이 먼저 시작합니다.");
		System.out.println("Game Start!!");
		System.out.println("");
		
		try {
			sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public int move() {
		System.out.print("[" + currentTurn + "] " + currentName + "님, ");
		System.out.print("몇번 말을 이동하시겠습니까? (0~3 입력)");

		int i = -1;
		while (i < 0 || i > 3) {
			i = scanner.nextInt();
			scanner.nextLine();
			if (i < 0 || i > 3) {
				System.out.println("잘못 입력하셨습니다.");
				System.out.println("다른 말을 골라주세요.");
				i = -1;
				continue;
			}
			if (Player.currentHorse[i] == 32) {
				System.out.println("이미 골인한 말입니다.");
				System.out.println("다른 말을 골라주세요.");
				i = -1;
				continue;
			}
			if (ThrowYut.numberYut == -1 && Player.currentHorse[i] == 0 || Player.currentHorse[i] == 32) {
				System.out.println("대기중이거나 골인한 말은 빽도로 이동시킬 수 없습니다.");
				System.out.println("다른 말을 골라주세요.");
				i = -1;
				continue;
			}
		}
		System.out.println("*** " + i +  "번 말을 " + ThrowYut.numberYut + "칸 이동합니다. ***" );
		int before = currentHorse[i]; // 이동 전 위치
		currentHorse[i] += ThrowYut.numberYut;
		int after = currentHorse[i]; // 이동 후 위치
		SpecialMove specialMove = new SpecialMove();
		specialMove.route(i, before, after);

		return i;

	}
}