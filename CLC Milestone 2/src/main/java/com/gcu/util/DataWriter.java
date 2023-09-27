package com.gcu.util;

import java.io.FileWriter;
import java.io.IOException;
import org.springframework.stereotype.Component;
import com.gcu.model.UserModel;

@Component
public class DataWriter {
    private static final String FILE_PATH = "/Applications/SpringToolSuite4.app/Contents/MacOS/workspaceCST-339/SampleMilestone/src/main/java/com/gcu/util/Text File.txt";
    public void writeData(UserModel userModel) {
        try (FileWriter writer = new FileWriter(FILE_PATH, true)) {
            String formattedData = String.format(
                    "First Name: %s\nLast Name: %s\nEmail: %s\nPhone Number: %s\nUsername: %s\nPassword: %s\n\n",
                    userModel.getFirstName(), userModel.getLastName(), userModel.getEmail(),
                    userModel.getPhoneNumber(), userModel.getUsername(), userModel.getPassword());
            writer.write(formattedData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
