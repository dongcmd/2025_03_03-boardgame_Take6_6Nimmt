package Take_6;

import java.io.IOException;


public class Main {
	
	
	public static void main(String[] args) throws IOException {
		System.out.println("젝스님트(Take 6)를 시작합니다."
				+ "플레이어 명을 입력하세요.");
		Take_6.userName();
		System.out.printf("%d인 플레이를 시작합니다."
				+ "카드 104장을 섞어 10장씩 나눠줍니다.\n", Take_6.players.length);
		Take_6.shuffleCards();
		Take_6.dealCards();
		Take_6.play();
		
		
	}
	
}