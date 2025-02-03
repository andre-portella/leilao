package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Product;
import database.ProductDao;

public class ProductService {
    private ProductDao productDAO = new ProductDao();
    
    public ArrayList<Product> listProducts(){
        try {
            ArrayList<Product> products =  productDAO.selectProducts();
            return products;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Product getProductById(int productId) {

        try {
            Product product = productDAO.getProduct(productId);
            return product;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
