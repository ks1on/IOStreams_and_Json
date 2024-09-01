package main.third;

import java.io.File;

public class Tests {
    public static void main(String[] args) {
        File file = new File("src/main/third/words.txt");
        FileWordsCounter f = new FileWordsCounter(file);

        System.out.println(f.printWordsCount());
    }
}
