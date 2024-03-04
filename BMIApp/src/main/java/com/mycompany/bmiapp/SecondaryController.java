package com.mycompany.bmiapp;

import java.io.IOException;
import javafx.fxml.FXML;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
        int b = 3;
        boolean result;
        if(b<0)
            result = true;
    }
}