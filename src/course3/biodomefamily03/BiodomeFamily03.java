package course3.biodomefamily03;

public class BiodomeFamily03 {

    public static void main(String[] args) {
        // 동식물 저장소 생성
        LifeNest nest = new LifeNest();

        // 동물 2개, 식물 2개 객체 생성
        Animal penguin = new Animal("펭귄", "동물", "남극", "육식", "물고기");
        Animal koala = new Animal("코알라", "동물", "호주", "초식", "유칼립투스");
        Plant cactus = new Plant("선인장", "식물", "사막", "11월", "열매 있음");
        Plant peppermint = new Plant("페퍼민트", "식물", "정원", "7월", "열매 없음");

        // 저장소에 추가
        nest.addOrganism(penguin);
        nest.addOrganism(koala);
        nest.addOrganism(cactus);
        nest.addOrganism(peppermint);

        // 전체 목록 출력
        nest.displayAll();

        // 1가지 동물과 1가지 식물 삭제
        nest.removeOrganism(koala);
        nest.removeOrganism(cactus);

        // 삭제 후 전체 목록 출력
        nest.displayAll();

        // 보너스 과제 (Mammal, Bird 서브클래스 객체 테스트)
        Mammal lion = new Mammal("사자", "동물", "초원", "육식", "고기", true);
        Bird eagle = new Bird("독수리", "동물", "산악", "육식", "소형동물", 2.1);

        nest.addOrganism(lion);
        nest.addOrganism(eagle);

        // 서브클래스 고유 메서드 호출
        lion.giveBirth();
        eagle.fly();
    }
}
