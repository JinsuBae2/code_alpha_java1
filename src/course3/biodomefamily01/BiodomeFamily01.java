package course3.biodomefamily01;

public class BiodomeFamily01 {

    public static void main(String[] args) {
        // 동식물 관리 저장소 생성
        LifeNest nest = new LifeNest();

        // 2가지 동물 객체와 2가지 식물 객체 생성
        Organism penguin = new Organism("펭귄", "동물", "남극");
        Organism koala = new Organism("코알라", "동물", "호주");
        Organism cactus = new Organism("선인장", "식물", "사막");
        Organism peppermint = new Organism("페퍼민트", "식물", "정원");

        // 동식물 저장소에 추가
        nest.addOrganism(penguin);
        nest.addOrganism(koala);
        nest.addOrganism(cactus);
        nest.addOrganism(peppermint);

        // 전체 목록 출력
        nest.displayAllOrganisms();

        // 1가지 동물과 1가지 식물 삭제
        nest.removeOrganism(koala);
        nest.removeOrganism(cactus);

        // 동물의 서식지 변경
        penguin.setHabitat("해변");

        // 변경 후 전체 목록 출력
        nest.displayAllOrganisms();

        // 이름으로 검색 테스트
        nest.searchOrganismByName("고양이");
    }
}
