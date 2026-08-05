package course5.biodomeforever01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ResearchJournalManager {
    public ResearchJournal readJournal(String fileName) {
        FileInputStream fis = null;
        int underscoreIndex = fileName.indexOf("_");
        String createdAt = fileName.substring(0, underscoreIndex);

        try {
            String path = "src/course5/biodomeforever01/5-1-" + fileName;
            fis = new FileInputStream(path);
            byte[] bytes = fis.readAllBytes();
            String content = new String(bytes, StandardCharsets.UTF_8);
            return new ResearchJournal(fileName, content, createdAt);
        } catch (FileNotFoundException e) {
            System.out.println("존재하지 않는 파일입니다. 파일 이름을 다시 확인해주세요.");
            return null;
        } catch (IOException e) {
            System.out.println("파일을 읽는 중 오류가 발생했습니다.");
            return null;
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    System.out.println("파일을 닫는 중 오류가 발생했습니다.");
                }
            }
        }
    }

    public void searchByCreatedAt(String createdAt) {
        File directory = new File("src/course5/biodomeforever01");
        File[] files = directory.listFiles();
        boolean found = false;

        if (files == null) {
            System.out.println("연구일지 폴더를 확인할 수 없습니다.");
            return;
        }

        String targetPrefix = "5-1-" + createdAt + "_";

        for (File file : files) {
            String actualFileName = file.getName();

            if (file.isFile()
                    && actualFileName.startsWith(targetPrefix)
                    && actualFileName.endsWith(".txt")) {

                found = true;

                String fileName = actualFileName.substring("5-1-".length());

                ResearchJournal journal = readJournal(fileName);

                if (journal != null) {
                    journal.printContent();
                }
            }
        }

        if (!found) {
            System.out.println("해당 작성일자의 연구일지가 없습니다.");
        }
    }
}
