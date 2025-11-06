package fighter;

import action.Action;

import java.util.Scanner;

public class PlayerFighter extends Fighter {

    // FR-030, ACT-01
    private final Scanner scanner;

    public PlayerFighter(String name, Scanner scanner) {
        super(name);
        this.scanner = scanner;
        System.out.println("플레이어 생성 완료: " + name);
    }

    @Override
    public Action chooseAction() {
        System.out.println("\n==== 사용할 공격을 선택하세요 ====");
        for (Action action : Action.values()) {
            System.out.println("- " + action.getName() + " (" + action.getBaseDamage() + " 피해)");
        }
        System.out.print("입력: ");
        String input = scanner.nextLine().trim();

        try {
            return Action.fromName(input);
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력입니다. 기본 공격(PUNCH)으로 진행합니다.");
            return Action.PUNCH;
        }
    }
}
