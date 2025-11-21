package OPP_project.model;

public class RunningShoe extends Shoe {

    private double weight; // trọng lượng giày

    public RunningShoe() {
    }

    public RunningShoe(String shoeId, String name, String brand, int size, double price, int quantity,
            String category, double weight) {
        super(shoeId, name, brand, size, price, quantity, category);
        this.weight = weight;
    }

    @Override
    public String getType() {
        return "Running Shoe";
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
