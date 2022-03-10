package service;

import mediatek2022.Utilisateur;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "MenuServlet", urlPatterns = "/menu")
public class MenuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        Utilisateur user = (Utilisateur) session.getAttribute("user");

        if (user==null){
            response.sendRedirect("/login");
        } else if (user.isBibliothecaire()){
            getServletContext().getRequestDispatcher("/WEB-INF/espaceBibliothecaire.jsp").forward(request,response);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/espaceAbonne.jsp").forward(request,response);
        }
    }
}
