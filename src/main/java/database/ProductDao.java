package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import model.Product;

public class ProductDao {

    public ArrayList<Product> listProducts() throws ClassNotFoundException {

        String SELECT_PRODUCTS_SQL = "SELECT * FROM products;";
        ArrayList<Product> products = new ArrayList<>();

        try {

            // carrega driver
            Class.forName("com.mysql.jdbc.Driver");
            // dados da conexão
            String connection = "jdbc:mysql://localhost/leilao";
            String user = "root", senha = "";
            // criando conexão
            Connection conn = DriverManager.getConnection(connection, user, senha);
            // cria statement para executar comando SQL
            PreparedStatement preparedStatement = conn.prepareStatement(SELECT_PRODUCTS_SQL);

            ResultSet set = preparedStatement.executeQuery();

            while (set.next()) {
                Product product = new Product(
                    set.getInt("product_id"),
                    set.getString("name"),
                    set.getBigDecimal("min_bid"), // Usar BigDecimal para valores monetários
                    set.getString("description"),
                    set.getString("image_url")
                );
                products.add(product);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }

        return products;

    }




    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while( t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
    
}