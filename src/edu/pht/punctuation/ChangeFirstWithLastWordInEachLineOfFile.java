package edu.pht.punctuation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import static java.util.stream.Collectors.joining;

public class ChangeFirstWithLastWordInEachLineOfFile {

    private static final String FILE_NAME = "source.txt";
    private static final String EMPTY = "";
    private static final String SPACE = " ";
    private static final String NEW_LINE = "\n";

    public static void main(String[] args) {
        try {
            write(changeFirstWithLastWordInEachLine(read()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String read() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
        String line = null;
        StringBuilder result = new StringBuilder();
        String separator = NEW_LINE;
        while((line = reader.readLine()) != null) {
            result.append(line);
            result.append(separator);
        }
        result.deleteCharAt(result.length()-1);
        return result.toString();
    }

    private static String changeFirstWithLastWordInEachLine(String file) {
        String[] linesFromFile = file.split(NEW_LINE);
        String lineToFile;
        StringBuilder result = new StringBuilder();
        for (String line : linesFromFile) {
            lineToFile = change(line.split(SPACE));
            result.append(lineToFile);
            result.append(NEW_LINE);
        }
        return result.toString();
    }

    private static String change(String[] words) {
        String temp;
        if (words.length >= 2) {
            temp = words[0];
            words[0] = words[words.length - 1];
            words[words.length - 1] = temp;
        }
        return Arrays.stream(words).collect(joining(SPACE));
    }

    private static void write(String stringToFile) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));
        PrintWriter printWriter = new PrintWriter(writer);
        printWriter.println(stringToFile);
        printWriter.close();
    }
}
