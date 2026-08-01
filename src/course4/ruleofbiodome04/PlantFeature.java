package course4.ruleofbiodome04;

public class PlantFeature implements Feature{
    private String flowerColor;
    private boolean hasFruit;
    private String floweringSeason;

    public PlantFeature(String flowerColor, boolean hasFruit, String floweringSeason) {
        this.flowerColor = flowerColor;
        this.hasFruit = hasFruit;
        this.floweringSeason = floweringSeason;
    }

    public String getFlowerColor() {
        return flowerColor;
    }

    public void setFlowerColor(String flowerColor) {
        this.flowerColor = flowerColor;
    }

    public boolean isHasFruit() {
        return hasFruit;
    }

    public void setHasFruit(boolean hasFruit) {
        this.hasFruit = hasFruit;
    }

    public String getFloweringSeason() {
        return floweringSeason;
    }

    public void setFloweringSeason(String floweringSeason) {
        this.floweringSeason = floweringSeason;
    }

    @Override
    public String toString() {
        String fruit = hasFruit ? "열매 있음" : "열매 없음";
        return flowerColor + ", " + fruit + ", " + floweringSeason;
    }
}
