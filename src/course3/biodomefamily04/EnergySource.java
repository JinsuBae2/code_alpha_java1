package course3.biodomefamily04;

public abstract class EnergySource {

    // 에너지 원천 이름 (변경 불가)
    private final String sourceName;

    // 현재 에너지 보유량
    private int energyAmount;

    // 생성자 (에너지 원천 이름 설정)
    public EnergySource(String sourceName) {
        this.sourceName = sourceName;
        this.energyAmount = 0;
    }

    // Getter & Setter
    public String getSourceName() {
        return sourceName;
    }

    public int getEnergyAmount() {
        return energyAmount;
    }

    public void setEnergyAmount(int energyAmount) {
        this.energyAmount = energyAmount;
    }

    // 에너지 사용 및 부족 시 예외 안내 출력
    public void useEnergy(int amount) {
        if (this.getEnergyAmount() < amount) {
            System.out.println("에너지가 부족해 " + getSourceName() + " 에너지 " + amount + "를 사용할 수 없습니다.");
        } else {
            setEnergyAmount(getEnergyAmount() - amount);
            System.out.println(getSourceName() + " 에너지를 " + amount + " 사용했습니다.");
        }
    }

    // 에너지 생산 추상 메서드
    public abstract void produceEnergy(int value);
}
