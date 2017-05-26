package model;

/**
 * Created by trixi on 2017.05.26..
 */
public class Car {

    private int id;
    private String brand;
    private int year;
    private String color;
    private int tradingId;

    public Car(int id, String brand, int year, String color, int tradingId) {
        this.id = id;
        this.brand = brand;
        this.year = year;
        this.color = color;
        this.tradingId = tradingId;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public int getTradingId() {
        return tradingId;
    }
}
