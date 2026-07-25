package course3.biodomefamily05;

public class WindAmulet extends AncientArtifact implements WeatherController {

    public WindAmulet(String name) {
        super(name);
    }

    @Override
    public void describe() {
        System.out.println("\"바람의 부적 : 주변 공기의 흐름을 이용해 날씨를 조절함(예. 저기압, 고기압, 강풍 등)\"");
    }

    @Override
    public void controlWeather() {
        System.out.println("\"바람의 부적을 이용해 공기의 흐름을 제어하여 날씨를 조절합니다!\"");
    }
}
