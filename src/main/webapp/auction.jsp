<%@page import="model.User"%>
<%@page import="model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    User user = (User) session.getAttribute("user");
    Product product = (Product) request.getAttribute("product");
    double minBid = product.getMinBid().doubleValue(); 
%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><%=product.getName() %></title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script>
        var productId = <%= product.getProductId() %>;
        var minBid = <%= minBid %>;
    </script>
    <script src="auction.js"></script>
</head>
<body>
    <a href="/leilao">Voltar</a>
    <h1>Leilão do Produto: <%=product.getName() %></h1>

    <!-- Formulário de lance -->
    <% if (user != null) { %>
        <h2>Faça seu lance</h2>
        <p>O valor mínimo do produto é R$ <%= String.format(java.util.Locale.US, "%.2f", minBid) %></p>
        <form method="post">
            <input type="hidden" name="product_id" value="<%= product.getProductId() %>">
            <label for="bid_value">Valor do Lance:</label>
            <input type="number" name="bid_value" id="bid_value" required>
            <button type="submit">Enviar Lance</button>
            <span id="bid-message" style="display:none; margin-left: 10px;"></span>
        </form>
    <% } else { %>
        <p>Você precisa estar logado para fazer um lance. <a href="login.jsp">Login</a></p>
    <% } %>

    <!-- Tabela de lances -->
    <h2>Lances Atuais</h2>
    <div id="bids-list">
        <jsp:include page="/bids-table.jsp" />
    </div>
</body>
</html>
