package course3.biodomefamily04;

public class GeothermalEnergy extends EnergySource {

    // 생성자 (지열 에너지 이름 설정)
    public GeothermalEnergy() {
        super("지열");
    }

    // 지열 에너지 생산 (지층 온도 * 5 + 20)
    @Override
    public void produceEnergy(int value) {
        int energyValue = value * 5 + 20;
        this.setEnergyAmount(energyValue + getEnergyAmount());
        System.out.println("지열 에너지를 " + energyValue + " 생산했습니다.");
    }
}
