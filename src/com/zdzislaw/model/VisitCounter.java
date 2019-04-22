package com.zdzislaw.model;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import javax.servlet.http.HttpSession;

public class VisitCounter {
    private int visitTogether;
    int visitSession;
    Map<HttpSession, Integer> sessions = new HashMap();
     {
        setVisitTogether(0);
        visitSession=0;
    }

    public int getVisitTogether() {
        return this.visitTogether;
    }

    public void setVisitTogether(int visitTogether) {
        this.visitTogether=visitTogether;
    }

    public VisitCounter() {
    }

    public void newSession(HttpSession session) {
        sessions.put(session, 1);
    }

    public void addOneToSession(HttpSession session) {
        visitSession = (Integer)sessions.get(session) + 1;
        this.sessions.put(session, visitSession);
    }

    public int getNumberOfVisitInOneSession(HttpSession session) {
        int numberOfVisitInOneSession = (Integer)sessions.get(session);
        return numberOfVisitInOneSession;
    }
}
