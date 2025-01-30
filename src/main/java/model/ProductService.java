package model;

import java.util.ArrayList;
import model.Product;
import database.ProductDao;

public class ProductService {
    private ProductDao productDAO = new ProductDao();
    
    public ArrayList<Product> listProducts() throws Exception{
        // é possível inserir lógica de negócio aqui, para tratar os bens antes de retornálos-los ao controlador
        
        ArrayList<Product> products = productDAO.listProducts();
        
        if (products.isEmpty()) {
            // Aqui você pode adicionar um comportamento, como lançar uma exceção
            // ou apenas retornar uma lista vazia, dependendo do caso.
            throw new Exception("Nenhum produto encontrado.");
        }

        return products;
    }
}
