package course3.biodomefamily02;

import java.util.ArrayList;
import java.util.List;

public class LifeNest {
    // 동식물 객체 리스트
    private List<Organism> organismList;

    // 생성자
    public LifeNest() {
        this.organismList = new ArrayList<>();
    }

    // 동식물 추가
    public void addOrganism(Organism organism) {
        organismList.add(organism);
        System.out.println("[LifeNest] " + organism.getName() + "이(가) 추가되었습니다.");
    }

    // 동식물 삭제
    public void removeOrganism(Organism organism) {
        organismList.remove(organism);
        System.out.println("[LifeNest] " + organism.getName() + "이(가) 삭제되었습니다.");
    }

    // 전체 동식물 목록 출력
    public void displayAllOrganisms() {
        System.out.println("전체 동식물 목록 출력:");
        for (Organism organism : organismList) {
            organism.displayInfo();
        }
    }
}
