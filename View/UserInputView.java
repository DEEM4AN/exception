package v2.View;

import v2.Model.UserDataModel;

import java.util.Scanner;

public class UserInputView {
    public String[] getUserDataFromInput() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите Фамилию Имя Отчество дата_рождения(dd.mm.yyyy) номер_телефона пол, разделенные пробелом: ");
            String input = scanner.nextLine();
            String[] data = input.split(" ");
            if (data.length != 6) {
                System.out.println("Некорректное количество данных. Пожалуйста, введите данные еще раз.");
            } else {
                // Проверка данных и создание объекта UserDataModel
                return data;
            }
        }
    }
}