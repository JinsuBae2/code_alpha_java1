package course3.biodomefamily05;

public interface Chargeable {
    void setChargeLevel(int level);

    default int getChargeLevel() {
        return 0;
    }

    default void charge(int amount) {
        setChargeLevel(getChargeLevel() + amount);
    }

    static void showChargingTips() {
        System.out.println("에너지를 효율적으로 충전하려면 마법사의 기분이 좋아야합니다.");
    }
}
