package com.zdzislaw.controller;

import com.zdzislaw.model.VisitCounter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(
        name = "Servlet",
        urlPatterns = {"/"}
)
public class Servlet extends HttpServlet {
    VisitCounter vc = new VisitCounter();
    public Servlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String sessionId=session.getId();

        if (session.isNew()) {
            vc.newSession(session);
        } else {
            vc.addOneToSession(session);
        }
        System.out.printf("Session ID - %s ::: %d , global ::: %d \n",sessionId, vc.getNumberOfVisitInOneSession(session), vc.getVisitTogether());
        getServletContext().setAttribute("VisitTogether", vc.getVisitTogether());
        request.setAttribute("VisitOneSession", vc.getNumberOfVisitInOneSession(session));
        vc.setVisitTogether(vc.getVisitTogether() + 1);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}