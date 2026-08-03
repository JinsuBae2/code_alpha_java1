package course4.ruleofbiodome06;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AnimalFrequencyAnalyzer {
    private Map<String, Integer> animalCountMap;

    public AnimalFrequencyAnalyzer() {
        this.animalCountMap = new HashMap<>();
    }

    public void analyze(String[] animals) {
        for (int i = 0; i < animals.length; i++) {
            if (animalCountMap.containsKey(animals[i])) {
                animalCountMap.put(animals[i], animalCountMap.get(animals[i]) + 1);
            } else {
                animalCountMap.put(animals[i], 1);
            }
        }
    }

    public Set<String> findMostFrequentAnimals() {
        int maxCount = 0;
        Set<String> maxAnimals = new HashSet<>();
        for (Map.Entry<String, Integer> entry : animalCountMap.entrySet()) {
            int count = entry.getValue();

            if (maxCount < count) {
                maxCount = count;
            }
        }

        for (Map.Entry<String, Integer> entry : animalCountMap.entrySet()) {
            String animal = entry.getKey();

            if (maxCount == entry.getValue()) {
                maxAnimals.add(animal);
            }
        }

        return maxAnimals;
    }

    public Set<String> getObservedAnimals() {
        return animalCountMap.keySet();
    }

    public Map<Integer, Set<String>> groupAnimalsByFrequency() {
        Map<Integer, Set<String>> frequencyGroupMap = new HashMap<>();

        for (Map.Entry<String, Integer> entry : animalCountMap.entrySet()) {

            String animal = entry.getKey();
            int count = entry.getValue();

            if (!frequencyGroupMap.containsKey(count)) {
                frequencyGroupMap.put(count, new HashSet<>());
            }

            frequencyGroupMap.get(count).add(animal);
        }

        return frequencyGroupMap;
    }
}
