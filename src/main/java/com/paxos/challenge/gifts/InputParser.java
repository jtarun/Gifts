package com.paxos.challenge.gifts;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

public class InputParser {

    public static List<Gift> getGifts(String fileName) {

        LineNumberReader lineReader = getLineReader(fileName);

        List<Gift> gifts = new ArrayList<>();

        try {
            String line = lineReader.readLine();
            while (line != null) {
                String[] parts = line.split(",");
                String id = parts[0].trim();
                int price = getPriceValue(parts[1]);

                gifts.add(new Gift(id, price));

                line = lineReader.readLine();
            }
        } catch (IOException ex) {
            throw new RuntimeException("Error while reading file " + fileName, ex);
        }

        return gifts;
    }

    public static int getPriceValue(String priceStr) {
        try {
            return Integer.valueOf(priceStr.trim());
        } catch (NumberFormatException ex) {
            throw new RuntimeException("Not a valid price: " + priceStr, ex);
        }
    }

    private static LineNumberReader getLineReader(String fileName) {
        FileReader fileReader;
        try {
            fileReader = new FileReader(fileName);
        } catch (FileNotFoundException ex) {
            throw new RuntimeException("File " + fileName + " is missing!!!", ex);
        }

        return new LineNumberReader(fileReader);
    }

}
