package service;

import mediatek2022.Mediatheque;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AjoutServlet", urlPatterns = "/ajout")
public class AjoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/ajoutDocument.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        int type = Integer.parseInt(request.getParameter("type"));

        if (nom.equals("")){
            request.setAttribute("error","tous les champs doivent etre remplis");
        }else {
            Mediatheque.getInstance().ajoutDocument(type,nom);
            request.setAttribute("success","Ajoute avec succes!");
        }
        getServletContext().getRequestDispatcher("/WEB-INF/ajoutDocument.jsp").forward(request,response);
    }
}
