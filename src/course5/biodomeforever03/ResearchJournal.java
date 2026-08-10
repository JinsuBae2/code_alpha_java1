package course5.biodomeforever03;

public class ResearchJournal {
    private String fileName;
    private String content;

    public ResearchJournal(String fileName, String content) {
        this.fileName = fileName;
        this.content = content;
    }

    public String getFileName() {
        return fileName;
    }

    public String getContent() {
        return content;
    }

    public void printContent() {
        System.out.println(content);
    }

    // 정규식(regex) 없이 Name. 파싱
    public String extractPlantName() {
        if (content == null) return null;
        int index = content.indexOf("Name. ");
        if (index == -1) return null;
        int start = index + "Name. ".length();
        int end = content.indexOf("\n", start);
        if (end == -1) {
            end = content.indexOf("\r", start);
        }
        if (end == -1) {
            end = content.length();
        }
        String name = content.substring(start, end).trim();
        return name.isEmpty() ? null : name;
    }

    // 정규식(regex) 없이 ADR. 파싱
    public String extractPlantAddress() {
        if (content == null) return null;
        int index = content.indexOf("ADR. ");
        if (index == -1) return null;
        int start = index + "ADR. ".length();
        int end = content.indexOf("\n", start);
        if (end == -1) {
            end = content.indexOf("\r", start);
        }
        if (end == -1) {
            end = content.length();
        }
        String address = content.substring(start, end).trim();
        return address.isEmpty() ? null : address;
    }
}
