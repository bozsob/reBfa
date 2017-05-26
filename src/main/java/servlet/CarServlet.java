package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.DatabaseTradingDao;
import model.Car;
import util.ConnectionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by trixi on 2017.05.26..
 */
@WebServlet("/car")
public class CarServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String name = request.getParameter("name");
        int year = Integer.parseInt(request.getParameter("year"));
        String color = request.getParameter("color");
        int tradingId = Integer.parseInt(request.getParameter("tradingId"));

        response.setContentType("application/json");
        ObjectMapper objectMapper = new ObjectMapper();
        DatabaseTradingDao dao = new DatabaseTradingDao(ConnectionUtil
            .getConnection(ConnectionUtil.DatabaseName.REBFA));

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        int tradingId = Integer.parseInt(request.getParameter("tradingId"));
        System.out.println("tradingId: " + tradingId);

        response.setContentType("application/json");
        ObjectMapper objectMapper = new ObjectMapper();
        DatabaseTradingDao dao = new DatabaseTradingDao(ConnectionUtil
            .getConnection(ConnectionUtil.DatabaseName.REBFA));

        try {
            List<Car> cars = dao.getCarsByTrading(tradingId);

            objectMapper.writeValue(response.getOutputStream(), cars);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
