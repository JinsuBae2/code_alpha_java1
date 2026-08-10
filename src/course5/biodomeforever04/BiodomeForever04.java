package course5.biodomeforever04;

import java.util.Scanner;

public class BiodomeForever04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EnvironmentManager manager = new EnvironmentManager();

        System.out.println("환경 정보 관리 시스템에 오신 것을 환영합니다.");

        while (true) {
            System.out.println("\n새로운 환경 데이터 입력");
            System.out.println("모든 환경 데이터 조회");
            System.out.println("날짜별 산소 수치만 조회");
            System.out.println("프로그램 종료");
            System.out.print("선택: ");

            String input = scanner.nextLine().trim();

            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("잘못된 선택입니다. 1~4 사이의 숫자를 입력해주세요.");
                continue;
            }

            if (choice == 1) {
                // 1. 온도 입력
                System.out.print("\n온도를 입력하세요: ");
                String tempStr = scanner.nextLine().trim();
                double temperature;
                try {
                    temperature = Double.parseDouble(tempStr);
                } catch (NumberFormatException e) {
                    System.out.println("잘못된 값입니다. 온도는 숫자로 입력해주세요.");
                    continue;
                }

                // 2. 습도 입력
                System.out.print("습도를 입력하세요: ");
                String humStr = scanner.nextLine().trim();
                double humidity;
                try {
                    humidity = Double.parseDouble(humStr);
                } catch (NumberFormatException e) {
                    System.out.println("잘못된 값입니다. 습도는 숫자로 입력해주세요.");
                    continue;
                }

                // 3. 산소 농도 입력
                System.out.print("산소 농도를 입력하세요: ");
                String oxyStr = scanner.nextLine().trim();
                double oxygen;
                try {
                    oxygen = Double.parseDouble(oxyStr);
                } catch (NumberFormatException e) {
                    System.out.println("잘못된 값입니다. 산소 농도는 숫자로 입력해주세요.");
                    continue;
                }

                // 4. 측정 장소 입력
                System.out.print("측정 장소를 입력하세요: ");
                String location = scanner.nextLine().trim();

                EnvironmentData data = new EnvironmentData(temperature, humidity, oxygen, location);
                manager.saveData(data);

            } else if (choice == 2) {
                manager.readAllData();
            } else if (choice == 3) {
                manager.readOxygenData();
            } else if (choice == 4) {
                System.out.println("\n프로그램을 종료합니다. 감사합니다.");
                break;
            } else {
                System.out.println("잘못된 선택입니다. 1~4 사이의 숫자를 입력해주세요.");
            }
        }

        scanner.close();
    }
}
