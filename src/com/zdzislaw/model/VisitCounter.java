package com.zdzislaw.model;

import java.lang.reflect.AnnotatedType;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.servlet.http.HttpSession;

public class VisitCounter {
    private static AtomicInteger visitGlobal;
    private AtomicInteger visitSession;

     ConcurrentHashMap<String, AtomicInteger> sessions=new ConcurrentHashMap<>();


    public VisitCounter() {
        visitGlobal=new AtomicInteger(0);
        visitSession=new AtomicInteger(1);
    }

    public void setVisitGlobal(int visitGlobal) {
        this.visitGlobal.set(visitGlobal);
    }

    public AtomicInteger getVisitGlobal() {
        return visitGlobal;
    }

    public void setVisitSession(int visitSession) {
        this.visitSession.set(visitSession);
    }

    public AtomicInteger getVisitSession(String sessionId) {
        return sessions.get(sessionId);
    }




    public void newSession(String sessionId) {
        sessions.put(sessionId, new AtomicInteger(1));
    }

    public void incrementSession(String sessionId) {
        setVisitSession (sessions.get(sessionId).incrementAndGet());

        sessions.put(sessionId, sessions.get(sessionId));
    }
    public void incrementGlobalVisit(){
        visitGlobal.getAndIncrement();
    }


}
