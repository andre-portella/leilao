package controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Auction;
import model.AuctionService;
import model.Product;
import model.ProductService;
import model.User;

@WebServlet("/auction")
public class AuctionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AuctionService auctionService;
    private ProductService productService;

    public void init() {
        auctionService = new AuctionService();
        productService = new ProductService();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {

        int productId = Integer.parseInt(request.getParameter("product_id"));
        List<Auction> bids = auctionService.getBidsByProductId(productId);

        request.setAttribute("bids", bids);
      
        Product product = productService.getProductById(productId);
        request.setAttribute("product", product);

        // Verifica se é uma requisição AJAX
        if ("true".equals(request.getParameter("isAjax"))) {
            request.getRequestDispatcher("/bids-table.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("auction.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        int productId = Integer.parseInt(request.getParameter("product_id"));
        BigDecimal bidValue = new BigDecimal(request.getParameter("bid_value"));

        // Salva o lance no banco de dados
        Auction bid = new Auction(0, productId, user.getUserId(), bidValue, null);
        auctionService.placeBid(bid);

    }
}
