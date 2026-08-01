package course4.ruleofbiodome04;

public class BiologicalEntity<T> {
    private String name;
    private String classification;
    private T feature;

    public BiologicalEntity(String name, String classification, T feature) {
        this.name = name;
        this.classification = classification;
        this.feature = feature;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public T getFeature() {
        return feature;
    }

    public void setFeature(T feature) {
        this.feature = feature;
    }

    @Override
    public String toString() {
        return getName() + ", " + getClassification() + ", " + getFeature();
    }
}
