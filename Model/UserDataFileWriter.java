package v2.Model;

import java.io.FileWriter;
import java.io.IOException;

public class UserDataFileWriter {
    public static void writeUserDataToFile(UserDataModel userData) {
        try (FileWriter writer = new FileWriter(userData.getLastName() + ".txt", true)) {
            writer.write( userData.getLastName());
            writer.write(userData.getFirstName() + " ");
            writer.write(userData.getMiddleName() + " ");
            writer.write(userData.getBirthDate() + " ");
            writer.write(userData.getPhoneNumber() + " ");
            writer.write(userData.getGender() + "\n");
            writer.close();
            System.out.println("Данные успешно записаны в файл");
        } catch (IOException e) {
            System.out.println("Ошибка при записи данных в файл: " + e.getMessage());
        }
    }
}
