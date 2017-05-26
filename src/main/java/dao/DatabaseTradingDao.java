package dao;

import model.Car;
import model.Trading;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseTradingDao implements TradingDao {

    private final Connection conn;
    private String query;

    public DatabaseTradingDao(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Trading> getAllTrading() throws SQLException {

        List<Trading> tradings = new ArrayList<>();
        query = "SELECT * FROM `trading`";
        PreparedStatement ps = conn.prepareStatement(query);

        ResultSet rs = ps.executeQuery();

        while(rs.next()) {
            tradings.add(new Trading(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("city"),
                rs.getInt("carCapacity")
            ));
        }
        return tradings;
    }

    @Override
    public List<Car> getAllCars() throws SQLException {

        List<Car> cars = new ArrayList<>();
        query = "SELECT * FROM `car`";
        PreparedStatement ps = conn.prepareStatement(query);

        ResultSet rs = ps.executeQuery();

        while(rs.next()) {
            cars.add(new Car(
                rs.getInt("id"),
                rs.getString("brand"),
                rs.getInt("year"),
                rs.getString("color"),
                rs.getInt("tradingId")
            ));
        }
        return cars;
    }

    @Override
    public List<Car> getCarsByTrading(int tradingId) throws SQLException {

        List<Car> cars = new ArrayList<>();

        query = "SELECT * FROM car WHERE tradingId=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, tradingId);
        ResultSet rs = ps.executeQuery();

        while(rs.next()) {
            cars.add(new Car(
                rs.getInt("id"),
                rs.getString("brand"),
                rs.getInt("year"),
                rs.getString("color"),
                rs.getInt("tradingId")
            ));
        }
        return cars;
    }

    @Override
    public Car addNewCar(String brand, int year, String color, int tradingId) throws SQLException {

        Car car = null;
        query = "INSERT INTO `car` VALUES(NULL,?,?,?,?);";
        PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, brand);
        ps.setInt(2, year);
        ps.setString(3, color);
        ps.setInt(4, tradingId);
        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();

        if(rs.next()) {
            car = new Car(rs.getInt(1),
                brand,
                year,
                color,
                tradingId);
        }
        return car;
    }

    @Override
    public List<Car> getCars(String search) throws SQLException {

        List<Car> cars = new ArrayList<>();

        query = "SELECT * FROM `car` WHERE `brand` LIKE ?;";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, search);
        ResultSet rs = ps.executeQuery();

        while(rs.next()) {
            cars.add(new Car(
                rs.getInt("id"),
                rs.getString("brand"),
                rs.getInt("year"),
                rs.getString("color"),
                rs.getInt("tradingId")
            ));
        }
        return cars;
    }
}
