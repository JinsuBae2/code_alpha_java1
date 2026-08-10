package course5.biodomeforever02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ResearchJournal {
    private String fileName;
    private String content;

    public ResearchJournal(String fileName, String content) {
        this.fileName = fileName;
        this.content = content;
    }

    public void printContent() {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyyMMddHHmm");
        inputFormat.setLenient(false);
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        try {
            String cleanName = fileName;
            if (cleanName.startsWith("5-2-")) {
                cleanName = cleanName.substring(4);
            }

            int underscoreIndex = cleanName.indexOf("_");
            String dateStr = (underscoreIndex != -1) ? cleanName.substring(0, underscoreIndex) : cleanName;

            if (dateStr.length() != 12 || !dateStr.matches("\\d{12}")) {
                throw new ParseException("Unparseable date: \"" + dateStr + "\"", 0);
            }

            Date date = inputFormat.parse(dateStr);
            String formattedDate = outputFormat.format(date);

            System.out.println(formattedDate + " " + content);

        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("파일 이름에서 날짜를 확인할 수 없습니다.");
        }
    }
}
