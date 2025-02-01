package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")  
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // evita criar uma nova sessão se não houver uma
        HttpSession session = request.getSession(false);
        if (session != null) {
            // invalida a sessão, removendo todos os atributos
            session.invalidate(); 
        }

        // redireciona para a página de login
        response.sendRedirect("products"); 
    }
}