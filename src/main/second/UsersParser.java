package main.second;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UsersParser {
    File file;

    public UsersParser(File file) {
        this.file = file;
    }

    public File usersToJsonFileParse() {
        File user = new File("src/files/user.json");
        user.getParentFile().mkdirs();
        try (FileWriter fileWriter = new FileWriter(user)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(fileToUser(), fileWriter);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return user;
    }

    private List<User> fileToUser() throws IOException {
        List<User> users = users = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        reader.readLine();

        while ((line = reader.readLine()) != null) {
            String[] data = line.split("\\s+");
            String name = data[0];
            String age = data[1];
            users.add(new User(name, Integer.parseInt(age)));
        }

        return users;
    }
}
