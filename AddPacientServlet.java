
package com.medicalsystem.controller;

import com.medicalsystem.dao.PacientDAO;
import com.medicalsystem.model.Pacient;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/add-pacient")
public class AddPacientServlet extends HttpServlet {
    private PacientDAO dao = new PacientDAO();

    @Override
    public void init() {
        try { dao.init(); } catch (Exception e) { e.printStackTrace(); }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Pacient p = new Pacient();
            p.setEmri(req.getParameter("emri"));
            p.setMbiemri(req.getParameter("mbiemri"));
            p.setMosha(Integer.parseInt(req.getParameter("mosha")));
            p.setGjinia(req.getParameter("gjinia"));
            p.setHistorikuMjekesor(req.getParameter("historiku"));
            dao.save(p);
            resp.sendRedirect("list-pacient");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
