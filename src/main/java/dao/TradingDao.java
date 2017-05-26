package dao;

import model.Car;
import model.Trading;

import java.sql.SQLException;
import java.util.List;

public interface TradingDao {

    List<Trading> getAllTrading() throws SQLException;
    List<Car> getAllCars() throws SQLException;
    List<Car> getCarsByTrading(int tradingId) throws SQLException;
    Car addNewCar(String brand, int year, String color, int tradingId) throws SQLException;
    List<Car> getCars(String search) throws SQLException;

}
