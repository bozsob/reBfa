package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.DatabaseTradingDao;
import dao.TradingDao;
import model.Car;
import model.Trading;
import util.ConnectionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/trading")
public class TradingServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String filter = request.getParameter("filter");
        System.out.println("filter: " + filter);

        response.setContentType("application/json");
        ObjectMapper objectMapper = new ObjectMapper();
        DatabaseTradingDao dao = new DatabaseTradingDao(ConnectionUtil
            .getConnection(ConnectionUtil.DatabaseName.REBFA));

        if(filter.equals("trading")) {
            try {
                List<Trading> tradings = dao.getAllTrading();

                objectMapper.writeValue(response.getOutputStream(), tradings);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(filter.equals("car")) {
            try {
                List<Car> cars = dao.getAllCars();

                objectMapper.writeValue(response.getOutputStream(), cars);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
