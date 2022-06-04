package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import launcher.PasswordManagerLauncher;
import model.PasswordManagerModel;
import user.InternetAccount;
import user.User;
import java.io.IOException;

 //password manager window.


public class MainController {
    Stage addPassStage;
    User user;

    @FXML
    Button addNewPasswordButton;

    @FXML
    VBox passwordsVBox;

    @FXML
    private Button logoutButton;

    @FXML
    BorderPane borderPane;

    public void initialize(PasswordManagerModel model) {
        System.out.println("Model transferred from login window to main window");
        System.out.println("This account has these domains stored:");

        this.user = model.getCurrentUser();
        for (InternetAccount internetAccount : user.getInternetAccounts().values()) {
            addPasswordHBox(internetAccount);
        }
    }

   //window for adding new passwords.

    public void addNewPasswordButtonAction() {
        System.out.println("Adding new password...");
        try {
            String viewPath = PasswordManagerModel.VIEW_DIRECTORY + "AddPassView.fxml";
            FXMLLoader loader = new FXMLLoader(getClass().getResource(viewPath));
            addPassStage = new Stage();
            Parent parent = loader.load();
            AddPassController addPassController = loader.getController();
            addPassController.initialize(this);
            addPassStage.setTitle("Add Password");
            addPassStage.setScene(new Scene(parent));
            addPassStage.setResizable(false);
            addPassStage.show();
            borderPane.setDisable(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void logoutButtonAction() throws Exception {
        logoutButton.getScene().getWindow().hide();
        PasswordManagerLauncher pml = new PasswordManagerLauncher();
        pml.start(new Stage());
    }
    void addPasswordHBox(InternetAccount internetAccount) {
        try {
            String hboxViewDir = PasswordManagerModel.VIEW_DIRECTORY + "UserHBoxView.fxml";
            FXMLLoader loader = new FXMLLoader(getClass().getResource(hboxViewDir));
            HBox hbox = loader.load();
            UserHBoxController userHBoxController = loader.getController();
            userHBoxController.initialize(internetAccount);
            passwordsVBox.getChildren().add(hbox);
            ((Label) hbox.getChildren().get(0)).setText(internetAccount.getDomain());
            HBox subHBox = (HBox) hbox.getChildren().get(1);
            ((Button) (subHBox.getChildren().get(0))).setText(internetAccount.getUserName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
