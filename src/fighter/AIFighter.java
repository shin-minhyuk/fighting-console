package fighter;

import action.Action;

import java.util.Random;

public class AIFighter extends Fighter {

    private final Random random = new Random();

    public AIFighter() {
        super(createRandomName());
        System.out.println("AI 생성 완료: " + super.getName());
    }

    @Override
    public Action chooseAction() {
        Action[] actions = Action.values();
        return actions[random.nextInt(actions.length)];
    }


    private static String createRandomName() {
        int num = (int) Math.floor(Math.random() * 6) + 1;

        return switch (num) {
            case 1 -> "AI 1";
            case 2 -> "AI 2";
            case 3 -> "AI 3";
            case 4 -> "AI 4";
            case 5 -> "AI 5";
            default -> "AI 6";
        };
    }
}
