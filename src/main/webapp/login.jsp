<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%

String error = (String) request.getAttribute("error");

%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <a href="products">Produtos</a>
        <h1>Login</h1>
        <form action="login" method="POST">
            <% if (error != null) { %>
                <p style="color:red;"><%= error %></p><br>
            <% } %>
            Usuário: <input type="text" name="username"><br><br>
            Senha: <input type="password" name="password"><br><br>
            <button type="submit">Enviar</button>
        </form>

    </body>
</html>
