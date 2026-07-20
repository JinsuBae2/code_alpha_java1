package course3.biodomefamily02;

public class BiodomeFamily02 {

    public static void main(String[] args) {
        // 동식물 관리 저장소 생성
        LifeNest nest = new LifeNest();

        // 2가지 동물과 2가지 식물 객체 생성
        Organism penguin = new Organism("펭귄", "동물", "남극", "날지못하는 새", "15년");
        Organism koala = new Organism("코알라", "동물", "호주", "유칼립투스 잎을 먹는 동물", "10년");
        Organism cactus = new Organism("선인장", "식물", "사막", "물을 저장하는 식물", "50년");
        Organism peppermint = new Organism("페퍼민트", "식물", "정원", "향기로운 허브 식물", "3년");

        // 저장소에 동식물 추가
        nest.addOrganism(penguin);
        nest.addOrganism(koala);
        nest.addOrganism(cactus);
        nest.addOrganism(peppermint);

        // 전체 목록 출력
        nest.displayAllOrganisms();

        // 동식물 삭제
        nest.removeOrganism(penguin);
        nest.removeOrganism(cactus);

        // 서식지 변경
        koala.setHabitat("호주");
        peppermint.setHabitat("정원");

        // 변경 후 전체 목록 출력
        nest.displayAllOrganisms();

        // 특징 및 수명 변경
        koala.setCharacteristic("유칼립투스 잎을 먹는 동물");
        peppermint.setLifeSpan("3년");

        // 최종 전체 목록 출력
        nest.displayAllOrganisms();
    }
}
