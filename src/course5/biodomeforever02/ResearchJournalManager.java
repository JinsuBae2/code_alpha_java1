package course5.biodomeforever02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ResearchJournalManager {

    public ResearchJournal readJournal(String fileName) {
        FileInputStream fis = null;

        try {
            // 디스크 파일 경로 결정
            String path;
            if (fileName.startsWith("5-2-")) {
                path = "src/course5/biodomeforever02/" + fileName;
            } else {
                path = "src/course5/biodomeforever02/5-2-" + fileName;
            }

            File file = new File(path);
            if (!file.exists()) {
                throw new FileNotFoundException(fileName + " (No such file or directory)");
            }

            fis = new FileInputStream(file);
            byte[] bytes = fis.readAllBytes();
            String content = new String(bytes, StandardCharsets.UTF_8);

            // 보너스 과제: 빈 파일 체크
            if (content.trim().isEmpty()) {
                throw new EmptyFileException("빈 파일입니다.");
            }

            return new ResearchJournal(fileName, content);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("존재하지 않는 파일입니다. 파일 이름을 다시 확인해주세요.");
            return null;
        } catch (EmptyFileException e) {
            e.printStackTrace();
            System.out.println("파일에 아무런 내용이 존재하지 않습니다.");
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("파일을 읽는 도중 오류가 발생했습니다.");
            return null;
        } catch (SecurityException e) {
            e.printStackTrace();
            System.out.println("보안이나 정책 또는 권한 문제로 파일에 엑세스할 수 없습니다.");
            return null;
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
