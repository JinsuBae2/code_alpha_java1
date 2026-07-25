package course3.biodomefamily05;

public class BiodomeFamily05 {
    public static void main(String[] args) {
        // 1. 마법사 객체 생성
        Sorcerer sorcerer = new Sorcerer("아리엘");

        // 2. 3가지 유물 객체 생성
        AncientArtifact solarStone = new SolarStone("태양의 돌");
        AncientArtifact windAmulet = new WindAmulet("바람의 부적");
        AncientArtifact waterMirror = new WaterMirror("물의 거울");
        System.out.println();

        // 3. 마법사가 유물을 소유하도록 함
        sorcerer.addArtifact(solarStone);
        sorcerer.addArtifact(windAmulet);
        sorcerer.addArtifact(waterMirror);
        System.out.println();

        // 4. 마법사가 유물의 능력을 확인하고 사용해봄
        sorcerer.checkArtifactAbility(solarStone);

        sorcerer.useEnergyGeneration(waterMirror);
        System.out.println();

        // 5. 보너스 과제 시뮬레이션
        if (solarStone instanceof Chargeable) {
            Chargeable chargeableSolar = (Chargeable) solarStone;
            System.out.println(solarStone.getName() + "에 50만큼 에너지를 충전합니다.");
            chargeableSolar.charge(50);
        }
        if (waterMirror instanceof Chargeable) {
            Chargeable chargeableWater = (Chargeable) waterMirror;
            System.out.println(waterMirror.getName() + "에 30만큼 에너지를 충전합니다.");
            chargeableWater.charge(30);
        }
        if (solarStone instanceof Chargeable) {
            Chargeable chargeableSolar = (Chargeable) solarStone;
            System.out.println(solarStone.getName() + "에 10만큼 에너지를 충전합니다.");
            chargeableSolar.charge(10);
        }
        System.out.println();

        if (solarStone instanceof Chargeable) {
            Chargeable chargeableSolar = (Chargeable) solarStone;
            System.out.println(solarStone.getName() + "에 총 " + chargeableSolar.getChargeLevel() + "만큼의 에너지가 충전되었습니다.");
        }
        if (waterMirror instanceof Chargeable) {
            Chargeable chargeableWater = (Chargeable) waterMirror;
            System.out.println(waterMirror.getName() + "에 총 " + chargeableWater.getChargeLevel() + "만큼의 에너지가 충전되었습니다.");
        }
        System.out.println();

        Chargeable.showChargingTips();
    }
}
