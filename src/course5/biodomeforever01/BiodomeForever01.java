package course5.biodomeforever01;

public class BiodomeForever01 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("파일 이름을 입력해주세요.");
            return;
        }

        ResearchJournalManager manager = new ResearchJournalManager();

        // --date 옵션이 입력되면 두 번째 인자를 작성일시로 사용해 검색한다.
        if ("--date".equals(args[0])) {
            if (args.length < 2) {
                System.out.println("검색할 작성일시를 입력해주세요.");
                return;
            }

            manager.searchByCreatedAt(args[1]);
            return;
        }

        // 일반 실행에서는 첫 번째 인자를 연구일지 파일명으로 사용한다.
        ResearchJournal journal = manager.readJournal(args[0]);
        if (journal != null) {
            journal.printContent();
        }
    }
}
