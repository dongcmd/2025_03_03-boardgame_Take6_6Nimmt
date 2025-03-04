package Take_6;

import java.util.ArrayList;
import java.util.List;

public class Player {
	List<Card> hands = new ArrayList<>();
	String name;
	
	Player(String name) {
		this.name = name;
	}
	void playCard(int i) {
		Take_6.worker.add(hands.remove(i-1));
	}
	int scores() {
		return hands.stream().mapToInt(c -> c.score).sum();
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
	void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return name;
	}
}
