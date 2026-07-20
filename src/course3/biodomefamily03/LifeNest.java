package course3.biodomefamily03;

import java.util.ArrayList;
import java.util.List;

public class LifeNest {
    // 다형성을 위한 Organism 객체 리스트
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

    // 전체 동식물 목록 출력 (오버라이딩된 displayInfo 호출)
    public void displayAll() {
        System.out.println("전체 동식물 목록 출력 : ");
        for (int i = 0; i < organismList.size(); i++) {
            organismList.get(i).displayInfo();
        }
    }
}
