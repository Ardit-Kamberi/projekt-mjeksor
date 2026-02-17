
package com.medicalsystem.controller;

import com.medicalsystem.dao.PacientDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/list-pacient")
public class ListPacientServlet extends HttpServlet {
    private PacientDAO dao = new PacientDAO();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("pacientet", dao.findAll());
            req.getRequestDispatcher("pacient-list.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
