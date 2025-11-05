package game;

import fighter.Fighter;

public class ConsoleUI {

    public static void printIntro() {
        System.out.println("\n--- 💥 격투기 게임 시작! 💥 ---");
        System.out.println("플레이어와 AI가 주사위를 굴려 턴을 진행합니다.");
        System.out.println("각자 랜덤한 액션을 수행하며 체력을 깎아나갑니다.\n");
    }

    public static void printTurnInfo(Fighter firstTurnUser) {
        System.out.println("첫번째 공격 턴은 " + "'" + firstTurnUser.getName() + "' 입니다.");
    }
}
