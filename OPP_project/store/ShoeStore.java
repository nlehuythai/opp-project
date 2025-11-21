package store;

import model.Shoe;
import java.io.*;
import java.util.ArrayList;

public class ShoeStore {
    private ArrayList<Shoe> shoes = new ArrayList<>();
    private final String file = "data/shoes.txt";

    public ShoeStore() {
        load();
    }

    public void addShoe(Shoe s) {
        shoes.add(s);
        save();
    }

    public void removeShoe(Shoe s) {
        shoes.remove(s);
        save();
    }

    public ArrayList<Shoe> getShoes() {
        return shoes;
    }

    public void save() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(shoes);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void load() {
        try {
            File f = new File(file);
            if (!f.exists())
                return;
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            shoes = (ArrayList<Shoe>) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
