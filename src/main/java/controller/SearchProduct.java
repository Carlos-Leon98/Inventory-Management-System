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
        EntitiesDAO<Product> dao = new EntitiesDAO<>(Product.class);
        List<Product> productsList = dao.getAll();
        req.setAttribute("products", productsList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/inventory.jsp");
        dispatcher.forward(req, resp);
    }
}
