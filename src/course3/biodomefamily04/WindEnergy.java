package course3.biodomefamily04;

public class WindEnergy extends EnergySource {

    // 생성자 (풍력 에너지 이름 설정)
    public WindEnergy() {
        super("풍력");
    }

    // 풍력 에너지 생산 (바람 속도 * 5)
    @Override
    public void produceEnergy(int value) {
        int energyValue = value * 5;
        this.setEnergyAmount(energyValue + getEnergyAmount());
        System.out.println("풍력 에너지를 " + energyValue + " 생산했습니다.");
    }
}
