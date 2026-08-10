package course5.biodomeforever04;

import java.io.*;

public class EnvironmentManager {
    private String filePath = "environment_data.txt";

    // 1. 데이터 저장 기능 (FileWriter, BufferedWriter, try-with-resources 사용)
    public void saveData(EnvironmentData data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(data.toCsvString());
            writer.newLine();
            System.out.println("\n데이터가 environment_data.txt에 저장되었습니다.");
        } catch (IOException e) {
            System.out.println("파일 저장 중 오류가 발생했습니다.");
            e.printStackTrace();
        }
    }

    // 2. 모든 환경 데이터 조회 기능 (FileReader, BufferedReader 사용)
    public void readAllData() {
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("\n저장된 데이터가 없습니다.");
            return;
        }

        System.out.println();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("파일을 읽는 도중 오류가 발생했습니다.");
            e.printStackTrace();
        }
    }

    // 3. (보너스 과제) 날짜별 산소 수치만 조회 기능 (날짜 - 산소농도 - 위치)
    public void readOxygenData() {
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("\n저장된 데이터가 없습니다.");
            return;
        }

        System.out.println();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 5) {
                    String datetime = parts[0];
                    String oxygen = parts[3];
                    String location = parts[4];
                    System.out.println(datetime + " - " + oxygen + " - " + location);
                }
            }
        } catch (IOException e) {
            System.out.println("파일을 읽는 도중 오류가 발생했습니다.");
            e.printStackTrace();
        }
    }
}
