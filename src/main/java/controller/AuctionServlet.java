package controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Bids;
import model.BidsService;
import model.Product;
import model.ProductService;
import model.User;
import model.UserService;

@WebServlet("/auction")
public class AuctionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BidsService bidsService;
    private ProductService productService;
    private UserService userService;

    public void init() {
        bidsService = new BidsService();
        productService = new ProductService();
        userService = new UserService();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {

        int productId = Integer.parseInt(request.getParameter("product_id"));
        List<Bids> bids = bidsService.getBidsByProductId(productId);

        request.setAttribute("bids", bids);
      
        Product product = productService.getProductById(productId);
        request.setAttribute("product", product);

        List<String> usernames = new ArrayList<>();

        for(Bids bid : bids) {
            usernames.add(userService.getUsernameById(bid.getUserId()));
        }

        request.setAttribute("usernames", usernames);

        // Verifica se é uma requisição AJAX
        String requestedWith = request.getHeader("X-Requested-With");
        if ("XMLHttpRequest".equals(requestedWith)) {
            request.getRequestDispatcher("/bids-table.jsp").forward(request, response);
        }
        else {
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
        Bids bid = new Bids();
        bid.setProductId(productId);
        bid.setUserId(user.getUserId());
        bid.setBidValue(bidValue);

        bidsService.placeBid(bid);

    }
}
