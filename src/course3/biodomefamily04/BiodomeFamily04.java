package course3.biodomefamily04;

public class BiodomeFamily04 {

    public static void main(String[] args) {
        // 3가지 에너지 원천 객체 생성
        GeothermalEnergy geo = new GeothermalEnergy();
        SolarEnergy solar = new SolarEnergy();
        WindEnergy wind = new WindEnergy();

        // 에너지 관리 저장소 생성 및 원천 등록
        EnergyManager energyManager = new EnergyManager();
        energyManager.addEnergySource(geo);
        energyManager.addEnergySource(solar);
        energyManager.addEnergySource(wind);

        // 에너지 생산 수행
        geo.produceEnergy(5);
        wind.produceEnergy(12);
        solar.produceEnergy(4);

        // 에너지 소모 (각 30씩)
        geo.useEnergy(30);
        wind.useEnergy(30);
        solar.useEnergy(30);

        // 남은 총 에너지량 합산 출력
        energyManager.getTotalEnergy();

        // 보너스 과제 (에너지 부족 예외 테스트)
        geo.useEnergy(1000);
    }
}
