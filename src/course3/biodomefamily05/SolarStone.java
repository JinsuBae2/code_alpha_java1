package course3.biodomefamily05;

public class SolarStone extends AncientArtifact implements EnergyGenerator, Chargeable {
    private int chargeLevel;

    public SolarStone(String name) {
        super(name);
        this.chargeLevel = 0;
    }

    @Override
    public void describe() {
        System.out.println("\"태양의 돌로 에너지 생성 중! 빛을 받은 시간에 따라 에너지의 양이 달라집니다.\"");
    }

    @Override
    public void generateEnergy() {
        System.out.println("\"태양의 돌로 에너지를 생성했습니다!\"");
    }

    @Override
    public int getChargeLevel() {
        return this.chargeLevel;
    }

    @Override
    public void setChargeLevel(int level) {
        this.chargeLevel = level;
    }
}
