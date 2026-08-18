package course6.runbiodome02;

import java.util.LinkedHashMap;
import java.util.Map;

public class EnergyDistributor {
    private int totalEnergy = 50000;
    private Map<String, Integer> zoneMap = new LinkedHashMap<>();

    public EnergyDistributor() {
        zoneMap.put("테라노바", 0);
        zoneMap.put("루미나베이", 0);
        zoneMap.put("플로우브릿지", 0);
    }

    public int getTotalEnergy() {
        return totalEnergy;
    }

    public void printEnergy() {
        System.out.println("→ 전체 남은 에너지: " + totalEnergy);
    }

    public void zoneEnergy() {
        System.out.println("→ 구역별 에너지 조회");
        for (Map.Entry<String, Integer> entry : zoneMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    public void allocateEnergy(String zone, int amount) {
        if (amount > totalEnergy) {
            System.out.println("→ 할당 가능한 에너지를 초과했습니다.");
            return;
        }

        EnergyAllocator allocator = (z, a) -> {
            zoneMap.put(z, zoneMap.getOrDefault(z, 0) + a);
            totalEnergy -= a;
        };

        allocator.allocate(zone, amount);

        System.out.println("→ " + zone + "에 " + amount + "의 에너지가 할당되었습니다. 남은 전체 에너지: " + totalEnergy);
    }

}

