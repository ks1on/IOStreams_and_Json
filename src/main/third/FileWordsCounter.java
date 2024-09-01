package main.third;

import java.io.*;
import java.util.*;

public class FileWordsCounter {
    private File file;

    public FileWordsCounter(File file) {
        this.file = file;
    }

    public String printWordsCount() {
        ArrayList<Map.Entry<String, Integer>> wordsFreq;
        String res = "";
        try {
            wordsFreq = new ArrayList<>(getWordsCount().entrySet());
            Comparator<Map.Entry<String, Integer>> comparator = new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return o2.getValue().compareTo(o1.getValue());
                }
            };
            wordsFreq.sort(comparator);
            res = wordsFreq.toString();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return res;
    }


    private Map<String, Integer> getWordsCount() throws IOException {
        Map<String, Integer> res = new HashMap<>();
        String[] words = getArrayOfWordsFromFile();
        for (String word : words) {
            res.put(word, res.getOrDefault(word, 0) + 1);
        }
        return res;
    }

    private String[] getArrayOfWordsFromFile() throws IOException {
        StringJoiner sj = new StringJoiner(" ");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            sj.add(line);
        }
        return sj.toString().split(" ");
    }
}
