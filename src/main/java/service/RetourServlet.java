package service;

import mediatek2022.Document;
import mediatek2022.Mediatheque;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "RetourServlet", urlPatterns = "/retour")
public class RetourServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Document> docRendus = new ArrayList<>();
        for (Document doc : Mediatheque.getInstance().tousLesDocumentsDisponibles()) {
            if (!doc.disponible()){
                docRendus.add(doc);
            }
        }
        request.setAttribute("docRendus", docRendus);
        getServletContext().getRequestDispatcher("/WEB-INF/retourDocument.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idDoc = Integer.parseInt(request.getParameter("docRendu"));

        // idDoc = 0 -> sélécteur de base, donc pas de document(s)
        if (idDoc > 0) {
            Document document = Mediatheque.getInstance().getDocument(idDoc);
            document.retour();
            request.setAttribute("success", "Le document a ete retourne");
        }
        doGet(request,response);
    }
}
