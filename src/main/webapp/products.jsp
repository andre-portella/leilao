<%@page import="java.util.ArrayList"%>
<%@page import="model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Produtos</title>
    </head>
    <body>
        <h1>Lista de produtos</h1>
        <% 
            String error = (String) request.getAttribute("error");
            if (error != null) {
                out.println("<h3>" + error + "</h3>");
            } else {
                ArrayList<Product> products = (ArrayList<Product>) request.getAttribute("products");
        %>
        
            <% for(Product product : products) { %>
                <div>
                    <a href="auction?product_id=<%=product.getProductId()%>">
                        <%= product.getName()%>: R$<%= product.getMinBid() %>
                    </a>
                </div>
            <% } %>
        <% } %>
    </body>
</html>
