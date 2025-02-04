package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import model.UserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private UserService userService;

    public void init() {
        userService = new UserService(); 
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// recebe usuário e senha do request
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // utiliza serviço do User pra checar credenciais
        User authenticated = userService.authenticate(username, password);

        if (authenticated == null) {
            // volta para página de login com erros
            request.setAttribute("error", "Usuário ou senha inválidos");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            // cria sessão com usuário autenticado e uma nova requisição para página de produtos
            HttpSession session = request.getSession();
            session.setAttribute("user", authenticated);
            response.sendRedirect("products");
        }
	}

}