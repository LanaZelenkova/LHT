package edu.pht.chainofresppattern.handler;

import edu.pht.chainofresppattern.domain.Request;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractHandler implements Handler {

    protected int level;
    protected Handler next;

    public AbstractHandler(int level) {
        this.level = level;
    }

    @Override
    public Handler setNext(Handler next) {
        this.next = next;
        return next;
    }

    @Override
    public void handle(Request request, int priority) {

        if (priority <= this.level) {
            deepHandle(request);
        }
        if (next != null) {
            next.handle(request, priority);
        }
    }

    private void deepHandle(Request request) {
        String[] paragraphs = getDataToHandle(request);
        Map<String, Integer> statistics = new HashMap<>();
        for (String string : paragraphs) {
            if (!string.isEmpty() && !string.equals(Request.SPACE)) {
                if (statistics.keySet().contains(string)) {
                    statistics.put(string, statistics.get(string) + 1);
                } else {
                    statistics.put(string, 1);
                }
            }
        }
        outputResult(statistics);
    }

    private void outputResult(Map<String, Integer> statistics) {
        int count = 0;
        for (Map.Entry<String, Integer> entry : statistics.entrySet()) {
            int counter = entry.getValue();
            System.out.println(entry.getKey() + Request.EQUAL + counter);
            count += counter;
        }
        System.out.println("Total____________________________________________________________________________________");
        getTotalResult(count);
        System.out.println("_________________________________________________________________________________________");
    }

    public abstract String[] getDataToHandle(Request request);

    public abstract void getTotalResult(int count);
}
