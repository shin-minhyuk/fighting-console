package game;

import fighter.AIFighter;
import fighter.Fighter;
import fighter.PlayerFighter;

import java.util.Scanner;

public class GameManager {

    private final Scanner sc = new Scanner(System.in);
    private PlayerFighter player;
    private AIFighter ai;

    public void startGame() {
        printIntro();
        createPlayer();
        System.out.println("\n✅초기화 완료! 게임을 시작합니다.\n");
    }

    public void printIntro() {
        System.out.println("\n--- 💥 격투기 게임 시작! 💥 ---");
        System.out.println("플레이어와 AI가 주사위를 굴려 턴을 진행합니다.");
        System.out.println("각자 랜덤한 액션을 수행하며 체력을 깎아나갑니다.\n");
    }

    public void createPlayer() {
        System.out.print("플레이어 이름을 입력하세요: ");
        String playerName = sc.nextLine();

        Fighter player = new PlayerFighter(playerName, sc);
        Fighter ai = new AIFighter();

        player.resetHp();
        ai.resetHp();
    }
}
