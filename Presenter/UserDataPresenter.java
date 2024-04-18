package v2.Presenter;

import v2.Model.InvalidDataFormatException;
import v2.Model.UserDataFileWriter;
import v2.Model.UserDataModel;
import v2.View.UserInputView;

import java.io.FileWriter;
import java.io.IOException;

// Presenter
public class UserDataPresenter {
    private UserInputView view;
    private UserDataModel model;

    public UserDataPresenter(UserInputView view, UserDataModel model) {
        this.view = view;
        this.model = model;
    }

    public void getUserData() {
        try {
            model = UserDataModel.parseUserData(view.getUserDataFromInput());
            UserDataFileWriter.writeUserDataToFile(model);
            // Вызов методов для сохранения, обновления или отображения данных
        } catch (InvalidDataFormatException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}


