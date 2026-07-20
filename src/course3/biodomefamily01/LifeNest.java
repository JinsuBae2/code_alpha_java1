package course3.biodomefamily01;

import java.util.ArrayList;
import java.util.List;

public class LifeNest {
    // 동식물 객체를 저장하는 리스트
    private List<Organism> organismList;

    public LifeNest() {
        this.organismList = new ArrayList<>();
    }

    // 동식물 추가 및 안내 출력
    public void addOrganism(Organism organism) {
        organismList.add(organism);
        System.out.println("[LifeNest] " + organism.getName() + "이(가) 추가되었습니다.");
    }

    // 동식물 객체 삭제 및 안내 출력
    public void removeOrganism(Organism organism) {
        organismList.remove(organism);
        System.out.println("[LifeNest] " + organism.getName() + "이(가) 삭제되었습니다.");
    }

    // 동식물 이름 기준 삭제
    public void removeOrganismByName(String name) {
        for (int i = 0; i < organismList.size(); i++) {
            if (organismList.get(i).getName().equals(name)) {
                organismList.remove(i);
                System.out.println("[LifeNest] " + name + "이(가) 삭제되었습니다.");
                return;
            }
        }
    }

    // 전체 동식물 목록 출력
    public void displayAllOrganisms() {
        System.out.println("전체 동식물 목록 출력:\n");
        for (int i = 0; i < organismList.size(); i++) {
            organismList.get(i).displayInfo();
        }
    }

    // 동식물 이름으로 검색
    public void searchOrganismByName(String name) {
        for (int i = 0; i < organismList.size(); i++) {
            if (organismList.get(i).getName().equals(name)) {
                organismList.get(i).displayInfo();
                return;
            }
        }
        System.out.println(name + "은(는) LifeNest에 존재하지 않습니다.");
    }
}
