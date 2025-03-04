package Take_6;

public class Card implements Comparable<Card> {
	static int cnt;
	int num, score;
	Player playedBy;
	Card() {
		num = ++cnt;
		score = (int)(Math.random() * -5 -1);
	}
	@Override
	public int compareTo(Card c) {
		return this.num - c.num;
	}
	@Override
	public String toString() {
		return String.format("[%3d, %d]", num, score);
	}
}
