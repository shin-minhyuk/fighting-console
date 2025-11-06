package game;

import action.Action;
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
            playTurn(turn);
            turn++;
        }
    }

    // ----------------------------
    // 🧩 한 턴 진행 (공격 / 반격)
    // ----------------------------
    private void playTurn(int turn) {
        Fighter first = decideFirstTurn();
        Fighter second = (first == player) ? ai : player;
        ConsoleUI.printTurnInfo(turn, first);

        // 선공자 공격
        Action action1 = first.chooseAction();
        action1.execute(first, second);
        if (isGameOver()) return;

        // 반격자 공격
        Action action2 = second.chooseAction();
        action2.execute(second, first);

        ConsoleUI.printHPStatus(player, ai);
    }

    // ----------------------------
    // 💀 게임 종료 판정
    // ----------------------------
    private boolean isGameOver() {
        if (player.getHp() <= 0) {
            System.out.println("\n💀 플레이어가 쓰러졌습니다... 게임 오버!");
            return true;
        } else if (ai.getHp() <= 0) {
            System.out.println("\n🎉 AI를 쓰러뜨렸습니다! 당신의 승리입니다!");
            return true;
        }
        return false;
    }

    // ----------------------------
    // 🧍 플레이어 생성
    // ----------------------------
    public void createPlayer() {
        System.out.print("플레이어 이름을 입력하세요: ");
        String playerName = sc.nextLine();

        System.out.println("------------------------------");
        player = new PlayerFighter(playerName, sc);
        ai = new AIFighter();
        System.out.println("------------------------------");
        player.resetHp();
        ai.resetHp();
        System.out.println("------------------------------");
    }

    // ----------------------------
    // 🎲 선공자 결정
    // ----------------------------
    public Fighter decideFirstTurn() {
        System.out.println("🎲 선공자를 결정합니다!");
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
