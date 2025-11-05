package fighter;

public class AIFighter extends Fighter{

    public AIFighter() {
        super(createRandomName());
        System.out.println("AI 상대 생성 완료: " + super.getName());
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
