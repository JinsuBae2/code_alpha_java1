package course4.ruleofbiodome07;

import java.util.ArrayList;
import java.util.List;

public class PlantPriorityQueue {
    private List<Plant> plants;

    public PlantPriorityQueue() {
        this.plants = new ArrayList<>();
    }

    public void offer(Plant plant) {
        plants.add(plant);
    }

    public boolean isEmpty() {
        return plants.isEmpty();
    }

    public Plant peek() {
        if (plants.isEmpty()) {
            System.out.println("리스트가 비어있습니다.");
            return null;
        }

        Plant top = plants.get(0);

        for (int i = 1; i < plants.size(); i++) {
            int cmp = plants.get(i).compareTo(top);

            if (cmp < 0) {
                top = plants.get(i);
            }
        }

        return top;
    }

    public void remove(Plant plant) {
        for (int i = 0; i < plants.size(); i++) {
            if (plants.get(i).getName().equals(plant.getName())) {
                plants.remove(i);
                return;
            }
        }
    }

    public void clear() {
        plants.clear();
    }

    public boolean contains(Plant plant) {
        for (Plant p : plants) {
            if (p.getName().equals(plant.getName())) {
                return true;
            }
        }

        return false;
    }

    public List<Plant> getPlantsInPriorityOrder() {
        List<Plant> copy = new ArrayList<>(plants);
        List<Plant> result = new ArrayList<>();

        while (!copy.isEmpty()) {
            Plant top = copy.get(0);

            for (int i = 1; i < copy.size(); i++) {
                if (copy.get(i).compareTo(top) < 0) {
                    top = copy.get(i);
                }
            }

            result.add(top);
            copy.remove(top);
        }

        return result;
    }
}
