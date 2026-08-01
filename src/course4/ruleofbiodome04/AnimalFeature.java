package course4.ruleofbiodome04;

public class AnimalFeature implements Feature {
    private String behavior;
    private String reproductionMethod;
    private String predator;
    private String prey;
    private String averageLifespan;

    public AnimalFeature(String behavior, String reproductionMethod, String predator, String prey, String averageLifespan) {
        this.behavior = behavior;
        this.reproductionMethod = reproductionMethod;
        this.predator = predator;
        this.prey = prey;
        this.averageLifespan = averageLifespan;
    }

    public String getBehavior() {
        return behavior;
    }

    public void setBehavior(String behavior) {
        this.behavior = behavior;
    }

    public String getReproductionMethod() {
        return reproductionMethod;
    }

    public void setReproductionMethod(String reproductionMethod) {
        this.reproductionMethod = reproductionMethod;
    }

    public String getPredator() {
        return predator;
    }

    public void setPredator(String predator) {
        this.predator = predator;
    }

    public String getPrey() {
        return prey;
    }

    public void setPrey(String prey) {
        this.prey = prey;
    }

    public String getAverageLifespan() {
        return averageLifespan;
    }

    public void setAverageLifespan(String averageLifespan) {
        this.averageLifespan = averageLifespan;
    }

    @Override
    public String toString() {
        return behavior + ", " + reproductionMethod + ", " + predator + ", " + prey + ", " + averageLifespan;
    }
}
