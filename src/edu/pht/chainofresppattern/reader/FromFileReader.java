package edu.pht.chainofresppattern.reader;

import edu.pht.chainofresppattern.domain.Request;
import edu.pht.chainofresppattern.domain.Response;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FromFileReader implements Reader {
    @Override
    public Response read() {
        Response response = new Response();
        FileReader fileReader;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader("test.txt");
            bufferedReader = new BufferedReader(fileReader);
            String result = Request.EMPTY;
            while(bufferedReader.read() != -1) {
                result += bufferedReader.readLine() + Request.SPACE;
            }
            response.setResponse(result);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return response;
    }
}
