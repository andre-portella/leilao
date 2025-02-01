package model;

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
}
