package take6_6Nimmt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Take_6 {
	static List<Card> deck = new ArrayList<>();
	static List<List<Card>> rows = new ArrayList<>();
	static {
		for (int i = 0; i < 4; i++) {
			rows.add(new ArrayList<>());
		}
	}

	static List<Card> worker = new ArrayList<>();
	static Player[] players = new Player[] {
			new Player("user"), new Player("p1"), 
			new Player("p2"), new Player("p3")
			};
	
	
	static Scanner sc = new Scanner(System.in);

	static void userName() { // 이름을 정하는 메서드
//		players[0].name = sc.nextLine().trim();
		players[0].name = "Dw";
		players[0].user = true;
		System.out.println(players[0].name + "님 반갑습니다.");
	}
	static void shuffleCards() {
		for(int i = 0; i < 104; i++) {
			deck.add(new Card());
		}
		Collections.shuffle(deck);
	}
	static void dealCards() {
		for(int i = 0; i < players.length; i++) {
			for(int j = 0; j < 10; j++) {
				players[i].hands.add(deck.remove(0));
			}
			players[i].hands.sort(null);
			
		}
		for(int i = 0; i < 4; i++) {
			rows.get(i).add(deck.remove(0));
		}
	}
	static void playGame() {
		for(int i = 0; i < 10; i++) {
			showRows();
			System.out.printf("\t\t%s의 핸드\n", players[0].name);
			players[0].getHands(); // 카드 정보 보여주기
			System.out.print("낼 카드의 숫자를 입력하세요. >>");
			
			playCards(sc.nextInt());
			System.out.println();
			showPlayedCards();
			getScores();
		}
		endgame();
	}
	static void playCards(int cardNum) {
		players[0].playCard(cardNum);
		for(int j = 1; j < players.length; j++) {
			players[j].playCard((int)(Math.random() * players[j].hands.size()));
		}
	}
	static void showPlayedCards() {
		worker.sort(null);
		worker.stream().forEach(c -> System.out.printf(
				c + " (%s : %d점)\n", c.playedBy.name, c.playedBy.score()) );
		System.out.println();
		System.out.println("숫자가 작은 카드부터 배치합니다. (숫자의 차가 적은 오름차순)");
		while(!worker.isEmpty()) {
			Card c = worker.remove(0);
			System.out.println(c + " 카드를 낸 사람 : " + c.playedBy);
			placeCard(c);
		}
	}
	static void placeCard(Card c) {
		int[] diff = new int[4];
		int cnt = 0, smallestDiff = 103, rowIndex = 5;
		for(int i = 0; i < 4; i++) {
			Card rowCard = rows.get(i).get(rows.get(i).size()-1);
			diff[i] = c.num - rowCard.num;
			if(diff[i] < 0) { cnt++; }
			else { 
				if(smallestDiff > diff[i]) {
					rowIndex = i;
					smallestDiff = diff[i];
				}
			}
		}
		if(cnt == 4) {
			System.out.println("기본 규칙에 따라 배치할 수 없어 한 행을 전부 가져가야 합니다.");
			System.out.println();
			takeRow(c);
		} else {
			System.out.printf("%d행에 " + c + "를 배치합니다.\n",rowIndex+1);	
			rows.get(rowIndex).add(c);
			if(rows.get(rowIndex).size() == 6) {
				System.out.println((1+rowIndex) 
						+ "행에 카드가 5장이 있어, 그 카드들을 " + c.playedBy + "이(가) 전부 가져갑니다. ");
				takeRow(c, rowIndex);
			}
		}
		System.out.println();
	}
	static void takeRow(Card c) {
		int rowIndex;
		if(c.playedBy.user) {
			for(int i = 0; i < 4; i++) {
				System.out.printf("%d행 : ", i+1);
				rows.get(i).forEach(c1 -> System.out.print(c1 + " " ));
				System.out.println();
			}
			System.out.print("가져갈 행을 고르세요(1 ~ 4 숫자). >>");
			rowIndex = sc.nextInt()-1;
		} else {
			rowIndex = (int)(Math.random() * 4);
		}
		while(!rows.get(rowIndex).isEmpty()){
			c.playedBy.gottenCards.add(rows.get(rowIndex).remove(0));
		}
		System.out.println((rowIndex+1) + " 행을 가져갑니다");
		rows.get(rowIndex).add(c);
	}
	static void takeRow(Card c, int rowIndex) {
		while(rows.get(rowIndex).size() != 1){
			c.playedBy.gottenCards.add(rows.get(rowIndex).remove(0));
		}
	}
	
	static void showRows() {
		for(int i = 0; i < 4; i++) {
			System.out.printf("%d행 : ", i +1);
			for(int j = 0; j < rows.get(i).size(); j++) {
				System.out.print(rows.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}
	static void getScores() {
		for(int i = 0; i < players.length; i++) {
			System.out.println(players[i].name + " : " + players[i].score() + "점");
		}
	}
	static void endgame() {
		Arrays.sort( players, (p1, p2) -> p2.score() - p1.score() );
		for(int i = 0; i < players.length; i++) {
			System.out.printf(
					"%d등 : %s %d점\n", i+1, players[i].name, players[i].score());
		}
	}
}