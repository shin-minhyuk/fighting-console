package game;

import fighter.AIFighter;
import fighter.Fighter;
import fighter.PlayerFighter;

public class ConsoleUI {

    public static void printIntro() {
        System.out.println("\n--- 💥 격투기 게임 시작! 💥 ---");
        System.out.println("플레이어와 AI가 주사위를 굴려 턴을 진행합니다.");
        System.out.println("각자 랜덤한 액션을 수행하며 체력을 깎아나갑니다.\n");
    }

    public static void printTurnInfo(int turnNumber, Fighter firstTurnUser) {
        System.out.println("--- [TURN " + turnNumber + "] ---");
        System.out.println("🎯 첫 번째 공격자는 '" + firstTurnUser.getName() + "' 입니다!");
    }

    public static void printHPStatus(PlayerFighter player, AIFighter ai) {
        System.out.println("\n-----------------------------");
        System.out.println("❤️ 플레이어 HP: " + player.getHp());
        System.out.println("🤖 AI HP: " + ai.getHp());
        System.out.println("-----------------------------");
    }

    public static void printActionLog(String attackerName, String defenderName, String actionName, int damageDealt) {
        System.out.print(" ▶️ " + attackerName + " 의 " + actionName + "👊");
        System.out.println(" ➡️ " + defenderName + "에게 " + damageDealt + " 대미지 💔");
    }

    public static void printHitEffect(boolean isCritical) {
        if (isCritical) {
            // 치명타 발생 시
            System.out.println("  [ 💥💥 크리티컬!! 💥💥 ]");
        } else {
            // 일반 타격
            System.out.println("[ 일반 공격!! ]");
        }
    }
}
