package course5.biodomeforever03;

import java.io.File;
import java.io.FileNotFoundException;

public class BiodomeForever03 {
    public static void main(String[] args) {
        String targetFolder = "src/course5/biodomeforever03";

        System.out.println("=== 1. 정상 연구일지 추출 시뮬레이션 ===");
        try {
            ResearchJournalExtractor extractor = new ResearchJournalExtractor(targetFolder);
            extractor.extractAndSave();
        } catch (FileNotFoundException e) {
            System.out.println("폴더를 찾을 수 없습니다: " + e.getMessage());
        } catch (NoDataAvailableException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        System.out.println("\n=== 2. 연구일지가 없는 폴더 예외 시뮬레이션 ===");
        String emptyFolderPath = "src/course5/biodomeforever03/empty_folder";
        File emptyFolder = new File(emptyFolderPath);
        if (!emptyFolder.exists()) {
            emptyFolder.mkdirs();
        }

        try {
            ResearchJournalExtractor emptyExtractor = new ResearchJournalExtractor(emptyFolderPath);
            emptyExtractor.extractAndSave();
        } catch (FileNotFoundException e) {
            System.out.println("폴더를 찾을 수 없습니다: " + e.getMessage());
        } catch (NoDataAvailableException e) {
            System.out.println("예외 포착 (NoDataAvailableException): " + e.getMessage());
        }

        System.out.println("\n=== 3. 잘못된 폴더 경로 예외 시뮬레이션 ===");
        String invalidFolderPath = "src/course5/biodomeforever03/non_existing_folder";
        try {
            ResearchJournalExtractor invalidExtractor = new ResearchJournalExtractor(invalidFolderPath);
            invalidExtractor.extractAndSave();
        } catch (FileNotFoundException e) {
            System.out.println("예외 포착 (FileNotFoundException): " + e.getMessage());
        } catch (NoDataAvailableException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
}
