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
@WebServlet("/search")
public class SearchCarServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String searchText = request.getParameter("search");

        String search = "%" + searchText + "%";

        System.out.println("search: " + search);

        response.setContentType("application/json");
        ObjectMapper objectMapper = new ObjectMapper();
        DatabaseTradingDao dao = new DatabaseTradingDao(ConnectionUtil
            .getConnection(ConnectionUtil.DatabaseName.REBFA));

        try {
            List<Car> cars = dao.getCars(search);

            objectMapper.writeValue(response.getOutputStream(), cars);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
