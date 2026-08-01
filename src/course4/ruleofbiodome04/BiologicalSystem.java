package course4.ruleofbiodome04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BiologicalSystem<T> {
    private List<BiologicalEntity<? extends T>> biologicalEntities;

    public BiologicalSystem() {
        this.biologicalEntities = new ArrayList<>();
        System.out.println("생물 정보 시스템이 생성되었습니다.");
    }

    public void add(BiologicalEntity<? extends T> entity) {
        biologicalEntities.add(entity);
        System.out.println("새로운 생물이 등록되었습니다 : " + entity.getName());
    }

    public void delete() {
        if (biologicalEntities.isEmpty()) {
            System.out.println("등록된 생물 정보가 비어있습니다.");
            return;
        }
        int idx = biologicalEntities.size()-1;
        System.out.println("생물이 삭제 되었습니다 : " + biologicalEntities.get(idx).getName());
        biologicalEntities.remove(idx);
    }

    public void clear() {
        if (biologicalEntities.isEmpty()) {
            System.out.println("등록된 생물 정보가 비어있습니다.");
            return;
        }
        biologicalEntities.clear();
        System.out.println("모든 정보를 삭제했습니다.");
    }

    public void show() {
        if (biologicalEntities.isEmpty()) {
            System.out.println("등록된 생물 정보가 없습니다.");
            return;
        }

        System.out.println("최신 등록 생물 : " + biologicalEntities.get(biologicalEntities.size()-1));
    }

    public boolean isEmpty() {
        if (biologicalEntities.isEmpty()) {
            System.out.println("등록된 생물 정보가 비어있습니다.");
            return true;
        } else {
            System.out.println("등록된 생물 정보가 비어있지 않습니다.");
            return false;
        }
    }

    public void sortByName() {
        biologicalEntities.sort(Comparator.comparing(BiologicalEntity::getName));
        System.out.println("--- 모든 생물들이 이름순으로 정렬 되었습니다. ---");
        for (BiologicalEntity<? extends T> entity : biologicalEntities) {
            System.out.println(entity);
        }
    }
}
