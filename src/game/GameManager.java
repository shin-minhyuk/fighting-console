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

        int turn = 1;
        while (!isGameOver()) {
            Fighter firstTurnUser = decideFirstTurn();
            Fighter secondTurnUser = (firstTurnUser == player) ? ai : player;
            ConsoleUI.printTurnInfo(turn, firstTurnUser);

            // --- 임시 테스트 로직 시작 ---
            System.out.println("공격 테스트를 진행합니다!");

            int damage1 = Dice.roll(10); // 1~10 랜덤
            secondTurnUser.applyDamage(damage1);

            // 즉시 종료 여부 확인 (AI나 플레이어가 죽을 수 있으니까)
            if (isGameOver()) break;

            // 반격자 공격
            int damage2 = Dice.roll(10);
            firstTurnUser.applyDamage(damage2);

            // 현재 체력 표시
            System.out.println("플레이어 HP: " + player.getHp() + " || AI HP: " + ai.getHp());
            System.out.println("-----------------------------");

            turn++;
        }
    }

    private boolean isGameOver() {
        // 플레이어 또는 AI 체력이 0 이하라면 게임 종료
        if (player.getHp() <= 0) {
            System.out.println("\n💀 플레이어가 쓰러졌습니다... 게임 오버!");
            return true;
        } else if (ai.getHp() <= 0) {
            System.out.println("\n🎉 AI를 쓰러뜨렸습니다! 당신의 승리입니다!");
            return true;
        }

        // 둘 다 살아있으면 게임 계속
        return false;
    }

    public void createPlayer() {
        System.out.print("플레이어 이름을 입력하세요: ");
        String playerName = sc.nextLine();

        player = new PlayerFighter(playerName, sc);
        ai = new AIFighter();

        player.resetHp();
        ai.resetHp();
    }

    public Fighter decideFirstTurn() {
        System.out.println("\n🎲 선공자를 결정합니다!");
        System.out.println("엔터를 눌러 주사위를 굴리세요...");
        sc.nextLine();

        int playerDice;
        int aiDice;

        while (true) {
            System.out.println("플레이어가 주사위를 굴리는 중");
            playerDice = Dice.roll(6);
            System.out.println("🎯 결과: " + playerDice);

            System.out.println("AI가 주사위를 굴리는 중");
            aiDice = Dice.roll(6);
            System.out.println("🎯 결과: " + aiDice);

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

        return playerDice > aiDice ? player : ai;
    }
}
