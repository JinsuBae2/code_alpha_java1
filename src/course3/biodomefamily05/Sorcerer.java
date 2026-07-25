package course3.biodomefamily05;

import java.util.ArrayList;
import java.util.List;

public class Sorcerer {
    private String name;
    private final List<AncientArtifact> artifacts;

    public Sorcerer(String name) {
        this.name = name;
        this.artifacts = new ArrayList<>();
        System.out.println("마법사 '" + name + "'이 생성되었습니다.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AncientArtifact> getArtifacts() {
        return artifacts;
    }

    public void addArtifact(AncientArtifact artifact) {
        this.artifacts.add(artifact);
        System.out.println("마법사 '" + name + "'이 " + artifact.getName() + "을 소유하게 되었습니다.");
    }

    public void checkArtifactAbility(AncientArtifact artifact) {
        System.out.println("마법사 '" + name + "'이 " + artifact.getName() + "의 능력을 확인합니다.\n");
        artifact.describe();
        System.out.println();
    }

    public void useEnergyGeneration(AncientArtifact artifact) {
        if (artifact instanceof EnergyGenerator) {
            System.out.println("마법사 '" + name + "'이 " + artifact.getName() + "의 에너지 생성 능력을 사용합니다.");
            ((EnergyGenerator) artifact).generateEnergy();
        } else {
            System.out.println("마법사 '" + name + "'이 " + artifact.getName() + "의 에너지 생성 능력을 사용하려고 했으나, " + artifact.getName() + "은(는) 에너지를 생성할 수 없습니다.");
        }
    }

    public void useWeatherControl(AncientArtifact artifact) {
        if (artifact instanceof WeatherController) {
            System.out.println("마법사 '" + name + "'이 " + artifact.getName() + "의 날씨 조절 능력을 사용합니다.");
            ((WeatherController) artifact).controlWeather();
        } else {
            System.out.println("마법사 '" + name + "'이 " + artifact.getName() + "의 날씨 조절 능력을 사용하려고 했으나, " + artifact.getName() + "은(는) 날씨를 조절할 수 없습니다.");
        }
    }
}
