<%@page import="java.util.List"%>
<%@page import="model.Bids"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% List<Bids> bids = (List<Bids>) request.getAttribute("bids"); %>
<% List<String> usernames = (List<String>) request.getAttribute("usernames"); %>

<% if (bids != null && !bids.isEmpty()) { %>
    <table border="1">
        <tr>
            <th>Usuário</th>
            <th>Valor do Lance</th>
            <th>Data/Hora</th>
        </tr>
        <% for (int i = 0; i < bids.size(); i++) { 
            Bids bid = bids.get(i);
            String username = usernames.get(i);    
        %>
            <tr>
                <td><%= username %></td>
                <td>R$ <%= bid.getBidValue() %></td>
                <td><%= bid.getBidTime() %></td>
            </tr>
        <% } %>
    </table>
<% } else { %>
    <p>Nenhum lance visível ainda.</p>
<% } %>