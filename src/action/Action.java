package action;

// ACT-03 액션 정보 관리
public enum Action {

    PUNCH ("주먹", 3, false),
    KICK ("발차기", 5, false),
    UPPERCUT("어퍼컷", 10, false),
    LOWKICK("로우킥", 8, false),
    DODGE("피하기", 0, true); // 방어 액션

    private final String name;
    private final int damage;
    private final boolean isDefensive;

    Action(String name, int damage, boolean isDefensive) {
        this.name = name;
        this.damage = damage;
        this.isDefensive = isDefensive;
    }

    public String getName() {
        return name;
    }

    public int getBaseDamage() {
        return damage;
    }

    public boolean isDefensive() {
        return isDefensive;
    }

    public static Action fromName(String name) {
        for (Action action : Action.values()) {
            if (action.getName().equals(name)) {
                return action;
            }
        }
        throw new IllegalArgumentException("Action " + name + " not found");
    }
}