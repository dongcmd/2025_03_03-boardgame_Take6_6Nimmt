package take6_6Nimmt;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
/*
 * 4인 게임을 기준으로 제작.
 * [게임규칙]
 * 1~104까지 카드를 섞어, 1인당 10장씩 나눠 준다.
 * 중앙에 4행의 카드열이 있고 한 행에 5장까지 카드를 놓을 수 있다.
 * 동시에 카드를 1장씩 낸 뒤 아래의 [배치규칙]에 따라 배치한다.
 * 6번째 카드를 배치해야 할 경우, 그 행의 카드를 전부 가져가 내 앞에 내려둔 뒤 배치한다.
 * 10장의 카드를 모두 소진한 이후 점수를 가장 적게 잃은 사람이 승리
 * 			(기존 게임은 누군가 -66점을 달성하게 되는 라운드까지 진행)
 * 
 * 카드 보는 법 [카드의 숫자(1 ~ 104), 벌점(-1 ~ -7)]
 * 
 * 		[배치규칙]
 * 		1. 카드는 오름차순으로 배치한다.
 * 		2. 4개의 행의 마지막 카드 중, 숫자의 차가 적은 곳에 배치한다.
 * 		3. 위 규칙을 따를 수 없다면 하나의 행의 카드를 전부 가져간 뒤 그곳에 배치한다.
 * 
 * 나를 제외한 3명의 Bot은 모든 선택을 랜덤으로 한다.
 */
		
		System.out.println("젝스님트(Take 6)를 시작합니다."
				+ "플레이어 명을 입력하세요.");
		Take_6.userName();
		System.out.printf("%d인 플레이를 시작합니다."
				+ "카드 104장을 섞어 10장씩 나눠줍니다.\n", Take_6.players.length);
		Take_6.shuffleCards();
		Take_6.dealCards();
		Take_6.playGame();
		
		
	}
	
}