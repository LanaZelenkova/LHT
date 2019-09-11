package edu.pht.chainofresppattern.handler;

import edu.pht.chainofresppattern.domain.Request;

import java.util.HashMap;
import java.util.Map;

public class SentenceHandler extends AbstractHandler {

    public SentenceHandler(int level) {
        super(level);
    }

    @Override
    public String[] getDataToHandle(Request request) {
        return request.getResponse().getResponse().split(Request.REGEX_FOR_CLAUSES);
    }

    @Override
    public void getTotalResult(int count) {
        System.out.println("Sentences" + Request.EQUAL + count);
    }
}

