<%@page import="java.util.List"%>
<%@page import="model.Auction"%>
<%@page import="model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% List<Auction> bids = (List<Auction>) request.getAttribute("bids"); %>
<% Product product = (Product) request.getAttribute("product"); %>

<% if (bids != null && !bids.isEmpty()) { %>
    <table border="1">
        <tr>
            <th>Usuário</th>
            <th>Valor do Lance</th>
            <th>Data/Hora</th>
        </tr>
        <% for (Auction bid : bids) { %>
            <tr>
                <td><%= bid.getUserId() %></td>
                <td>R$ <%= bid.getBidValue() %></td>
                <td><%= bid.getBidTime() %></td>
            </tr>
        <% } %>
    </table>
<% } else { %>
    <p>Nenhum lance realizado ainda. O valor mínimo do produto é <%=product.getMinBid() %> </p>
<% } %>