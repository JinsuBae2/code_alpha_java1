package course4.ruleofbiodome03;

public class RuleOfBiodome03 {
    public static void main(String[] args) {
        // 1. 일반 기기 및 스마트 기기 생성 시뮬레이션
        GeneralDevice doorOpener = new GeneralDevice("도어 오프너");
        SmartDevice autoMirror = new SmartDevice("자동 거울", "기분을 인식해 옷을 추천하는 기능");
        System.out.println();

        // 2. 전자기기 컨트롤러 생성 및 기기 연결 시뮬레이션
        Controller controller = new Controller();
        controller.connectDevice(doorOpener);
        controller.connectDevice(autoMirror);
        System.out.println();

        // 3. 컨트롤러를 이용해 스마트 전자기기 전원을 켜고 고급 기능 활성화
        autoMirror.powerOn();
        controller.activateSmartFeature(autoMirror);
        System.out.println();

        // 4. 컨트롤러를 이용해 일반 전자기기 전원 켜기
        doorOpener.powerOn();
        System.out.println();

        // 5. 컨트롤러를 이용해 모든 전자기기 전원 한번에 끄기
        controller.powerOffAll();
        System.out.println();

        // === [예외 상황 처리 시뮬레이션 테스트] ===
        System.out.println("=== [예외 상황 처리 시뮬레이션 테스트] ===");

        // 예외 1: 꺼져있는 스마트 기기의 고급 기능을 활성화 시도하는 경우
        System.out.println("--- 예외 1: 꺼져있는 스마트 기기의 고급 기능 활성화 시도 ---");
        SmartDevice turnedOffMirror = new SmartDevice("스마트 거울2", "조명 자동 조절 기능");
        controller.connectDevice(turnedOffMirror);
        controller.activateSmartFeature(turnedOffMirror); // 전원이 꺼져있으므로 예외 안내 메시지 출력
        System.out.println();

        // 예외 2: 스마트 기기의 고급 기능이 입력되지 않은 경우 (null 또는 empty)
        System.out.println("--- 예외 2: 고급 기능이 설정되지 않은 스마트 기기 기능 활성화 시도 ---");
        SmartDevice emptyFeatureDevice = new SmartDevice("무기능 거울", null);
        controller.connectDevice(emptyFeatureDevice);
        emptyFeatureDevice.powerOn();
        controller.activateSmartFeature(emptyFeatureDevice); // 기능 내용이 없으므로 예외 안내 메시지 출력
        System.out.println();

        // === [보너스 과제: 에너지 절약 모드 시뮬레이션 테스트] ===
        System.out.println("=== [보너스 과제: 에너지 절약 모드 시뮬레이션 테스트] ===");

        // 1. 단일 기기 절약 모드 토글 테스트
        System.out.println("--- 단일 기기(도어 오프너) 절약 모드 제어 ---");
        controller.energySavingOnOff(doorOpener);
        controller.energySavingOnOff(doorOpener);
        System.out.println();

        // 2. 혼합 상태 설정: 2개 기기(도어 오프너, 자동 거울)는 ON, 2개 기기(스마트 거울2, 무기능 거울)는 OFF
        System.out.println("--- 혼합 상태 설정 (2개 기기 절약모드 ON, 2개 기기 OFF) ---");
        controller.energySavingOnOff(doorOpener);  // ON으로 설정
        controller.energySavingOnOff(autoMirror);   // ON으로 설정
        System.out.println();

        // 3. 혼합 상태에서 전체 기기 절약 모드 일괄 활성화(true) 실행
        System.out.println("--- 혼합 상태에서 전체 기기 일괄 활성화(true) 실행 ---");
        controller.energySavingAll(true);
        System.out.println();

        // 4. 이미 모두 활성화된 상태에서 중복 활성화(true) 시도
        System.out.println("--- 이미 모두 활성화된 상태에서 중복 활성화(true) 시도 ---");
        controller.energySavingAll(true);
        System.out.println();

        // 5. 전체 기기 일괄 비활성화(false) 실행
        System.out.println("--- 전체 기기 일괄 비활성화(false) 실행 ---");
        controller.energySavingAll(false);
    }
}
