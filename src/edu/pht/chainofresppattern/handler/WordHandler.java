package edu.pht.chainofresppattern.handler;

import edu.pht.chainofresppattern.domain.Request;

import java.util.HashMap;
import java.util.Map;

public class WordHandler extends AbstractHandler {

    public WordHandler(int level) {
        super(level);
    }

    @Override
    public String[] getDataToHandle(Request request) {
        return request.getResponse().getResponse().split(Request.REGEX_FOR_WORDS);
    }

    @Override
    public void getTotalResult(int count) {
        System.out.println("Words" + Request.EQUAL + count);
    }
}
