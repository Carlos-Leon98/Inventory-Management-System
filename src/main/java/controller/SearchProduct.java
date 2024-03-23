package controller;

import entity.Product;
import persistence.EntitiesDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(
        urlPatterns = {"/searchProduct"}
)
public class SearchProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchTerm = req.getParameter("searchTerm");
        EntitiesDAO<Product> dao = new EntitiesDAO<>(Product.class);
        List<Product> productsList;

        if (searchTerm != null && !searchTerm.isEmpty()) {
            int productId = Integer.parseInt(searchTerm);
            Product product = dao.getById(productId);
            productsList = product != null ? List.of(product) : List.of();

        } else {
            productsList = dao.getAll();
        }

        req.setAttribute("products", productsList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/inventory.jsp");
        dispatcher.forward(req, resp);
    }
}
