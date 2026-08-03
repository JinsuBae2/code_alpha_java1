package course4.ruleofbiodome07;

import java.time.format.DateTimeFormatter;

public class PlantManagementSystem {
    private PlantPriorityQueue queue;
    private int todayHumidity;

    public PlantManagementSystem(int todayHumidity) {
        this.queue = new PlantPriorityQueue();
        this.todayHumidity = todayHumidity;
        System.out.println("식물 관리 시스템이 생성되었습니다. 오늘의 습도: " + todayHumidity + "%");
    }

    public void addPlant(Plant plant) {
        queue.offer(plant);
        System.out.println(plant.getName() + "이 관리 대상 목록에 추가되었습니다.");
    }

    public Plant showNextPlant() {
        Plant plant = queue.peek();

        if (plant == null) {
            return null;
        }

        System.out.println("우선 관리 대상: " + plant.getName() + ", 필요한 물의 양: " + plant.getRequiredWater());
        return plant;
    }

    public void waterPlant(Plant plant) {
        if (!queue.contains(plant)) {
            System.out.println("관리 대상에 없는 식물입니다.");
            return;
        }

        double waterAmount = plant.getRequiredWater();

        if (todayHumidity < plant.getAppropriateHumidity()) {
            waterAmount *= 1.5;
            System.out.println("오늘의 습도가 적정 습도보다 낮아 물을 1.5배 공급합니다.");
        }

        plant.water();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        System.out.println(plant.getName() + "에 물을 " + waterAmount
                + "만큼 공급했습니다. 마지막 물 공급 일자 업데이트: "
                + plant.getLastWateredTime().format(fmt));
        queue.remove(plant);
    }

    public void showRemainingPlants() {
        System.out.println("(남아있는 식물)");

        if (queue.isEmpty()) {
            System.out.println("관리 대상 식물이 없습니다.");
            return;
        }

        for (Plant plant : queue.getPlantsInPriorityOrder()) {
            System.out.println(plant);
        }
    }
}
