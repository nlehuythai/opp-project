package OPP_project.model;

public class Boot extends Shoe {

    private int bootHeight; // chiều cao cổ giày

    public Boot() {
    }

    public Boot(String shoeId, String name, String brand, int size, double price, int quantity, String category,
            int bootHeight) {
        super(shoeId, name, brand, size, price, quantity, category);
        this.bootHeight = bootHeight;
    }

    @Override
    public String getType() {
        return "Boot";
    }

    public int getBootHeight() {
        return bootHeight;
    }

    public void setBootHeight(int bootHeight) {
        this.bootHeight = bootHeight;
    }
}
