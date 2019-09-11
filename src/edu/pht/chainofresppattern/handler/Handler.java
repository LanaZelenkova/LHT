package edu.pht.chainofresppattern.handler;

import edu.pht.chainofresppattern.domain.Request;

public interface Handler {

    Handler setNext(Handler next);

    void handle(Request request, int priority);
}
