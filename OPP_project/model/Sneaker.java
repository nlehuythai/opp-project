package OPP_project.model;

public class Sneaker extends Shoe {

    private boolean hasAirCushion;

    public Sneaker() {
    }

    public Sneaker(String shoeId, String name, String brand, int size, double price, int quantity, String category,
            boolean hasAirCushion) {
        super(shoeId, name, brand, size, price, quantity, category);
        this.hasAirCushion = hasAirCushion;
    }

    @Override
    public String getType() {
        return "Sneaker";
    }

    public boolean isHasAirCushion() {
        return hasAirCushion;
    }

    public void setHasAirCushion(boolean hasAirCushion) {
        this.hasAirCushion = hasAirCushion;
    }
}
