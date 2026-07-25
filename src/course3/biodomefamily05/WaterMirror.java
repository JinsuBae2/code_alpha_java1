package course3.biodomefamily05;

public class WaterMirror extends AncientArtifact implements EnergyGenerator, WeatherController, Chargeable {
    private int chargeLevel;

    public WaterMirror(String name) {
        super(name);
        this.chargeLevel = 0;
    }

    @Override
    public void describe() {
        System.out.println("\"물의 거울 : 수증기를 모아 에너지를 생성하고, 날씨를 조절함(예. 습도에 영향을 받으며, 비와 눈을 내림)\"");
    }

    @Override
    public void generateEnergy() {
        System.out.println("\"물의 거울을 이용해 수증기로 에너지를 생성했습니다!\"");
    }

    @Override
    public void controlWeather() {
        System.out.println("\"물의 거울을 이용해 습도를 조절하고 비와 눈을 내립니다!\"");
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
