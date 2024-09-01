package main.first;

import java.io.File;

public class Tests {
    public static void main(String[] args) {
        File file = new File("src/main/first/file.txt");

        FilePhoneNumbersUtils f = new FilePhoneNumbersUtils(file);

        System.out.println(f.put("086-850-5049", true));
        System.out.println(f.filePhonePrinter());

    }
}
