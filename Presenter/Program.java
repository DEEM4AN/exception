package v2.Presenter;

import v2.Model.UserDataModel;
import v2.View.UserInputView;

public class Program {
    public static void main(String[] args) {
        UserInputView view = new UserInputView();
        UserDataModel model = new UserDataModel("", "", "", "", 0, ' ');

        UserDataPresenter presenter = new UserDataPresenter(view, model);
        presenter.getUserData();
    }
}