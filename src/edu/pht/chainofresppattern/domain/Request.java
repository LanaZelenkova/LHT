package edu.pht.chainofresppattern.domain;

public class Request {

    public static final String EMPTY = "";
    public static final String SPACE = " ";
    public static final String EQUAL = " => ";
    public static final String REGEX_FOR_PARAGRAPHS = ".   ";
    public static final String REGEX_FOR_CLAUSES = "[.?!]";
    public static final String REGEX_FOR_WORDS = "[ :;,.\"«»()?!—]";

    private Response response;

    public Request() {
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
