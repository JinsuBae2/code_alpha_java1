package course5.biodomeforever02;

public class BiodomeForever02 {
    public static void main(String[] args) {
        ResearchJournalManager manager = new ResearchJournalManager();

        // Command Line Arguments가 들어온 경우 해당 파라미터 파일들 처리
        if (args != null && args.length > 0) {
            for (String fileName : args) {
                System.out.println("\n=== [" + fileName + "] 처리 ===");
                ResearchJournal journal = manager.readJournal(fileName);
                if (journal != null) {
                    journal.printContent();
                }
            }
            return;
        }

        // 기본 과제 시뮬레이션 테스트
        String[] testFiles = {
            "213011210700_ShadeMist.txt",  // 1. 정상 파일
            "213102120900_AquaFern.txt",   // 2. 정상 파일
            "213012010200_Animal.txt",     // 3. 존재하지 않는 파일
            "213012_TwilightFern.txt",     // 4. 날짜 정보 오류 파일
            "213012251400_FireFly.txt"      // 5. 빈 파일 (보너스 과제)
        };

        for (String fileName : testFiles) {
            System.out.println("\n입력 파일: " + fileName);
            ResearchJournal journal = manager.readJournal(fileName);
            if (journal != null) {
                journal.printContent();
            }
        }
    }
}
