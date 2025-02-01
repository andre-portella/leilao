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
                Product product = new Product(
                    rs.getInt("product_id"),
                    rs.getString("name"),
                    rs.getBigDecimal("min_bid"),
                    rs.getString("description"),
                    rs.getString("image_url")
                );
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;

    }
    
}