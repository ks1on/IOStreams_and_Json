package main.second;

import java.io.*;

public class Tests {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/second/file.txt");
        UsersParser userParser = new UsersParser(file);

        System.out.println(userParser.usersToJsonFileParse());
    }
}
