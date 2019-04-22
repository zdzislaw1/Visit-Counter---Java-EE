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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String sessionId=session.getId();

        if (session.isNew()) {
            vc.newSession(sessionId);
        } else {
            sessionId=session.getId();
            vc.incrementSession(sessionId);
        }
        vc.incrementGlobalVisit();



        getServletContext().setAttribute("VisitGlobal", vc.getVisitGlobal());
        request.setAttribute("VisitOneSession", vc.getVisitSession(sessionId));

        System.out.println("Session Id: " + sessionId + " --- " + "session_nr" + " - " + vc.getVisitSession(sessionId) + "---" + " global_visit" + " - " +vc.getVisitGlobal() );


        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}