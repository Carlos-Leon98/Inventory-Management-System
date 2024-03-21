package controller;

//import edu.matc.persistence.UserData;

import entity.Product;
import persistence.EntitiesDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/searchProduct"}
)
public class SearchProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        EntitiesDAO<Product> entitiesDAO = new EntitiesDAO<>(Product.class);
        int id = Integer.parseInt(req.getParameter("searchTerm"));
        if (req.getParameter("submit").equals("search")) {
            req.setAttribute("products", entitiesDAO.getById(id));
        } else {
            req.setAttribute("products", entitiesDAO.getAll());
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        dispatcher.forward(req, resp);
    }
}
