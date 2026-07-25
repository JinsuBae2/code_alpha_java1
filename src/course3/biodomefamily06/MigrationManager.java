package course3.biodomefamily06;

import java.util.ArrayList;
import java.util.List;

public class MigrationManager {
    private List<Animal> animals;

    public MigrationManager(List<Animal> animals) {
        this.animals = animals;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    // 안전한 순서의 동물 배열을 재구성하여 반환하는 메서드
    public List<Animal> getSafeSequence() throws UnsafeSequenceException {
        List<Animal> result = new ArrayList<>();
        boolean[] visited = new boolean[animals.size()];
        if (backtrack(result, visited)) {
            return result;
        }
        throw new UnsafeSequenceException("안전한 이동 순서를 배치할 수 없습니다! (모순된 조건 발생)");
    }

    // 백트래킹을 이용한 순열 탐색
    private boolean backtrack(List<Animal> result, boolean[] visited) {
        if (result.size() == animals.size()) {
            return isSafe(result);
        }

        for (int i = 0; i < animals.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                result.add(animals.get(i));

                if (backtrack(result, visited)) {
                    return true;
                }

                result.remove(result.size() - 1);
                visited[i] = false;
            }
        }
        return false;
    }

    // 주어진 리스트가 안전 규칙을 통과하는지 검증하는 메서드
    private boolean isSafe(List<Animal> list) {
        int tigerIndex = -1;
        int deerIndex = -1;

        // 호랑이와 사슴의 인덱스를 찾음
        for (int i = 0; i < list.size(); i++) {
            Animal a = list.get(i);
            if (a.getType() == AnimalType.TIGER) {
                tigerIndex = i;
            } else if (a.getType() == AnimalType.DEER) {
                deerIndex = i;
            }
        }

        // 호랑이가 사슴보다 앞에 있어야 함 (tigerIndex < deerIndex)
        if (tigerIndex != -1 && deerIndex != -1 && tigerIndex > deerIndex) {
            return false;
        }

        // 5살 이하 코끼리는 호랑이 앞에 올 수 없음 (elephantIndex > tigerIndex)
        if (tigerIndex != -1) {
            for (int i = 0; i < list.size(); i++) {
                Animal a = list.get(i);
                if (a.getType() == AnimalType.ELEPHANT && a.getAge() <= 5) {
                    if (i < tigerIndex) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
