package course3.biodomefamily09;

import java.time.LocalDateTime;

public class Sandwich extends Menu {

    private String ingredient;
    private LocalDateTime expirationDate;

    public Sandwich(String name, int price, String ingredient, LocalDateTime expirationDate) {
        super(name, price);
        this.ingredient = ingredient;
        this.expirationDate = expirationDate;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public boolean isExpired(LocalDateTime orderTime) {
        return orderTime.isAfter(expirationDate);
    }

    @Override
    public String toString() {
        return getName() + ": " + String.format("%,d", getPrice()) + "원 (재료: " + ingredient + ", 만료일: " + expirationDate.toLocalDate() + ")";
    }
}
