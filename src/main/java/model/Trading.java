package model;

/**
 * Created by trixi on 2017.05.26..
 */
public class Trading {

    private int id;
    private String name;
    private String city;
    private int carCapacity;

    public Trading(int id, String name, String city, int carCapacity) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.carCapacity = carCapacity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public int getCarCapacity() {
        return carCapacity;
    }
}
