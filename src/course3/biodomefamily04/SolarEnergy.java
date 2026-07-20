package course3.biodomefamily04;

public class SolarEnergy extends EnergySource {

    // 생성자 (태양광 에너지 이름 설정)
    public SolarEnergy() {
        super("태양광");
    }

    // 태양광 에너지 생산 (일조 시간 * 10)
    @Override
    public void produceEnergy(int value) {
        int energyValue = value * 10;
        this.setEnergyAmount(energyValue + getEnergyAmount());
        System.out.println("태양광 에너지를 " + energyValue + " 생산했습니다.");
    }
}
