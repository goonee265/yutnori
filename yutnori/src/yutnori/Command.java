package yutnori;

public class Command extends Thread {
	   public static void main(String[] args) {
	      Player player = new Player();
	      ThrowYut throwYut = new ThrowYut();
	      MapDisplay display = new MapDisplay();
	      Hunt hunt = new Hunt();
	      Win win = new Win();

	      System.out.println("--------------------------------");
	      System.out.println("　　　　　           ★★ 모두의 윷놀이 ★★　　　　　 ");
	      System.out.println("--------------------------------");
	      System.out.println("     이 게임은 2명의 플레이어가 번갈아 진행하며,");
	      System.out.println("   총 4개의 말을 먼저 골인시킨 플레이어가 승리합니다.");
	      System.out.println(" (실제 윷놀이 게임과는 룰이 다소 다를 수 있습니다.)");
	      System.out.println("--------------------------------");
	      System.out.println();
	      System.out.println();

	      player.inputName();
	      player.startRandom();

	      String winner = null; // 승리자 체크 변수
	      String winner2 = null; // 종료지점오류
	      
	      while (winner == null) {
	         for (int i = 1; i > 0; i--) { // i는 윷을 던질수 있는 횟수
	            
	            winner2 = win.check();    
	            if(winner2 != null)
	               break;//종료지점오류
	            
//	            display.disOut(); // 맵과 플레이어 상태 표시
	            throwYut.rolling(i); // 윷 던지기
	            
	            if (ThrowYut.numberYut == 4) {
	               System.out.println("윷이 나와서 한번 더 던집니다.");
	               i++;   //횟수 증가
	            } else if (ThrowYut.numberYut == 5) {
	               System.out.println("모가 나와서 한번 더 던집니다.");
	               i++;
	            }
	            
//	            display.disOut(); // 맵과 플레이어 상태 표시
				try {
					sleep(00);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
	      //낙이 나왔을 경우
	         if (ThrowYut.numberYut == 0) {
	            System.out.println("낙입니다.ㅠ-ㅠ");
	            System.out.println("다음 턴으로 넘어갑니다.");
	            System.out.println();   
	            try {
	               sleep(2000);   //2초 일시정지
	            } catch (InterruptedException e) {
	               e.printStackTrace();
	            }
	            break;
	         }
	      //처음에 빽도가 연속으로 3번 나오면 0번말 골인시켜주는 이벤트
	      if(ThrowYut.countBackA==3 &&(Player.currentHorse[0] == 0)
                  && (Player.currentHorse[1] == 0)
                  && (Player.currentHorse[2] == 0)
                  && (Player.currentHorse[3] == 0)) {
	    		  Player.horseA[0] = 32;
	    		  System.out.println("축하합니다~!! :) ");
			      System.out.println("연속 3번 빽도 달성으로 히든 이벤트가 발생하였습니다");
			      System.out.println("보상으로 0번말을 골인시켜드립니다.^ㅇ^");
	    	  
	      } else if (ThrowYut.countBackB==3 &&(Player.currentHorse[0] == 0)
                  && (Player.currentHorse[1] == 0)
                  && (Player.currentHorse[2] == 0)
                  && (Player.currentHorse[3] == 0)){
	    	 	Player.horseB[0] = 32;
	    	 	 System.out.println("축하합니다~!! :) ");
			     System.out.println("연속 3번 빽도 달성으로 히든 이벤트가 발생하였습니다");
			     System.out.println("보상으로 0번말을 골인시켜드립니다.^ㅇ^");
	     	}
	    	 
	      
	      //이동중인 말이 없는 상황에 빽도가 나왔을 경우
	         if (ThrowYut.numberYut == -1 && (Player.currentHorse[0] == 0 || Player.currentHorse[0] == 32)
	                  && (Player.currentHorse[1] == 0 || Player.currentHorse[1] == 32)
	                  && (Player.currentHorse[2] == 0 || Player.currentHorse[2] == 32)
	                  && (Player.currentHorse[3] == 0 || Player.currentHorse[3] == 32)) {
	            System.out.println("이동할 말이 없습니다. 아쉽지만 상대방 순서로 넘어갑니다.(ㅠㅠ)");
	            System.out.println();
	               try {
	                  sleep(2000);   //2초 일시정지
	               } catch (InterruptedException e) {
	                  e.printStackTrace();
	               }
	               break;
	            }
	      //현재 이동한 말의 번호
	         int k = player.move(); 
	      //상대 말을 죽였다면 1이 반환됨   
	         int re = hunt.kill(k); 
	         if (re == 1) {
	            System.out.println("\n ※※※※  !잡았다 요놈! ※※※※ \n");
	            System.out.println("상대 말을 잡았습니다. 한번 더 던집니다.(^--^)/");
	            i += re; // 이동횟수 1 추가
	         }
	            System.out.println("");
	         }
	      //승리체크
	            winner = win.check();
	        //순서 교대
	         if (Player.currentTurn == 'A') { 
	            Player.currentTurn = 'B';
	            Player.currentName = Player.nameB;
	            Player.currentHorse = Player.horseB;
	         } else if (Player.currentTurn == 'B') {
	            Player.currentTurn = 'A';
	            Player.currentName = Player.nameA;
	            Player.currentHorse = Player.horseA;
	         }
	   }
	      display.disOut();
	      System.out.println("축하합니다~!! :) ");
	      if(Player.currentTurn=='A') {
	         System.out.println("<B> " + "[" + winner + "]" + "님의 승리입니다 !!   *ㅁ*b");
	      }else {
	         System.out.println("<A> " + "[" + winner + "]" + "님의 승리입니다 !!   *ㅁ*b");
	      }
	   }
}