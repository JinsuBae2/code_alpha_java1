package course5.biodomeforever03;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResearchJournalExtractor {
    private String folderPath;
    private List<ResearchJournal> journals = new ArrayList<>();

    public ResearchJournalExtractor(String folderPath) throws FileNotFoundException, NoDataAvailableException {
        this.folderPath = folderPath;

        File folder = new File(folderPath);
        if (!folder.exists() || !folder.isDirectory()) {
            throw new FileNotFoundException("지정된 폴더를 찾을 수 없습니다: " + folderPath);
        }

        // 결과 요약 파일(_Lumino_ADR.txt)을 제외한 .txt 파일만 필터링
        File[] files = folder.listFiles((dir, name) -> name.endsWith(".txt") && !name.contains("_Lumino_ADR"));

        if (files == null || files.length == 0) {
            System.out.println("분석할 파일이 없습니다");
            throw new NoDataAvailableException("분석할 파일이 없습니다");
        }

        // try-with-resources를 활용한 파일 읽기
        for (File file : files) {
            try (FileInputStream fis = new FileInputStream(file)) {
                byte[] bytes = fis.readAllBytes();
                String content = new String(bytes, StandardCharsets.UTF_8);
                journals.add(new ResearchJournal(file.getName(), content));
            } catch (IOException e) {
                System.out.println("파일을 읽는 도중 에러가 발생했습니다: " + file.getName());
                e.printStackTrace();
            }
        }

        if (journals.isEmpty()) {
            System.out.println("분석할 파일이 없습니다");
            throw new NoDataAvailableException("분석할 파일이 없습니다");
        }
    }

    public void extractAndSave() {
        List<String> summaryLines = new ArrayList<>();

        for (ResearchJournal journal : journals) {
            String name = journal.extractPlantName();
            String address = journal.extractPlantAddress();

            // 식물명 또는 주소 정보 누락 체크
            if (name == null || address == null) {
                System.out.println(journal.getFileName() + ": 식물명 또는 주소 정보가 누락되었습니다.");
                continue;
            }

            String line = name + " - " + address;

            // 보너스 과제: 중복 저장 방지
            if (!summaryLines.contains(line)) {
                summaryLines.add(line);
            }
        }

        if (summaryLines.isEmpty()) {
            System.out.println("추출된 식물 정보가 없습니다.");
            return;
        }

        // 저장할 파일명 생성 (오늘날짜시간_Lumino_ADR.txt)
        String timestamp = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
        String fileName = timestamp + "_Lumino_ADR.txt";
        File outputFile = new File(folderPath, fileName);

        // 동일한 파일이 존재하는 경우 초(second) 추가하여 새로운 파일명 생성
        if (outputFile.exists()) {
            timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            fileName = timestamp + "_Lumino_ADR.txt";
            outputFile = new File(folderPath, fileName);
        }

        // try-with-resources & FileOutputStream을 이용한 파일 작성 및 저장
        try (FileOutputStream fos = new FileOutputStream(outputFile)) {
            StringBuilder sb = new StringBuilder();
            for (String line : summaryLines) {
                sb.append(line).append("\n");
            }

            fos.write(sb.toString().getBytes(StandardCharsets.UTF_8));

            System.out.println("\n[파일 저장 완료]");
            System.out.println("생성된 파일 경로: " + outputFile.getPath());
            System.out.println("--- 저장된 내용 ---");
            System.out.print(sb.toString());

        } catch (IOException e) {
            System.out.println("파일 저장 도중 에러가 발생했습니다.");
            e.printStackTrace();
        }
    }
}
