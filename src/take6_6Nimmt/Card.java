package take6_6Nimmt;

public class Card implements Comparable<Card> {
	static int cnt;
	int num, score = -1;
	Player playedBy;
	Card() {
		num = ++cnt;
		if(num%10 == 5 && num != 55) {
			score = -2; return; } // 5로 끝나면 -2 (55 제외)
		if(num%10 == 0) { score = -3; return; } // 0으로 끝나면 -3
		if(num/10 == num%10) { score = -5; return; } // 숫자가 같으면 -5
		if(num == 55) { score = -7; return; } // 55는 -7
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
