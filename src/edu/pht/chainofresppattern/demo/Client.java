package edu.pht.chainofresppattern.demo;

import edu.pht.chainofresppattern.domain.Request;
import edu.pht.chainofresppattern.handler.Handler;
import edu.pht.chainofresppattern.handler.Level;
import edu.pht.chainofresppattern.handler.ParagraphHandler;
import edu.pht.chainofresppattern.handler.SentenceHandler;
import edu.pht.chainofresppattern.handler.WordHandler;
import edu.pht.chainofresppattern.reader.FromFileReader;
import edu.pht.chainofresppattern.reader.Reader;

public class Client {
    public static void main(String[] args) {
        Reader reader = new FromFileReader();
        Request request = new Request();
        request.setResponse(reader.read());
        Handler handler, handler1, handler2;
        handler = new ParagraphHandler(Level.PARAGRAPH);
        handler1 = handler.setNext(new SentenceHandler(Level.SENTENCE));
        handler2 = handler1.setNext(new WordHandler(Level.WORD));
        handler.handle(request, Level.PARAGRAPH);
    }
}
