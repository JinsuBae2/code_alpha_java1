package course4.ruleofbiodome07;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Plant implements Comparable<Plant> {

    private String name;
    private String type;
    private int waterAmount;
    private LocalDateTime lastWatered;
    private int waterCycle;
    private int targetHumidity;

    public Plant(String name, String type, int waterAmount, LocalDateTime lastWatered,
                 int waterCycle, int targetHumidity) {
        this.name = name;
        this.type = type;
        this.waterAmount = waterAmount;
        this.lastWatered = lastWatered;
        this.waterCycle = waterCycle;
        this.targetHumidity = targetHumidity;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getRequiredWater() {
        return waterAmount;
    }

    public LocalDateTime getLastWateredTime() {
        return lastWatered;
    }

    public int getWateringInterval() {
        return waterCycle;
    }

    public int getAppropriateHumidity() {
        return targetHumidity;
    }

    public LocalDateTime calculateNextWateringTime() {
        return lastWatered.plusHours(waterCycle);
    }

    public void water() {
        lastWatered = LocalDateTime.now();
    }

    @Override
    public int compareTo(Plant o) {
        return this.calculateNextWateringTime().compareTo(o.calculateNextWateringTime());
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return name + ", " + waterAmount + ", 마지막 물 공급 일자: " + lastWatered.format(fmt)
                + ", 물 공급 주기: " + waterCycle + "시간, 적정 습도: " + targetHumidity + "%";
    }
}
