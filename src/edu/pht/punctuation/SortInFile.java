package edu.pht.punctuation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;

public class SortInFile {

    private static final int MIN = 1;
    private static final int MAX = 100;
    private static final String FILE_NAME = "test2.txt";
    private static final String EMPTY = "";
    private static final String SPACE = " ";

    public static void main(String[] args) {
        try {
            write(generateRandomArray());
            write(sort(read()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int[] generateRandomArray() {
        Random random = new Random();
        int size = randomInt(random);
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = randomInt(random);
        }
        return array;
    }

    private static int randomInt(Random random) {
        return random.nextInt((MAX - MIN) + 1) + MIN;
    }

    private static void write(int... array) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));
        PrintWriter printWriter = new PrintWriter(writer);
        for (int i : array) {
            printWriter.println(i);
        }
        printWriter.close();
    }

    private static String read() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
        String line = null;
        StringBuilder result = new StringBuilder();
        String separator = SPACE;
        while((line = reader.readLine()) != null) {
            result.append(line);
            result.append(separator);
        }
        result.deleteCharAt(result.length()-1);
        return result.toString();
    }

    private static int[] sort(String intsToSort) {
        String[] ints = intsToSort.split(SPACE);
        int[] result = new int[ints.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.parseInt(ints[i]);
        }
        Arrays.sort(result);
        return result;
    }
}
