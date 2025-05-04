package demoshop.utils;

import demoshop.models.User;
import org.testng.annotations.DataProvider;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.UUID;

public class DataProviders {

    @DataProvider(name = "addNewUser")
    public static Iterator<Object[]> addNewUser() throws IOException {
        List<Object[]> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(
                new FileReader("src/test/resources/contactdata.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] split = line.split(",");
                String firstName = split[0];
                String lastName  = split[1];
                String baseEmail = split[2];
                String password  = split[3];
                String[] parts = baseEmail.split("@", 2);
                String uniqueEmail = parts[0] + "_" + UUID.randomUUID() + "@" + parts[1];
                list.add(new Object[]{
                        firstName,
                        lastName,
                        uniqueEmail,
                        password
                });
            }
        }
        return list.iterator();
    }

    @DataProvider(name = "addNewUserWithCsv")
    public static Iterator<Object[]> addNewUserWithCsv() throws IOException {
        List<Object[]> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(
                new FileReader("src/test/resources/contactdata.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] split = line.split(",");
                String firstName = split[0];
                String lastName  = split[1];
                String baseEmail = split[2];
                String password  = split[3];
                String[] parts = baseEmail.split("@", 2);
                String uniqueEmail = parts[0] + "_" + UUID.randomUUID() + "@" + parts[1];

                User user = new User()
                        .setFirstName(firstName)
                        .setLastName(lastName)
                        .setEmail(uniqueEmail)
                        .setPassword(password)
                        .setConfirmPassword(password);
                list.add(new Object[]{ user });
            }
        }
        return list.iterator();
    }
}
