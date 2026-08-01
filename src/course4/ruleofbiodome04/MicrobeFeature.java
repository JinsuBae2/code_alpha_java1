package course4.ruleofbiodome04;

public class MicrobeFeature implements Feature{
    private String livingEnvironment;
    private boolean isPathogenic;
    private String metabolismType;

    public MicrobeFeature(String livingEnvironment, boolean isPathogenic, String metabolismType) {
        this.livingEnvironment = livingEnvironment;
        this.isPathogenic = isPathogenic;
        this.metabolismType = metabolismType;
    }

    public String getLivingEnvironment() {
        return livingEnvironment;
    }

    public void setLivingEnvironment(String livingEnvironment) {
        this.livingEnvironment = livingEnvironment;
    }

    public boolean getPathogenic() {
        return isPathogenic;
    }

    public void setPathogenic(boolean pathogenic) {
        this.isPathogenic = pathogenic;
    }

    public String getMetabolismType() {
        return metabolismType;
    }

    public void setMetabolismType(String metabolismType) {
        this.metabolismType = metabolismType;
    }

    @Override
    public String toString() {
        String pathogenic = isPathogenic ? "병원성 있음" : "병원성 없음";
        return livingEnvironment + ", " + pathogenic + ", " + metabolismType;
    }
}
