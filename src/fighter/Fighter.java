package fighter;
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
    // SYS-04
    public void resetHp() {
        this.hp = INITIAL_HP;
        System.out.println(name + " 체력 초기화: " + hp);
    }
    public int getHp() {
        return hp;
    }
    public String getName() {
        return name;
    }
}
