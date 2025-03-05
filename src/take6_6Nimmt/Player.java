package take6_6Nimmt;

import java.util.ArrayList;
import java.util.List;

public class Player {
	List<Card> hands = new ArrayList<>();
	List<Card> gottenCards = new ArrayList<>();
	boolean user = false;
	String name;
	
	Player(String name) { this.name = name; }
	public void getHands() {
		List<Card> tmp = new ArrayList<>(hands);
		String cards = "";
		int cnt = 0;
		while(!tmp.isEmpty()) {
			cnt++;
			cards += tmp.remove(0) + " ";
			if(cnt == 5) cards = cards.trim() + "\n";
		}	
		System.out.println(cards);
	}
	void playCard(int cardNum) {
		if(user) {
			for(int i = 0; i < hands.size(); i++) {
				if(cardNum == hands.get(i).num) {
					cardNum = i; break;
				}
			}
		}
		hands.get(cardNum).playedBy = this;
		Take_6.worker.add(hands.remove(cardNum));
	}
	int score() {
		return gottenCards.stream().mapToInt(c -> c.score).sum();
	}
	@Override
	public String toString() {
		return name;
	}
}
