package yutnori;

public class MapDisplay extends Player {
	String[] mapPlayer;
	String[][] horse;

	public void disOut() {
		mapPlayer = new String[33]; // 해당 맵에 있는 플레이어
		horse = new String[33][4]; // 말 넘버

		for (int i = 0; i < horseA.length; i++) {
			if (horseA[i] != 0 || horseA[i] != 32) { // 대기상태나, 골인 상태가 아니면
				mapPlayer[horseA[i]] = "A";
				horse[horseA[i]][i] = String.valueOf(i);// 정수를 문자열로 변환
			}
		}
		for (int i = 0; i < horseB.length; i++) {
			if (horseB[i] != 0 || horseB[i] != 32) {
				mapPlayer[horseB[i]] = "B";
				horse[horseB[i]][i] = String.valueOf(i);
			}
		}
		for (int i = 0; i < mapPlayer.length; i++) { // null 공백처리
			if (mapPlayer[i] == null) {
				mapPlayer[i] = "";
			}
		}
		for (int i = 0; i < horse.length; i++) {
			for (int j = 0; j < horse[i].length; j++) {
				if (horse[i][j] == null) {
					horse[i][j] = "";
				}
			}
		}
		/*--------------------------------------------------------------------------*/
		// 윷판 출력
		System.out.println("===============★★모두의 윷놀이★★==============");

		// 맨윗줄
		System.out.println();
		System.out.print("◎" + mapPlayer[11] + horse[11][0] + horse[11][1] + horse[11][2] + horse[11][3] + "\t");
		System.out.print("o" + mapPlayer[10] + horse[10][0] + horse[10][1] + horse[10][2] + horse[10][3] + "\t");
		System.out.print("o" + mapPlayer[9] + horse[9][0] + horse[9][1] + horse[9][2] + horse[9][3] + "\t");
		System.out.print("o" + mapPlayer[8] + horse[8][0] + horse[8][1] + horse[8][2] + horse[8][3] + "\t");
		System.out.print("o" + mapPlayer[7] + horse[7][0] + horse[7][1] + horse[7][2] + horse[7][3] + "\t");
		System.out.println("◎" + mapPlayer[6] + horse[6][0] + horse[6][1] + horse[6][2] + horse[6][3]); // 맨윗줄

		// 2줄
		System.out.print("    " + "o" + mapPlayer[26] + horse[26][0] + horse[26][1] + horse[26][2] + horse[26][3]);
		System.out.println(
				"\t\t\t\t" + "    " + "o" + mapPlayer[21] + horse[21][0] + horse[21][1] + horse[21][2] + horse[21][3]); // 2줄

		// 3줄
		System.out
				.print("o" + mapPlayer[12] + horse[12][0] + horse[12][1] + horse[12][2] + horse[12][3] + "\t\t\t\t\t");
		System.out.println("o" + mapPlayer[5] + horse[5][0] + horse[5][1] + horse[5][2] + horse[5][3]); // 3줄

		// 4줄
		System.out
				.print("\t" + "    " + "o" + mapPlayer[27] + horse[27][0] + horse[27][1] + horse[27][2] + horse[27][3]);
		System.out.println(
				"\t\t" + "    " + "o" + mapPlayer[22] + horse[22][0] + horse[22][1] + horse[22][2] + horse[22][3]); // 4줄

		// 5줄
		System.out
				.print("o" + mapPlayer[13] + horse[13][0] + horse[13][1] + horse[13][2] + horse[13][3] + "\t\t\t\t\t");
		System.out.println("o" + mapPlayer[4] + horse[4][0] + horse[4][1] + horse[4][2] + horse[4][3]); // 5줄

		// 6줄(중앙)
		System.out.println("\t\t" + "             " + "◎" + mapPlayer[28] + horse[28][0] + horse[28][1] + horse[28][2]
				+ horse[28][3]); // 6줄(중앙)

		// 7줄
		System.out
				.print("o" + mapPlayer[14] + horse[14][0] + horse[14][1] + horse[14][2] + horse[14][3] + "\t\t\t\t\t");
		System.out.println("o" + mapPlayer[3] + horse[3][0] + horse[3][1] + horse[3][2] + horse[3][3]); // 7줄

		// 8줄
		System.out
				.print("\t" + "    " + "o" + mapPlayer[24] + horse[24][0] + horse[24][1] + horse[24][2] + horse[24][3]);
		System.out.println(
				"\t\t" + "    " + "o" + mapPlayer[29] + horse[29][0] + horse[29][1] + horse[29][2] + horse[29][3]); // 8줄

		// 9줄
		System.out
				.print("●" + mapPlayer[15] + horse[15][0] + horse[15][1] + horse[15][2] + horse[15][3] + "\t\t\t\t\t");
		System.out.println("o" + mapPlayer[2] + horse[2][0] + horse[2][1] + horse[2][2] + horse[2][3]); // 9줄

		// 10줄
		System.out.print("    " + "●" + mapPlayer[25] + horse[25][0] + horse[25][1] + horse[25][2] + horse[25][3]);
		System.out.println(
				"\t\t\t\t" + "    " + "o" + mapPlayer[30] + horse[30][0] + horse[30][1] + horse[30][2] + horse[30][3]); // 10줄

		// 11줄
		System.out.print("◎" + mapPlayer[16] + horse[16][0] + horse[16][1] + horse[16][2] + horse[16][3] + "\t");
		System.out.print("o" + mapPlayer[17] + horse[17][0] + horse[17][1] + horse[17][2] + horse[17][3] + "\t");
		System.out.print("o" + mapPlayer[18] + horse[18][0] + horse[18][1] + horse[18][2] + horse[18][3] + "\t");
		System.out.print("o" + mapPlayer[19] + horse[19][0] + horse[19][1] + horse[19][2] + horse[19][3] + "\t");
		System.out.print("o" + mapPlayer[20] + horse[20][0] + horse[20][1] + horse[20][2] + horse[20][3] + "\t");
		System.out.println("◎" + mapPlayer[1] + horse[1][0] + horse[1][1] + horse[1][2] + horse[1][3] + mapPlayer[31]
				+ horse[31][0] + horse[31][1] + horse[31][2] + horse[31][3]); // 11줄
		System.out.println();
		System.out.println("=========================================");
		System.out.println();

		// 플레이어 상태 출력
		System.out.print("[A] " + nameA + " : ");
		for (int i = 0; i < horseA.length; i++) {
			System.out.print(i + ". ");
			if (horseA[i] == 0) {
				System.out.print("대기중    | ");
			} else if (horseA[i] >= 32) {
				System.out.print("☆골인☆   | ");
			} else {
				System.out.print("이동중    | ");
			}
		}
		System.out.println();

		System.out.print("[B] " + nameB + " : "); // 플레이어 상태 출력
		for (int i = 0; i < horseB.length; i++) {
			System.out.print(i + ". ");
			if (horseB[i] == 0) {
				System.out.print("대기중    | ");
			} else if (horseB[i] >= 32) {
				System.out.print("☆골인☆   | ");
			} else {
				System.out.print("이동중    | ");
			}
		}
		System.out.println();
		System.out.println();
	}
}