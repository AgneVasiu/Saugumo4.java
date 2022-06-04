package controller;

import javafx.scene.layout.HBox;
import user.InternetAccount;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

//HBoxs


public class UserHBoxController extends HBox {

    private InternetAccount internetAccount;

    public void initialize(InternetAccount internetAccount) { this.internetAccount = internetAccount; }

    public void copyUsernameButtonOnAction() { copy(internetAccount.getUserName()); }

    public void copyPasswordButtonOnAction() { copy(internetAccount.getPassword()); }

    private void copy(String string) {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(new StringSelection(string), null);
    }

    public void buttonOnEnter() {

    }

    public void buttonOnExit() {

    }

}