package course5.biodomeforever01;

public class ResearchJournal {
    private String fileName;
    private String content;
    private String createdAt;

    public ResearchJournal(String fileName, String content, String createdAt) {
        this.fileName = fileName;
        this.content = content;
        this.createdAt = createdAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void printContent() {
        System.out.println(content);
    }
}
