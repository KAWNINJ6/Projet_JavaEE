package service;

import mediatek2022.Document;
import mediatek2022.Mediatheque;
import mediatek2022.Utilisateur;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EmpruntServlet", urlPatterns = "/emprunt")
public class EmpruntServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Document> docEmpruntes = new ArrayList<>();
        for (Document doc : Mediatheque.getInstance().tousLesDocumentsDisponibles()) {
            if (doc.disponible()){
                docEmpruntes.add(doc);
            }
        }
        request.setAttribute("docEmpruntes", docEmpruntes);
        getServletContext().getRequestDispatcher("/WEB-INF/empruntDocument.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session= request.getSession(true);
        Utilisateur user = (Utilisateur) session.getAttribute("user");

        int idDoc = Integer.parseInt(request.getParameter("docEmprunte"));

        // idDoc = 0 -> sélécteur de base, donc pas de document(s)
        if (idDoc > 0) {
            Document document = Mediatheque.getInstance().getDocument(idDoc);
            try {
                document.emprunt(user);
                request.setAttribute("success", "Le document a ete emprunte");
            } catch (Exception e) {
                request.setAttribute("error", "Ce document a deja ete emprunte");
            }
        }
        doGet(request,response);
    }
}
