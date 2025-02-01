<%@page import="java.util.ArrayList"%>
<%@page import="model.Product"%>
<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%

User user = (User) session.getAttribute("user");
String error = (String) request.getAttribute("error");
ArrayList<Product> products = (ArrayList<Product>) request.getAttribute("products");

%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Leilão</title>
    </head>
    <body>

        <% if (error != null) { %>
            <p style="color:red;"><%= error %></p>
        <% }  else { %>

            <% if (user != null) { %>
                <p>Olá, <%= user.getUsername() %></p>
                <a href="logout">Logout</a>
            <% } else { %>
                <a href="./login.jsp">Login</a>
            <% } %>
    
            <h1>Lista de produtos</h1>
            <% if (products != null)  { %>
                <% for(Product product : products) { %>
                    <div>
                        <a href="auction?product_id=<%=product.getProductId()%>">
                            <%= product.getName()%>: R$<%= product.getMinBid() %>
                        </a>
                    </div>
                <% } %>
            <% } else { %>
                <p>Nenhum produto em leilão...</p>
            <% } %>            
        <% } %>        
        
    </body>
</html>
