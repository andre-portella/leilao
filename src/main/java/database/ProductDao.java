package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Product;

public class ProductDao {

    public ArrayList<Product> selectProducts() throws ClassNotFoundException {

        String SELECT_PRODUCTS_SQL = "SELECT * FROM products;";
        ArrayList<Product> products = new ArrayList<>();

        try {
            // obtém conexão
            Connection conn = ConnectionFactory.getConnection();

            // executa query
            PreparedStatement stmt = conn.prepareStatement(SELECT_PRODUCTS_SQL);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getInt("product_id"));
                product.setName(rs.getString("name"));
                product.setMinBid(rs.getBigDecimal("min_bid"));
                product.setDescription(rs.getString("description"));
                product.setImageUrl(rs.getString("image_url"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;

    }



    public Product getProduct(int productId) throws ClassNotFoundException {

        String GET_PRODUCT_SQL = "SELECT * FROM products WHERE product_id = ?;";
        try {
            
            Connection conn = ConnectionFactory.getConnection();

            // executa query
            PreparedStatement stmt = conn.prepareStatement(GET_PRODUCT_SQL);

            stmt.setInt(1, productId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getInt("product_id"));
                product.setName(rs.getString("name"));
                product.setMinBid(rs.getBigDecimal("min_bid"));
                product.setDescription(rs.getString("description"));
                product.setImageUrl(rs.getString("image_url"));

                return product;
            }
            return null;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
    
}