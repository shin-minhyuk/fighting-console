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
        ConsoleUI.printIntro();
        createPlayer();
        System.out.println("\n✅초기화 완료! 게임을 시작합니다.\n");

        decideFirstTurn();
    }

    public void createPlayer() {
        System.out.print("플레이어 이름을 입력하세요: ");
        String playerName = sc.nextLine();

        Fighter player = new PlayerFighter(playerName, sc);
        Fighter ai = new AIFighter();

        player.resetHp();
        ai.resetHp();
    }

    public void decideFirstTurn() {
        int playerDice;
        int aiDice;

        while (true) {
            playerDice = Dice.roll(6);
            aiDice = Dice.roll(6);

            System.out.println("플레이어 주사위: " + playerDice);
            System.out.println("AI 주사위: " + aiDice);

            if (playerDice > aiDice) {
                System.out.println("✅ 플레이어가 선공입니다!\n");
                break;
            } else if (playerDice < aiDice) {
                System.out.println("🤖 AI가 선공입니다!\n");
                break;
            } else {
                System.out.println("⚖️ 무승부입니다! 다시 주사위를 굴립니다...\n");
            }
        }
    }
}
