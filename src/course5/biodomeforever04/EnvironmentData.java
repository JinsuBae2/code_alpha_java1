package course5.biodomeforever04;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EnvironmentData {
    private String datetime;
    private double temperature;
    private double humidity;
    private double oxygen;
    private String location;

    public EnvironmentData(double temperature, double humidity, double oxygen, String location) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        this.datetime = LocalDateTime.now().format(formatter);
        this.temperature = temperature;
        this.humidity = humidity;
        this.oxygen = oxygen;
        this.location = location;
    }

    public EnvironmentData(String datetime, double temperature, double humidity, double oxygen, String location) {
        this.datetime = datetime;
        this.temperature = temperature;
        this.humidity = humidity;
        this.oxygen = oxygen;
        this.location = location;
    }

    public String getDatetime() {
        return datetime;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getOxygen() {
        return oxygen;
    }

    public String getLocation() {
        return location;
    }

    // 파일 저장용 CSV 형태의 문자열로 변환 (예: 2123-08-21 13:45,25.5,60.3,21.2,루미노산 정상)
    public String toCsvString() {
        return datetime + "," + temperature + "," + humidity + "," + oxygen + "," + location;
    }
}
