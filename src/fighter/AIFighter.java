package fighter;

public class AIFighter extends Fighter{

    public AIFighter() {
        super(createRandomName());
    }

    private static String createRandomName() {
        int num = (int) Math.floor(Math.random() * 6) + 1;

        return switch (num) {
            case 1 -> "가";
            case 2 -> "나";
            case 3 -> "다";
            case 4 -> "라";
            case 5 -> "마";
            default -> "바";
        };
    }
}
