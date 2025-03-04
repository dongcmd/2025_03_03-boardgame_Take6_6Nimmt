package Take_6;

import java.util.ArrayList;
import java.util.List;

public class Player {
	List<Card> hands = new ArrayList<>();
	List<Card> gottenCards = new ArrayList<>();
	boolean user = false;
	String name;
	
	Player(String name) {
		this.name = name;
	}
	void playCard(int i) {
		if(user) {
			for(int j = 0; j < hands.size(); j++) {
				if(i == hands.get(j).num) {
					i = j+1; break;
				}
			}
		}
		hands.get(i-1).playedBy = this;
		Take_6.worker.add(hands.remove(i-1));
	}
	int score() {
		return gottenCards.stream().mapToInt(c -> c.score).sum();
	}
	public void getHands() {
		String cards = "";
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 5; j++) {
				cards += hands.get(i+j) + " ";
			}
			cards = cards.trim() + "\n";
		}
		System.out.print(cards);
	}
	@Override
	public String toString() {
		return name;
	}
}
