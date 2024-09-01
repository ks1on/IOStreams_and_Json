package main.first;

import java.io.*;
import java.nio.Buffer;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FilePhoneNumbersUtils {
    private File numbers;

    public FilePhoneNumbersUtils(File numbers) {
        this.numbers = numbers;
    }

    public String filePhonePrinter() {
        StringJoiner sj = new StringJoiner("\n");
        try (BufferedReader scanner = new BufferedReader(new FileReader(numbers))) {
            String line;
            while ((line = scanner.readLine()) != null) {
                if (numberChecker(line)) {
                    sj.add(line);
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return sj.toString();
    }

    public boolean put(String number, boolean append) {
        if (numberChecker(number)) {
            try(OutputStream os = new FileOutputStream(numbers, append)) {
                os.write(("\n" + number).getBytes());
                return true;
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
        return false;
    }

    public boolean numberChecker(String number) {
        Pattern p =  Pattern.compile("^[0-9]{3}-[0-9]{3}-[0-9]{4}$");
        Pattern p2 =  Pattern.compile("^\\([0-9]{3}\\)[ \t][0-9]{3}-[0-9]{4}$");

        Matcher m = p.matcher(number);
        Matcher m2 = p2.matcher(number);

        return m.find() || m2.find();
    }

}
