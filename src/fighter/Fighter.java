package fighter;

import action.Action;
import game.Dice;

// NFR-010
public abstract class Fighter {
    // 이름
    private final String name;
    // 체력
    private int hp;
    // 초기 체력 설정
    private static final int INITIAL_HP = 100;

    public Fighter(String name) {
        this.name = name;
        // 초기 체력 = 100
        this.hp = INITIAL_HP;
    }
    // CBT-03
    private static final int CRITICAL_CHANCE = 10; // 10%

    private boolean calculateCritical() {
        // 1부터 100까지 굴려서 10 이하가 나오면 치명타
        int roll = Dice.roll(100);
        return roll <= CRITICAL_CHANCE;
    }
    public int[] attack(Fighter target, Action action) {
        int rawDamage = action.getBaseDamage() + Dice.roll(3);
        // 판정
        boolean isCrit = calculateCritical();

        // 최종 데미지 계산
        int finalDamage = rawDamage;
        if (isCrit) {
            finalDamage *= 2; // 데미지 2배 적용
        }
        target.applyDamage(finalDamage); // 타겟에게 적용

        finalDamage = Math.max(1, finalDamage); // 데미지 최소 1

        // 대상에게 적용
        target.applyDamage(finalDamage);

        // 결과
        int criticalFlag = isCrit ? 1 : 0;
        return new int[]{finalDamage,  criticalFlag};
    }


    // SYS-04
    public void resetHp() {
        this.hp = INITIAL_HP;
        System.out.println(name + " 체력 초기화: " + hp);
    }

    public int getHp() {
        return hp;
    }

    private void setHp(int hp) {
        this.hp = Math.max(0, hp); // 0 미만 내려가지 않게 안전장치
    }

    public void applyDamage(int damage) {
        setHp(this.hp - damage);
    }

    public String getName() {
        return name;
    }

    public abstract Action chooseAction();

}
