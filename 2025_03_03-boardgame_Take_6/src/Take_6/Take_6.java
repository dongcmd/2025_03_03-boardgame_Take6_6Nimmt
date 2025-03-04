package Take_6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Take_6 {
	static List<Card> deck = new ArrayList<>();
	static List<Card>[] rows = new ArrayList[] {
			new ArrayList<>(), new ArrayList<>(), 
			new ArrayList<>(), new ArrayList<>()
			};
	static List<Card> worker = new ArrayList<>();
	static Player[] players = new Player[] {
			new Player("user"), new Player("p1"), 
			new Player("p2"), new Player("p3")
			};
	static Scanner sc = new Scanner(System.in);

	static void userName() {
		players[0].setName(sc.nextLine().trim());
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
				players[i].hands.add(deck.get(i+j));
			}
			Collections.sort(players[i].hands);
		}
	}
	static void play() {
		for(int i = 0; i < 10; i++) {
			showRows();
			players[0].getHands(); // 카드 정보 보여주기
			System.out.println("낼 카드를 고르세요. >>");
			players[0].playCard(sc.nextInt());
			// 각 플레이어가 낸 카드 보여주기
			// 규칙에 맞게 배치 후 카드를 가져가는 사람이 있으면 알려주기
			// 각 플레이어 점수 출력
		}
	}
	static void showRows() {
		for(int i = 0; i < 4; i++) {
			System.out.printf("%d행 : ", i +1);
			for(int j = 0; j < 6; j++) {
				System.out.print(rows[i].get(j) + " ");
			}
			System.out.println("[   ,   ]");
		}
	}
}
