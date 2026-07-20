package course3.biodomefamily04;

import java.util.ArrayList;
import java.util.List;

public class EnergyManager {

    // 에너지 원천 객체 리스트
    private List<EnergySource> energyList;

    // 생성자
    public EnergyManager() {
        this.energyList = new ArrayList<>();
    }

    // 에너지 원천 추가
    public void addEnergySource(EnergySource source) {
        energyList.add(source);
    }

    // 모든 에너지 원천의 남은 에너지 합산 및 출력
    public void getTotalEnergy() {
        int totalEnergy = 0;
        for (EnergySource source : energyList) {
            totalEnergy += source.getEnergyAmount();
        }
        System.out.println("남은 에너지 : " + totalEnergy);
    }
}
