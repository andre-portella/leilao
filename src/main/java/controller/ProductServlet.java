package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;
import model.ProductService;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    private ProductService productService;  // Definir variável de instância

    public void init() {
        productService = new ProductService();  // Inicializar o serviço
    }
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<Product> products = new ArrayList<>();
        
        try {
            products = productService.listProducts();
        } catch (Exception e) {
            // 
        }

        request.setAttribute("products", products);
        RequestDispatcher dispatcher=request.getRequestDispatcher("./products.jsp");
        dispatcher.forward(request, response);
	}

}