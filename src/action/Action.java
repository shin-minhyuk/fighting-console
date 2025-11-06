package action;

import fighter.Fighter;
import game.Dice;

public enum Action {

    PUNCH("주먹", 3),
    KICK("발차기", 5),
    UPPERCUT("어퍼컷", 8),
    LOWKICK("로우킥", 6);

    private final String name;
    private final int baseDamage;

    Action(String name, int baseDamage) {
        this.name = name;
        this.baseDamage = baseDamage;
    }

    public String getName() {
        return name;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public static Action fromName(String name) {
        for (Action action : Action.values()) {
            if (action.getName().equals(name)) {
                return action;
            }
        }
        throw new IllegalArgumentException("Action " + name + " not found");
    }

    /** 공격 실행 로직 */
    public void execute(Fighter attacker, Fighter defender) {
        int damage = baseDamage + Dice.roll(3); // 약간의 랜덤성
        defender.applyDamage(damage);
        System.out.println(attacker.getName() + "의 " + name + "! " + damage + " 피해를 입혔습니다!");
    }
}