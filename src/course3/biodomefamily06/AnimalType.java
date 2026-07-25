package course3.biodomefamily06;

public enum AnimalType {
    MONKEY("원숭이"),
    TIGER("호랑이"),
    DEER("사슴"),
    ELEPHANT("코끼리"),
    RHINO("코뿔소");

    private final String koreanName;

    AnimalType(String koreanName) {
        this.koreanName = koreanName;
    }

    public String getKoreanName() {
        return koreanName;
    }
}
